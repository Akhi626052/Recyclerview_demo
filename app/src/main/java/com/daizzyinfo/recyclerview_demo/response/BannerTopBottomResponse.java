package com.daizzyinfo.recyclerview_demo.response;

import com.daizzyinfo.recyclerview_demo.model.BannerBottomModel;
import com.daizzyinfo.recyclerview_demo.model.BannerTopModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerTopBottomResponse {


    @SerializedName("top_slider")
    @Expose
    private List<BannerTopModel> topSlider;
    @SerializedName("bottom_slider")
    @Expose
    private List<BannerBottomModel> bottomSlider;

    public List<BannerTopModel> getTopSlider() {
        return topSlider;
    }

    public void setTopSlider(List<BannerTopModel> topSlider) {
        this.topSlider = topSlider;
    }

    public List<BannerBottomModel> getBottomSlider() {
        return bottomSlider;
    }

    public void setBottomSlider(List<BannerBottomModel> bottomSlider) {
        this.bottomSlider = bottomSlider;
    }









/*
    @SerializedName("top_slider")
    @Expose
    private List<BannerTopModel> topSlider;

    public List<BannerTopModel> getTopSlider() {

        return topSlider;

    }

    public void setTopSlider(List<BannerTopModel> topSlider) {

        this.topSlider = topSlider;

    }*/


}
