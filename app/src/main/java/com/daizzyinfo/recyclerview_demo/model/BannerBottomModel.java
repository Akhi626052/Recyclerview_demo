package com.daizzyinfo.recyclerview_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerBottomModel {


    @SerializedName("sliders")
    @Expose
    private String sliders;
    @SerializedName("type")
    @Expose
    private String type;

    public String getSliders() {
        return sliders;
    }

    public void setSliders(String sliders) {
        this.sliders = sliders;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }







}
