package com.daizzyinfo.recyclerview_demo;

import android.widget.ImageView;
import android.widget.TextView;

public class SearchHereModel {


    int imgFood;

    String textTextView1;

    public SearchHereModel(int imgFood, String textTextView1) {
        this.imgFood = imgFood;
        this.textTextView1 = textTextView1;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public String getTextTextView1() {
        return textTextView1;
    }

    public void setTextTextView1(String textTextView1) {
        this.textTextView1 = textTextView1;
    }
}