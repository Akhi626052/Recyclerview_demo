package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.databinding.ActivityWelcomeToFoods18Binding;
import com.daizzyinfo.recyclerview_demo.signin.Passcode;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;
import com.daizzyinfo.recyclerview_demo.signin.CheckMobileResponse;
import com.daizzyinfo.recyclerview_demo.signin.SendOTPResponse;
import com.daizzyinfo.recyclerview_demo.signin.VerifyYourMobileNumber;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLogin extends AppCompatActivity {

    ActivityWelcomeToFoods18Binding binding;

    String Mobile;

    private final String TAG = SignUpLogin.class.getSimpleName();


    protected void onPause() {

       // binding.spinKit.setVisibility(View.GONE);
        binding.ContinueBtn.setVisibility(View.VISIBLE);
        super.onPause();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        ((Window) window).clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.red));


        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome_to_foods18);


        txtColor();
        binding.ContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Number = binding.edMobNumber.getText().toString().trim();


                if (Number.isEmpty() || Number.length()<10)
                {
                    Log.e(TAG, "onClick----");
                    binding.edMobNumber.requestFocus();
                    binding.edMobNumber.setError("Please Enter 10 Digit Valid Number");

                }
                else
                {

                    binding.edMobNumber.clearFocus();
                    binding.edMobNumber.setError(null);
                    binding.ContinueBtn.setVisibility(View.VISIBLE);
                   // binding.spinKit.setVisibility(View.VISIBLE);
                    CheckMobileApi();


                }

            }
        });

    }



    public void CheckMobileApi(){
        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<CheckMobileResponse> call = apiRequest.CheckMobiNumberApi(Mobile);
        call.enqueue(new Callback<CheckMobileResponse>() {

            @Override
            public void onResponse(Call<CheckMobileResponse> call, Response<CheckMobileResponse> response) {

                if(response.body()!=null){
                    if(response.code()==200){
                        String message  = response.body().getMsg();
                        Log.e(TAG, "message - " + message);
                        if(message.equals("Already used")){
                            Log.e(TAG, "already used ----------------");
                            Toast.makeText(SignUpLogin.this, "already used ---------------", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpLogin.this, Passcode.class);
                            intent.putExtra("Mobile",binding.edMobNumber.getText().toString());
                            startActivity(intent);
                        }
                        else if (message.equals("Valid")){
                            SendOTPApi();
                        }

                    }else{
                        Toast.makeText(SignUpLogin.this, "gjklshkhhf" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }else{

                    Toast.makeText(SignUpLogin.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                     }
            }

            @Override
            public void onFailure(Call<CheckMobileResponse> call, Throwable t) {

                Toast.makeText(SignUpLogin.this, "onFailure Something Went Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailureSomething");

            }
        });
    }







     public void SendOTPApi(){

         String Mobile  = binding.edMobNumber.getText().toString();
         Log.e(TAG, " Mobile Number - " + Mobile);
         ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
         Call<SendOTPResponse> call = apiRequest.sendOtpAPI(Mobile);
         call.enqueue(new Callback<SendOTPResponse>() {
             @Override
             public void onResponse(Call<SendOTPResponse> call, Response<SendOTPResponse> response) {

                 Log.e(TAG, "onResponse code - " + response.code());
                 if(response.body() != null){

                     if(response.code()==200){

                         SendOTPResponse sendOTPResponse = response.body();
                         String message = sendOTPResponse.getMsg();
                         if(sendOTPResponse.getStatus()){

                             String OTP = String.valueOf(sendOTPResponse.getOtp());
                             Log.e(TAG, "OTP - " + OTP);
                             Intent intent = new Intent(SignUpLogin.this, VerifyYourMobileNumber.class);
                             intent.putExtra("ComingFrom",SignUpLogin.class.getSimpleName());
                             intent.putExtra("Mobile",Mobile);
                             intent.putExtra("OTP",OTP);
                             startActivity(intent);
                         }


                         Toast.makeText(SignUpLogin.this, message, Toast.LENGTH_SHORT).show();
                         Log.e(TAG,message);


                     }else{

                         Toast.makeText(SignUpLogin.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                         Log.e(TAG,response.body().getMsg());

                     }
                 }else{

                     Toast.makeText(SignUpLogin.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                 }
             }

             @Override
             public void onFailure(Call<SendOTPResponse> call, Throwable t) {

                 Toast.makeText(SignUpLogin.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                 Log.e(TAG, "onFailure Message - " + t.getMessage());

             }
         });


     }

    private void txtColor() {
        TextView textView = findViewById(R.id.txtWelcom);
        String first = "Welcome to";
        String second = " Foods18";
        textView.setText(first + second, TextView.BufferType.SPANNABLE);
        Spannable s = (Spannable) textView.getText();
        int start = first.length();
        int end = start + second.length();
        s.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this,R.color.red)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }

    public void onBackPressed() {


       /* FancyAlertDialog.Builder
                .with(this)
                .setTitle("Confirm Exit ... !!")
                .setBackgroundColor(Color.parseColor("#ff5c33"))
                .setMessage("Do you really want to Exit ?")
                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground(Color.parseColor("#ff5c33"))
                .setPositiveBtnText("Yes")
                .setNegativeBtnBackground(Color.parseColor("#ff5c33"))
//                .setAnimation(Animation.POP)

                .isCancellable(false)
                .setIcon(R.drawable.baseline_bubble_chart_24,View.VISIBLE)
                .onPositiveClicked(new FancyAlertDialogListener() {

                    public void onClick(Dialog dialog) {
                        WelcomeToFoods18.super.onBackPressed();
                    }
                })
                .onNegativeClicked(new FancyAlertDialogListener() {

                    public void onClick(Dialog dialog) {

                    }
                })
                .build()
                .show();*/


    }





}