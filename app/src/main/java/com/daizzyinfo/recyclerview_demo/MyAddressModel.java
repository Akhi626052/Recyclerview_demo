package com.daizzyinfo.recyclerview_demo;

public class MyAddressModel {

    String comadd;
    String addcompany;

    public MyAddressModel(String comadd, String addcompany) {
        this.comadd = comadd;
        this.addcompany = addcompany;
    }

    public CharSequence getComadd() {
        return comadd;
    }

    public void setComadd(String comadd) {
        this.comadd = comadd;
    }

    public CharSequence getAddcompany() {
        return addcompany;
    }

    public void setAddcompany(String addcompany) {
        this.addcompany = addcompany;
    }
}