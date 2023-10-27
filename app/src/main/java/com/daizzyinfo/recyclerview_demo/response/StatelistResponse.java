package com.daizzyinfo.recyclerview_demo.response;

import com.daizzyinfo.recyclerview_demo.model.StatelistModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatelistResponse {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<StatelistModel> data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<StatelistModel> getData() {
        return data;
    }

    public void setData(List<StatelistModel> data) {
        this.data = data;
    }





}
