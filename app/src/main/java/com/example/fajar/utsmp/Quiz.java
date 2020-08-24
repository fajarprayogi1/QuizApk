package com.example.fajar.utsmp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fajar.utsmp.Library.Question;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {
    private Question mQuestion = new Question();
    private String[] quiz = new String[6];
    private String[] kode = new String[5];
    private int mQuestionNumber = 0;
    private TextView mQuestionView;
    Button choice1, choice2, choice3;
    int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionView = (TextView) findViewById(R.id.questionText);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);
        updateQuestion();
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quiz[mQuestionNumber] = choice1.getText().toString();
                if (mQuestionNumber == 1) {
                    kode[0] = "a1";
                    //Score+=2;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ;
                } else if (mQuestionNumber == 2) {
                    kode[1] = "b1";
                    //Score+=2;
                } else if (mQuestionNumber == 3){
                    kode[2] = "c1";
                    //Score+=2;
                } else if (mQuestionNumber == 4){
                    kode[3] = "d1";
                    //Score+=2;
                } else {
                    kode[4] = "e1";
                    //Score+=10                                           ;
                }

                updateQuestion();


            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quiz[mQuestionNumber] = choice2.getText().toString();
                if (mQuestionNumber == 1) {
                    kode[0] = "a2";
                    //Score+=10;
                } else if (mQuestionNumber == 2) {
                    kode[1] = "b2";
                    //Score+=10;
                } else if (mQuestionNumber == 3){
                    kode[2] = "c2";
                    //Score+=10;
                } else if (mQuestionNumber == 4){
                    kode[3] = "d2";
                    //Score+=10;
                } else {
                    kode[4] = "e2";
                    //Score+=8;
                }
                updateQuestion();
            }
        });
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz[mQuestionNumber] = choice3.getText().toString();
                if (mQuestionNumber == 1) {
                    kode[0] = "a3";
                    //Score+=2;
                } else if (mQuestionNumber == 2) {
                    kode[1] = "b3";
                    //Score+=8;
                } else if (mQuestionNumber == 3){
                    kode[2] = "c3";
                    //Score+=8;
                } else if (mQuestionNumber == 4){
                    kode[3] = "d3";
                    //Score+=20;
                } else {
                    kode[4] = "e3";
                    //Score+=2;
                }
                    updateQuestion();

            }
        });
    }

        private void updateQuestion () {
            if (mQuestionNumber < mQuestion.getLength()) {
                mQuestionView.setText(mQuestion.getQuestion(mQuestionNumber));

                choice1.setText(mQuestion.getChoice1(mQuestionNumber));
                choice2.setText(mQuestion.getChoice2(mQuestionNumber));
                choice3.setText(mQuestion.getChoice3(mQuestionNumber));

                mQuestionNumber++;
            } else {
                StringBuilder builder = new StringBuilder();
                for (String value : kode) {
                    builder.append(value);
                }
                String conc = builder.toString();
                Log.d("ASASDASDSAD", conc);
                // Intent intent = new Intent(Quiz.this, Conclusion.class);
                // String conc = Arrays.toString(kode);
                // Toast.makeText(Quiz.this , conc,Toast.LENGTH_SHORT).show();

                Intent i = new Intent(  Quiz.this, Conclusion.class);
                i.putExtra("KODE_DATABASE",conc);
                startActivity(i);

                // startActivity(intent);
            }
         }
}
