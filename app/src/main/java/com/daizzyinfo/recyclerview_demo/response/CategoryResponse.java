package com.daizzyinfo.recyclerview_demo.response;

import com.daizzyinfo.recyclerview_demo.model.CategoryModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<CategoryModel.Datum> data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CategoryModel.Datum> getData() {
        return data;
    }

    public void setData(List<CategoryModel.Datum> data) {
        this.data = data;
    }



}
