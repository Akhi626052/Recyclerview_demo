package com.daizzyinfo.recyclerview_demo.activit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;
import com.daizzyinfo.recyclerview_demo.signin.PasscodeResponse;
import com.daizzyinfo.recyclerview_demo.signin.SetPasscodeResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPasscode extends AppCompatActivity {

    String setPasscode;
    public static final String TAG = SetPasscode.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_passcode);

        SignUpPasscodeApi();






    }
    public void SignUpPasscodeApi(){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("passcode", "");
        jsonObject.addProperty("full_name","");
        jsonObject.addProperty("email","");
        jsonObject.addProperty("mobile","");
        jsonObject.addProperty("phone","");


        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<SetPasscodeResponse> call = apiRequest.signUpApi("JsonObject",jsonObject);
        call.enqueue(new Callback<SetPasscodeResponse>() {

            @Override
            public void onResponse(Call<SetPasscodeResponse> call, Response<SetPasscodeResponse> response) {

                setPasscode =response.body().getMessage();
                Log.e(TAG, "onResponse in passcode Api");

            }

            @Override
            public void onFailure(Call<SetPasscodeResponse> call, Throwable t) {

            }
        });

    }
}