package com.daizzyinfo.recyclerview_demo;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.ui.OrderFragment;
import com.daizzyinfo.recyclerview_demo.ui.home.HomeFragment;

import java.util.zip.Inflater;

public class Activity_Order_Details extends AppCompatActivity {
    //Button rating;
    //Button addnewaddress;
    RelativeLayout click_id;

    String ComingFrom;


    TextView TxtStatus;

//    Button success;
//    Button reorder;
//    Button cancel;
    Button BtnAll;
    TextView TxtTemp;

    TextView cancel_successfully;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        click_id = findViewById(R.id.click_id);


        BtnAll = findViewById(R.id.BtnAll);

        TxtTemp = findViewById(R.id.TxtTemp);

        TxtStatus = findViewById(R.id.TxtStatus);

        Intent intent = getIntent();
        ComingFrom = intent.getStringExtra("ComingFrom");

        if (ComingFrom.equals("Cancelled")) {
            click_id.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            TxtStatus.setText("Delivery Cancelled");
            BtnAll.setText("ReOrder");

        } else if (ComingFrom.equals("Success")){
            click_id.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            TxtStatus.setText("Delivery Completed");
            BtnAll.setText("View Invoice");

        }
        else if (ComingFrom.equals("Upcoming")){
            click_id.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            TxtStatus.setText("Upcoming");
            BtnAll.setText("Cancel");
        }


        BtnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnalltext = BtnAll.getText().toString();

                if(btnalltext.equals("Cancel")){
                    Intent intent1= new Intent(Activity_Order_Details.this,CancelWithReasion.class);
                    startActivity(intent1);


                }else if(btnalltext.equals("ReOrder")){
                    Toast.makeText(Activity_Order_Details.this, "Coming soon", Toast.LENGTH_SHORT).show();
                }else if(btnalltext.equals("View Invoice")){
                    Toast.makeText(Activity_Order_Details.this, "cancel order", Toast.LENGTH_SHORT).show();
                }
            }
        });


//
//        BtnAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String btnText = BtnAll.getText().toString();
//
//
//                if(btnText.equals("Cancel Order")){
//                    Intent intent = new Intent();
//                    startActivity(intent);
//
//                }else if(btnText.equals("View Invoice")){
//                    Intent intent1 = new Intent();
//
//                    startActivity(intent1);
//                }else if(btnText.equals("ReOrder")){
//                    Intent intent2 = new Intent();
//                    startActivity(intent2);
//                }
//            }
//        });

   // View view =  inflater.inflate(R.layout.Activity_order_Details, container, false);




    }



      /*  rating=findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(Activity_Order_Details.this, Rate_Us.class);
                startActivity(intent1);
            }
        });

        addnewaddress=findViewById(R.id.addnewaddress);
        addnewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Order_Details.this, Track_Order.class);
                startActivity(intent);
            }
        });*/






    }
