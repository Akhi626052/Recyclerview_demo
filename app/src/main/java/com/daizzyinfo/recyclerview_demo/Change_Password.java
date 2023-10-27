package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change_Password extends AppCompatActivity {
    EditText oldPassword,NewPassword,NewPasswordSecond;
    Button BtChangePassSubmit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        oldPassword=findViewById(R.id.oldPassword);
        NewPassword=findViewById(R.id.NewPassword);
        NewPasswordSecond=findViewById(R.id.NewPasswordSecond);
        BtChangePassSubmit=findViewById(R.id.BtChangePassSubmit);
        BtnSubmitSetError();



    }
    public void BtnSubmitSetError(){
        BtChangePassSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//>=5
                    if(oldPassword.length()<=3){
                        oldPassword.setError("Number Mininum length is 4");

                    }else if(NewPassword.length()<=3){
                        NewPassword.setError("Number Mininum length is 4");
                    }
                else if(NewPasswordSecond.length()<=3){
                    NewPasswordSecond.setError("Name Mininum length is 4");

                }
               /* else if(!NewPassword.getText().toString().equals(NewPasswordSecond.getText().toString())){
                    NewPasswordSecond.setError("Password does not match");
                }*/
                else{
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AddNewAddress.class);
                        startActivity(intent);
                    }






            }
        });



    }
}