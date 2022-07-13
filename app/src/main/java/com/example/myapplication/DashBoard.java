package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashBoard extends AppCompatActivity {
    public static ArrayList<Modelclass> listofQ;
    CountDownTimer countDownTimer;
    int timerValue =20;
    LinearProgressIndicator progressbar;
    List <Modelclass> allQ;
    Modelclass modelclass;
    int index = 0;
    ImageView cardQ;
    TextView optiona,optionb,optionc,optiond;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount =0;
    int wrongCount = 0;
    LinearLayout nextbtn;
    ImageView firstImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        firstImage =(ImageView) findViewById(R.id.card_question);
        Hooks();
        progressbar =findViewById(R.id.quiz_timer);
        listofQ = new ArrayList<>();
        firstImage.setImageResource(R.drawable.a1);

        listofQ.add(new Modelclass(firstImage,"d","ds","fd","fd","d"));
        listofQ.add(new Modelclass(firstImage,"34","d","fd","fd","d"));
        listofQ.add(new Modelclass(firstImage,"545","ds","d","fd","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        listofQ.add(new Modelclass(firstImage,"65","ds","fd","d","d"));
        allQ = listofQ;
        Collections.shuffle(allQ);
        modelclass = listofQ.get(index);
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setCardBackgroundColor(getResources().getColor(R.color.white));
        nextbtn.setClickable(false);

        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timerValue =timerValue-1;
                progressbar.setProgress(timerValue);


            }


            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashBoard.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);
                dialog.findViewById(R.id.out_time).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashBoard.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        }.start();
        setAllData();
    }

    private void setAllData() {
        cardQ = modelclass.getQuestion();
        optiona.setText(modelclass.getOa());
        optionb.setText(modelclass.getOb());
        optionc.setText(modelclass.getOc());
        optiond.setText(modelclass.getOd());
        timerValue =20;
        countDownTimer.cancel();
        countDownTimer.start();
    }

    private void Hooks() {
        progressbar =findViewById(R.id.quiz_timer);
        cardQ =findViewById(R.id.card_question);
        optiona =findViewById(R.id.card_optiona);
        optionb =findViewById(R.id.card_optionb);
        optionc =findViewById(R.id.card_optionc);
        optiond =findViewById(R.id.card_optiond);
        cardOA =findViewById(R.id.cardA);
        cardOB =findViewById(R.id.cardB);
        cardOC=findViewById(R.id.cardC);
        cardOD =findViewById(R.id.cardD);
        nextbtn =findViewById(R.id.next_btn);

    }
    public void Correct(CardView cardView){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelclass = listofQ.get(index);
                setAllData();
                resetColor();
                enableButton();
            }
        });

    }
    public void Wrong(CardView cardOA){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.red));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index<listofQ.size()-1){
                    index++;
                    modelclass = listofQ.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }else{
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent intent = new Intent(DashBoard.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }
    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }
    public void resetColor(){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }
    public void OptionAClick(View view){
        disableButton();
        nextbtn.setClickable(true);
        if(modelclass.getOa().equals(modelclass.getAns())){
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size()-1){
                Correct(cardOA);

            }else{
                GameWon();
            }

        }else{
            Wrong(cardOA);

        }
    }
    public void OptionBClick(View view){
        disableButton();
        nextbtn.setClickable(true);
        if(modelclass.getOb().equals(modelclass.getAns())){
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size()-1){
                Correct(cardOB);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOB);

        }
    }
    public void OptionCClick(View view){
        disableButton();
        nextbtn.setClickable(true);
        if(modelclass.getOc().equals(modelclass.getAns())){
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size()-1){
                Correct(cardOC);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOC);

        }
    }
    public void OptionDClick(View view){
        disableButton();
        nextbtn.setClickable(true);
        if(modelclass.getOd().equals(modelclass.getAns())){
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<listofQ.size()-1){
                Correct(cardOD);
            }else{
                GameWon();
            }

        }else{
            Wrong(cardOD);

        }
    }
}