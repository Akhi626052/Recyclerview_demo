package com.daizzyinfo.recyclerview_demo.response;

import com.daizzyinfo.recyclerview_demo.model.StateDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateDataResponse
{


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<StateDataModel> data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<StateDataModel> getData() {
        return data;
    }

    public void setData(List<StateDataModel> data) {
        this.data = data;
    }

}

