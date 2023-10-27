package com.daizzyinfo.recyclerview_demo.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.databinding.ActivityVerifyYourMobileNumberBinding;

public class VerifyYourMobileNumber extends AppCompatActivity {
    ActivityVerifyYourMobileNumberBinding binding;

    String  Mobile, OTP;
    String InputOTP;

    private static final String TAG = VerifyYourMobileNumber.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_your_mobile_number);

        binding.ContinueNextSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getIntentData();
                initOnClickListener();


            }
        });
    }




    public void getIntentData(){

        Intent intent = getIntent();
        if(intent!=null){

            Mobile = intent.getStringExtra("Mobile");
            OTP =  intent.getStringExtra("OTP");
            Log.e(TAG, "Mobile ----- "+ Mobile);
            Log.e(TAG, "OTP ---- " + OTP);

           // binding.txtNumber.setText(Mobile);

        }else {

            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            finish();

        }
    }



    protected void initOnClickListener(){

        binding.ContinueNextSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputOTP = binding.firstPinView.getText().toString();

                if(InputOTP.length() !=6){

                    Toast.makeText(VerifyYourMobileNumber.this, "Please Enter Valid OTP", Toast.LENGTH_SHORT).show();
                }else{
                    if(InputOTP.equals(OTP)){

                    /*    SharedPreferences sharedPreferences = getSharedPreferences(Constant.MY_PREF_NAME,0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Token", "12348sdfujhfu").apply();
                        editor.commit();*/
                        //  Intent intent = new Intent(VerifyYourMobileNumber.this, Get_Started.class);

                        Intent intent = new Intent(VerifyYourMobileNumber.this, Passcode.class);
                        intent.putExtra("Mobile",Mobile);
                        startActivity(intent);
                        finish();
                    }
                    else{

                        Toast.makeText(VerifyYourMobileNumber.this, "OTP is incorrect", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }






}