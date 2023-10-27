package com.daizzyinfo.recyclerview_demo.response;

import com.daizzyinfo.recyclerview_demo.model.CityDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityDataResponse {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<CityDataModel> data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CityDataModel> getData() {
        return data;
    }

    public void setData(List<CityDataModel> data) {
        this.data = data;
    }



}
