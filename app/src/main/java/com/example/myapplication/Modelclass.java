package com.example.myapplication;

import android.media.Image;
import android.widget.ImageView;

public class Modelclass {
    ImageView Question;
    String Oa;
    String Ob;
    String Oc;
    String Od;
    String ans;

    public Modelclass(ImageView question, String oa, String ob, String oc, String od, String ans) {
        Question = question;
        Oa = oa;
        Ob = ob;
        Oc = oc;
        Od = od;
        this.ans = ans;
    }

    public ImageView getQuestion() {
        return Question;
    }

    public void setQuestion(ImageView question) {
        Question = question;
    }

    public String getOa() {
        return Oa;
    }

    public void setOa(String oa) {
        Oa = oa;
    }

    public String getOb() {
        return Ob;
    }

    public void setOb(String ob) {
        Ob = ob;
    }

    public String getOc() {
        return Oc;
    }

    public void setOc(String oc) {
        Oc = oc;
    }

    public String getOd() {
        return Od;
    }

    public void setOd(String od) {
        Od = od;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
