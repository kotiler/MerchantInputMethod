package com.hit.wi.t9.Business.entity;

import java.util.Date;

public class Words {
    private String word;
    public Words(String word) {
       this.word=word;
    }
    private String  date;
    public Words() {

    }

    public String getWords() {
        return word;
    }

    public void setWords(String word) {
        this.word = word;
    }

    public String getDate(){return date;}

    public void setDate(String date){this.date=date;}
}
