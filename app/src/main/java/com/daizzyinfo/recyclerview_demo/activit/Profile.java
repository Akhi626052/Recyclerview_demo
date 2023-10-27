package com.daizzyinfo.recyclerview_demo.activit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.response.CityResponse;
import com.daizzyinfo.recyclerview_demo.response.StatelistResponse;
import com.daizzyinfo.recyclerview_demo.response.UpdateProfileResponse;
import com.daizzyinfo.recyclerview_demo.retrofit.ApiRequest;
import com.daizzyinfo.recyclerview_demo.retrofit.RetrofitRequest;
import com.daizzyinfo.recyclerview_demo.testingActivity;
import com.daizzyinfo.recyclerview_demo.utils.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

public final static String TAG = Profile.class.getSimpleName();

   EditText fullNamEditTx,emailEditTx,numEditTx,addressEditTx;
   Button SubmitBtn;
   ImageView ImgCamera,img1;
    ArrayAdapter stateAdapter,cityAdapter;
    Spinner spinnerState,spinnerCity;
    List<String> stateList = new ArrayList<String>();
   List<String> cityList = new ArrayList<String>();
    public static final int cameraCode=0;
   public static final int galleryCode=1;

    protected String[] optionsMenu = new String[]{"Camera", "Gallery", "Exit"};



   @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        spinnerState=findViewById(R.id.spinnerState);
        spinnerCity=findViewById(R.id.spinnerCity);
        SubmitBtn=findViewById(R.id.SubmitBtn);
       fullNamEditTx=findViewById(R.id.fullNamEditTx);
       emailEditTx=findViewById(R.id.emailEditTx);
       numEditTx=findViewById(R.id.numEditTx);
       ImgCamera=findViewById(R.id.ImgCamera);
       img1=findViewById(R.id.img1);
       addressEditTx=findViewById(R.id.addressEditTx);

       initOnClickListener();

       if (!fullNamEditTx.getText().toString().isEmpty()){

           Log.e(TAG, "spinnerState prent1------------");

       }else if (!emailEditTx.getText().toString().isEmpty()){

           Log.e(TAG, "spinnerState prent2------------");

       }else if (numEditTx.getText().toString().isEmpty()){
           Log.e(TAG, "spinnerState prent3------------");

       }else if (spinnerState.getSelectedItemPosition() == 0){

           String selectedItem = spinnerState.getSelectedItem().toString();
           Log.e(TAG, "spinnerState prent4------------");

       }else if (spinnerCity.getSelectedItemPosition() == 0){

           Log.e(TAG, "spinnerState prent5------------");

       }else if (addressEditTx.getText().toString().isEmpty()){

           Log.e(TAG, "address6");

       }
       else{

           Log.e(TAG, "spinner else rState prent6------------");

       }



       SubmitBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Profile.this, testingActivity.class);
               startActivity(intent);
               Toast.makeText(Profile.this, "please enter all field", Toast.LENGTH_SHORT).show();
           }
       });






      //  binding = ActivityProfileBinding.inflate(getLayoutInflater());
     //   binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);

        // State list
        stateList.add("Select State");
        stateAdapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,stateList);
        spinnerState.setAdapter(stateAdapter);

        //city
        cityList.add("Select City");
        cityAdapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,cityList);
        spinnerCity.setAdapter(cityAdapter);


       // UpdateProfileAPI();
        StateApi();

    }






    public void CityApi(String state_id){
        cityList.clear();
        cityList.add("select-city");

        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<CityResponse> call = apiRequest.CityData("4006");
        call.enqueue(new Callback<CityResponse>() {

            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                Log.e(TAG, "onResponse----cityDataApi---");

                Log.e("CompleteYourProfile","On Response  --"+response.body().getData().get(0));

                CityResponse response1 = response.body();

                if(response.code()==200){

                    for(int i = 0 ; i < response.body().getData().size(); i++)
                    {
                        cityList.add(response1.getData().get(i).getName());

                    }
                    cityAdapter.notifyDataSetChanged();


                } else if (response.code()== 401) {

                    Toast.makeText(Profile.this, "Not Found", Toast.LENGTH_SHORT).show();

                }else if (response.code()==400){

                    Toast.makeText(Profile.this, "Unauthorized", Toast.LENGTH_SHORT).show();

                } else if (response.code()==500) {

                    Toast.makeText(Profile.this, "Internal server Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {

                Toast.makeText(Profile.this, "onFailure Something Went Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailureSomething--------");




            }
        });
    }


    public void StateApi(){

        stateList.clear();
        stateList.add("select-state");

        ApiRequest apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
        Call<StatelistResponse> call = apiRequest.StateListData(Constant.Token);
        call.enqueue(new Callback<StatelistResponse>() {

            @Override
            public void onResponse(Call<StatelistResponse> call, Response<StatelistResponse> response) {

                Log.e(TAG, "onResponse----StatelistData---");

              if (response.body() != null){
            StatelistResponse response1 = response.body();
            Log.e(TAG, "onResponse body");
                  if (response.code() == 200){

                  for (int i = 0; i < response.body().getData().size(); i++){

                   stateList.add(response1.getData().get(i).getName());

                   }
                  Log.e(TAG, "onResponse code");

                  }else if (response.code() == 401){
                              Toast.makeText(Profile.this,"On Failure ",Toast.LENGTH_SHORT).show();

                  }else if (response.code() == 404){

                      Toast.makeText(Profile.this,"Unauthorized ",Toast.LENGTH_SHORT).show();

                  }else if (response.code() == 505){

                      Toast.makeText(Profile.this,"Internet Server Error ",Toast.LENGTH_SHORT).show();

                  }
                  else{
                      Toast.makeText(Profile.this,"Data Not Found",Toast.LENGTH_SHORT).show();

                  }

              }else{

                  Toast.makeText(Profile.this, "something went wrong", Toast.LENGTH_SHORT).show();


                  }
                stateAdapter.notifyDataSetChanged();

                spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            String selectedStateId = String.valueOf(response.body().getData().get(position - 1).getId());
                            CityApi(selectedStateId);

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<StatelistResponse> call, Throwable t) {

                Toast.makeText(Profile.this, "onFailure Something Went Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailureSomething");




            }
        });

    }


    public void UpdateProfileAP(){

        ApiRequest apiRequest =RetrofitRequest.getRetrofit().create(ApiRequest.class);
       // Call<UpdateProfileResponse> call = apiRequest.signInApi();








    }




String Name,Mobile,Email,State,City,PinCode,Address,picturePath;
    private void UpdateProfileAPI() {

        Log.e(TAG, "All Values - "
                + "Token - " + Constant.getToken() +
                "Name - " +  Name + "\n" + "Mobile - " + Mobile + "\n" + "Email -" + Email + "\n"+ "State - " + State +  "\n"  + "City - " + City
                + "\n"+    "PinCode - "+PinCode + "\n" + "Address - " + Address + "\n" + "picturePath - " + picturePath );

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("full_name", Name)
                .addFormDataPart("mobile_number", Mobile)
                .addFormDataPart("email", Email)
                .addFormDataPart("state", State)
                .addFormDataPart("city", City)
                .addFormDataPart("pincode", PinCode)
                .addFormDataPart("address", Address)
                .addFormDataPart("image", picturePath,  RequestBody.create(MediaType.parse("application/octet-stream"), new File(picturePath))).build();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()

               .url(Constant.BASE_URL + "updateProfile")
                .method("POST", body)
                .addHeader("Authorization", "Auth-Token" + Constant.getToken())
                .build();


        client.newCall(request).enqueue(new okhttp3.Callback() {

            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "on failure  : " + e);
                      //  binding.spinKit.setVisibility(View.GONE);
                        SubmitBtn.setVisibility(View.VISIBLE);
                        Toast.makeText(Profile.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();




                    }
                });
            }

            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {
                HandelAllResponse(response);
            }
        });

    }





    private void HandelAllResponse(okhttp3.Response response) {
        Log.d(TAG, "response code  - " + response.code());
        if (response.code() == 200) {
            try {
                JSONObject json = new JSONObject(response.body().string());
                Log.d(TAG, "" + json);
                String status = json.getString("status");
                String message = json.getString("message");
                Log.d(TAG, "status - " + status);
                Log.d(TAG, "message - " + message);


            } catch (JSONException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // binding.spinKit.setVisibility(View.GONE);
                        SubmitBtn.setVisibility(View.VISIBLE);
                        Toast.makeText(Profile.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "JSONException - " + response.toString());
                    }
                });
            } catch (Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  binding.spinKit.setVisibility(View.GONE);
                        SubmitBtn.setVisibility(View.VISIBLE);
                        Toast.makeText(Profile.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "IOException - " + response.toString());
                    }
                });
            }
        }
        else if(response.code() == 401){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    try {
                        JSONObject json = new JSONObject(response.body().string());
                        Log.d(TAG, "" + json);
//                            String status = json.getString("status");
//                            String message = json.getString("message");
//                            Log.d(TAG, "status - " + status);
                        Log.d(TAG, "message - " + json.get("message"));

//                            Toast.makeText(CompleteYourProfile.this, "" + message, Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Log.d(TAG, "in exception of 401 - " + e.getMessage());
                    }

                  //  binding.spinKit.setVisibility(View.GONE);
                    SubmitBtn.setVisibility(View.VISIBLE);

                }
            });
        }
        else if (response.code() == 404) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   // binding.spinKit.setVisibility(View.GONE);
                    SubmitBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(Profile.this, "Not Found", Toast.LENGTH_SHORT).show();
                }
            });

        }
        else if (response.code() == 500) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   // binding.spinKit.setVisibility(View.GONE);
                    SubmitBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(Profile.this, "Internal Server Error", Toast.LENGTH_SHORT).show();

                }
            });

        }
        else{
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                 //   binding.spinKit.setVisibility(View.GONE);
                    SubmitBtn.setVisibility(View.VISIBLE);
                    Toast.makeText(Profile.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
    private void initOnClickListener() {

        ImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsMenu();
            }
        });

    }


    private void showOptionsMenu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
        builder.setTitle("Choose one");
        builder.setCancelable(false);
        builder.setItems(optionsMenu, (dialogInterface, i) -> {
            if (optionsMenu[i].equals("Camera")) {
                if (ContextCompat.checkSelfPermission(Profile.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, cameraCode);
                } else
                {
                    ActivityCompat.requestPermissions(Profile.this, new String[]{Manifest.permission.CAMERA}, cameraCode);
                }
            } else if (optionsMenu[i].equals("Gallery")) {
                if (ContextCompat.checkSelfPermission(Profile.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, galleryCode);
                } else {
                    ActivityCompat.requestPermissions(Profile.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, galleryCode);
                }
            } else if (optionsMenu[i].equals("Exit")) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == cameraCode && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, cameraCode);
        } else if (requestCode == galleryCode && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, galleryCode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == cameraCode && data != null) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                img1.setImageBitmap(photo);



            }
            else if (requestCode == galleryCode && data != null) {
                Uri selectedImageUri = data.getData();
                String[] filepathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImageUri, filepathColumn, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex(filepathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                    img1.setImageBitmap(bitmap);

                }
            }
        }
    }








}