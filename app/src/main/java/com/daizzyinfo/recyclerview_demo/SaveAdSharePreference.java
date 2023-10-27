package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class SaveAdSharePreference extends AppCompatActivity {
   TextView name, address,mobilesNum;
    TextView nameShr,AddressShr,MobileShr,CountryNaShr,listShr,stateShr,cityShr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_ad_share_preference);
        nameShr=findViewById(R.id.nameShr);
        AddressShr=findViewById(R.id.AddressShr);
        MobileShr=findViewById(R.id.MobileShr);
        CountryNaShr=findViewById(R.id.CountryNaShr);
        listShr=findViewById(R.id.listShr);

        stateShr=findViewById(R.id.stateShr);
        cityShr=findViewById(R.id.cityShr);




        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);


        String s1 = sh.getString("name", "").toString();
        String s2 = sh.getString("address", "").toString();
        String s3 = sh.getString("mobilesNum", "").toString();
        String s4 = sh.getString("country", "").toString();
        String s5 = sh.getString("state", "").toString();
        String s6 = sh.getString("city", "").toString();



        Gson gson = new Gson();


        nameShr.setText(s1);
        AddressShr.setText(s2);
        MobileShr.setText(s3);
        CountryNaShr.setText(s4);
        stateShr.setText(s5);
        cityShr.setText(s6);



    }

}