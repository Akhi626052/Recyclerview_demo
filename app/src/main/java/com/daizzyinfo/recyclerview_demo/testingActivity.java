package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.daizzyinfo.recyclerview_demo.activit.Profile;

public class testingActivity extends AppCompatActivity {

    EditText fullNamEditTx1,fullNamEditTx2;
    Button SubmitBtn;
    public static final String TAG = testingActivity.class.getSimpleName();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        fullNamEditTx1=findViewById(R.id.fullNamEditTx1);
        fullNamEditTx2=findViewById(R.id.fullNamEditTx2);
        SubmitBtn=findViewById(R.id.SubmitBtn);


        if (fullNamEditTx1.getText().toString().isEmpty()) {

            Log.e(TAG, "fdashfkga jhfsdgl ");

        }else if(!fullNamEditTx2.getText().toString().isEmpty()) {

            Log.e(TAG, "fdashfkga jhfsdgl ");

        } else  {

            Log.e(TAG,("dsgfksdjghrklf"));

            SubmitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(testingActivity.this, Profile.class);
                    startActivity(intent);


                }
            });

        }









    }
}