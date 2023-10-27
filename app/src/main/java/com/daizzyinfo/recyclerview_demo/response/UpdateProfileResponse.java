package com.daizzyinfo.recyclerview_demo.response;

import android.provider.ContactsContract;

import com.daizzyinfo.recyclerview_demo.model.UpdateProfileModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfileResponse {



    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private UpdateProfileModel data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UpdateProfileModel getData() {
        return data;
    }

    public void setData(UpdateProfileModel data) {
        this.data = data;
    }











}
