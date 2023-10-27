package com.daizzyinfo.recyclerview_demo;

public class CardModel {

    int imgfood;
    String cheeseCor;

    public CardModel(int imgfood, String cheeseCor) {
        this.imgfood = imgfood;
        this.cheeseCor = cheeseCor;
    }

    public int getImgfood() {
        return imgfood;
    }

    public void setImgfood(int imgfood) {
        this.imgfood = imgfood;
    }

    public String getCheeseCor() {
        return cheeseCor;
    }

    public void setCheeseCor(String cheeseCor) {
        this.cheeseCor = cheeseCor;
    }
}