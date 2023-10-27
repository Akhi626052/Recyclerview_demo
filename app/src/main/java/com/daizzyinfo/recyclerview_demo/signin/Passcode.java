package com.daizzyinfo.recyclerview_demo.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.daizzyinfo.recyclerview_demo.BottomNavigationBar;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;
import com.daizzyinfo.recyclerview_demo.utils.Constant;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Passcode extends AppCompatActivity {
    String Passcode,Mobile;

    String full_name,email,mobile,password,state,city,address,user_image;

    public static final String TAG = Passcode.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);

        //    SignUpApi();

        Intent intent = new Intent(Passcode.this,BottomNavigationBar.class);
        startActivity(intent);

        SignInPasscodeApi();


    }
    public void SignInPasscodeApi() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mobile",Mobile);
        jsonObject.addProperty("password",Passcode);
        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<PasscodeResponse> call = apiRequest.signInApi(jsonObject);
        call.enqueue(new Callback<PasscodeResponse>() {
            @Override
            public void onResponse(Call<PasscodeResponse> call, Response<PasscodeResponse> response) {


            }

            @Override
            public void onFailure(Call<PasscodeResponse> call, Throwable t) {


            }
        });




    }



}