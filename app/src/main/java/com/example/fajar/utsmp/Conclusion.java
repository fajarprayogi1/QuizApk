package com.example.fajar.utsmp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Conclusion extends AppCompatActivity {
    TextView Tvconc;
    Button BtnDone;
    final String TAG = "Conclusion";
    private FirebaseFirestore db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_conclusion);
        Tvconc = findViewById(R.id.Tvconc);
        BtnDone = findViewById(R.id.BtnDone);
        cobaAmbil();
        BtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Conclusion.this);
                alertDialogBuilder.setTitle("Ingin mengulang ?");


                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Conclusion.this, MainActivity.class);
                        startActivity(i);
                    }
                });
                alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    private void cobaAmbil(){
        String str;
        str = getIntent().getExtras().getString("KODE_DATABASE");
        //mProgress.setMessage("Load Data");
        //mProgress.show();
        Log.d("Conclusion", str);
        DocumentReference docRef = db.collection("pertanyaan").document(str);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    String scores = task.getResult().getString("nilai");
                    if (task.isSuccessful()) {
                    Log.d("INI SCORES : ", scores);
                    int nilai = Integer.parseInt(scores);
                    //Tvconc.setText(""+ Int + "%");
                    if (nilai <= 20){
                        Tvconc.setText(nilai + "%");
                    }else if (nilai >= 25 && nilai <= 50){
                        Tvconc.setText(nilai + "%");
                    }else  {
                        Tvconc.setText(nilai + "%");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

//    public void getAnswer(String nilai){
//
////        //Tvconc.setText(""+ Int + "%");
////        if (nilai1 <= 20){
////            Tvconc.setText(nilai1 + "%" + "anda bukan koruptor");
////        }else if (nilai1 >= 25 && nilai1 <= 50){
////                Tvconc.setText(nilai1 + "%"+"Anda berbakat jadi koruptor");
////        }else  {
////            Tvconc.setText(nilai1 + "%" + "Anda koruptor");
////        }
//    }
}
