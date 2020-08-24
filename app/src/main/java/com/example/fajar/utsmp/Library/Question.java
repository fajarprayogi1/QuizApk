package com.example.fajar.utsmp.Library;

public class Question {

    private String mQuestion[] = {

            "Jika kamu disuruh membeli Rokok oleh Bapakmu,lalu diberikan uang Rp 50.000 dan uang tersebut kembali 5 ribu maka apa yang kamu lakukan?",
            "Jika kamu tidak boleh meminum es oleh orang tua kamu karena batuk apa yang kamu lakukan?",
            "Jika kamu disuruh membeli gula oleh Ibumu,lalu diberikan uang Rp 50.000 dan uang tersebut kembali 5 ribu maka apa yang kamu lakukan?",
            "Jika kamu telat sekolah lalu tidak boleh masuk,apa yang kamu lakukan?",
            "Jika kamu ingin membeli buku seharga 50.000 tetapi tidak punya ongkos karena habis untuk jajan maka?"
    };

    private String mChoices[][] = {
            {"Kembalikan kepada Bapak", "Ambil saja uang bapak sama dengan uang ku", "Belikan es krim lalu ngomong sama bapak bahwa kembaliannya untuk jajan"},
            {"Tidak membeli es", "Beli saja toh orang tua tidak tahu", "Membeli tapi sedikit"},
            {"Kembalikan kepada Ibu", "Ambil saja uang ibu sama dengan uang ku", "Belikan es krim lalu ngomong sama ibu bahwa kembaliannya untuk jajan"},
            {"Pulang lalu bicara bahwa sudah tidak boleh masuk", "main dengan teman yang terlambat juga hingga waktunya pulang", "Pulang bicara bahwa guru sedang rapat"},
            {"Bilang ke orang tua harga buku 65.000", "Membeli dengan jalan kaki ke tokonya", "Bicara dengan orang tua sudah tidak punya ongkos lagi"}


    };



    public String getQuestion(int a) {

        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public int getLength(){
        return mQuestion.length;
    }
}
