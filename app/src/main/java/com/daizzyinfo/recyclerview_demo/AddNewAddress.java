package com.daizzyinfo.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.response.StateDataResponse;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewAddress extends AppCompatActivity {
    List<StateDataResponse> stateDataResponses = new ArrayList<StateDataResponse>();
    ArrayList<String> arrIds = new ArrayList<>();

    Spinner state_spinner,city_spinner;
    Button svAdShrPre_bt,clear_btn,buttonListview;
    Spinner spinnerdr;
    EditText name_id,Address_id,mobiles_id,list_item_id;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);
        stateSpinnerApi();

        arrIds.add("Selected State");
        spinnerdr = findViewById(R.id.spinnerdr);
        name_id=findViewById(R.id.name_id);
        Address_id=findViewById(R.id.Address_id);
        mobiles_id=findViewById(R.id.mobiles_id);
        clear_btn=findViewById(R.id.clear_btn);
        list_item_id=findViewById(R.id.list_item_id);
        buttonListview=findViewById(R.id.buttonListview);

        state_spinner=findViewById(R.id.state_spinner);
        city_spinner=findViewById(R.id.city_spinner);


      /*  String[] state = { "selected state","Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur"};
        ArrayAdapter adapter1 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,state);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        state_spinner.setAdapter(adapter1);*/






        String[] city = {"selected city","Alirajpur", "Anuppur", "Ashok Nagar", "Balaghat", "Barwani","Betul","Bhind", "Bhopal","Dewas","Damoh"};
        ArrayAdapter adapte2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, city);
        adapte2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        city_spinner.setAdapter(adapte2);

        String[] country = {"India","Afghanistan", "Albania", "Algeria", "AndorraAngola"};
        //ArrayAdapter Adadapte = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        ArrayAdapter Adadapte = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, country);
        Adadapte.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerdr.setAdapter(Adadapte);

        svAdShrPre_bt=findViewById(R.id.svAdShrPre_bt);
        onClickList();
        onClearData();
        onSharedPreferences();




    }

    public void stateSpinnerApi() {
        List<StateDataResponse> stateDataResponses = new ArrayList<StateDataResponse>();
        ApiRequest request= RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<StateDataResponse> call = request.getState("47|Z4tNdytOQDJEqbxiZtTbvn5KQFnuvphqq8eyXrHt");
        call.enqueue(new Callback<StateDataResponse>() {
            @Override
            public void onResponse(Call<StateDataResponse> call, Response<StateDataResponse> response) {


                if (response.body().getData().size() >= 0){

                    for (int i =0; i < response.body().getData().size(); i++){

                        state_spinner=findViewById(R.id.state_spinner);
                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(AddNewAddress.this,  android.R.layout.simple_list_item_1,arrIds);
                        state_spinner.setAdapter(spinnerAdapter);

                        arrIds.add(response.body().getData().get(i).getName());
                        spinnerAdapter.notifyDataSetChanged();


                    }
                }
                else{

                    Toast.makeText(AddNewAddress.this, "onFailure---", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<StateDataResponse> call, Throwable t) {


                Toast.makeText(AddNewAddress.this, "onFailure  -----------------", Toast.LENGTH_SHORT).show();
            }

        });
    }


        public  void citySpinnerApi(){
     ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
     Call<StateDataResponse> call = apiRequest.getCity("47|Z4tNdytOQDJEqbxiZtTbvn5KQFnuvphqq8eyXrHt");
     call.enqueue(new Callback<StateDataResponse>() {


         @Override
         public void onResponse(Call<StateDataResponse> call, Response<StateDataResponse> response) {


             Toast.makeText(AddNewAddress.this, "hello world", Toast.LENGTH_SHORT).show();
         }
         @Override
         public void onFailure(Call<StateDataResponse> call, Throwable t) {

             Toast.makeText(AddNewAddress.this, "onFailure", Toast.LENGTH_SHORT).show();

         }
     });










        }

public  void onSharedPreferences(){

    svAdShrPre_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name",name_id.getText().toString());
                    myEdit.putString("address",Address_id.getText().toString());
                    myEdit.putString("mobilesNum", mobiles_id.getText().toString());
                    myEdit.putString("country",spinnerdr.getSelectedItem().toString());
                    myEdit.putString("state",state_spinner.getSelectedItem().toString());
                    myEdit.putString("city",city_spinner.getSelectedItem().toString());


                    myEdit.commit();
                    Intent intent = new Intent(AddNewAddress.this,SaveAdSharePreference.class);
                    startActivity(intent);

                }
            });
    }


    public void onClearData() {
        clear_btn.setOnClickListener(new View.OnClickListener() {
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            @Override
            public void onClick(View v) {

                myEdit.clear();

            }
        });
    }




    public  void onClickList(){
        buttonListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list_item_id=findViewById(R.id.list_item_id);
                Gson gson = new Gson();
                EmployShare employshare = new EmployShare("Akhilesh Gupta",35,"akhilesh@gmail.com");
                List<String> textList = new ArrayList<String>();
                try {
                    JSONObject jsonObj = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");

                } catch (JSONException e) {
                    throw new RuntimeException(e);

                }
                String jsonObj = gson.toJson(employshare);


                Intent intent = new Intent(AddNewAddress.this,SaveAdSharePreference.class);
                startActivity(intent);

            }
        });
    }




}
