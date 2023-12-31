package com.daizzyinfo.recyclerview_demo.signin;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasscodeResponse {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ContactsContract.Contacts.Data data;

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

    public ContactsContract.Contacts.Data getData() {
        return data;
    }

    public void setData(ContactsContract.Contacts.Data data) {
        this.data = data;
    }




}
