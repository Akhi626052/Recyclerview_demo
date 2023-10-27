package com.daizzyinfo.recyclerview_demo.retrofit;

import com.daizzyinfo.recyclerview_demo.response.BannerTopBottomResponse;
import com.daizzyinfo.recyclerview_demo.response.CategoryResponse;
import com.daizzyinfo.recyclerview_demo.response.CityResponse;
import com.daizzyinfo.recyclerview_demo.response.StateDataResponse;
import com.daizzyinfo.recyclerview_demo.response.StatelistResponse;
import com.daizzyinfo.recyclerview_demo.response.UpdateProfileResponse;
import com.daizzyinfo.recyclerview_demo.signin.CheckMobileResponse;
import com.daizzyinfo.recyclerview_demo.signin.PasscodeResponse;
import com.daizzyinfo.recyclerview_demo.signin.SendOTPResponse;
import com.daizzyinfo.recyclerview_demo.signin.SetPasscodeResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface ApiRequest {


    @GET("category")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<CategoryResponse> getCategory(@Header("Token") String Token);


    @GET("Statelist")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<StateDataResponse> getState(@Header("Token") String Token);


    @GET("Citylist")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<StateDataResponse> getCity(@Header("Token") String Token);


    @GET("apiForOTP")
    @Headers({"Accept: application/json","Content-Type: application/json"})
    Call<SendOTPResponse> sendOtpAPI(@Query("apiForOTP") String Token);


    @GET("validateMobile")
    @Headers({"Accept: application/json","Content-Type: application/json"})
    Call<CheckMobileResponse> CheckMobiNumberApi(@Query("apiForOTP") String Token);


    @POST("signup")
    @Headers({"Accept: application/json","Content-Type: application/"})
    Call<SetPasscodeResponse> signUpApi(String object, @Body JsonObject jsonObject);

    @POST("signin")
    @Headers({"Accept: application/json","Content-Type: application/"})
    Call<PasscodeResponse> signInApi(@Body JsonObject jsonObject);


    @GET("homeSlider")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<BannerTopBottomResponse> BannerSlider(@Query("BannerSlider") String Token);


    @GET("Citylist")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<CityResponse> CityData(@Query("state_id")  String state_id);

    @GET("Statelist")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<StatelistResponse> StateListData(@Query("StateData") String Token);

/*
    @POST("updateProfile")
    @Headers({"Accept: application/json","Content-Type: application/"})
    Call<UpdateProfileResponse> signUpApi(String object, @Body JsonObject jsonObject);
*/



// test time convert
  /*  @POST("updateProfile")
    @Headers({"Accept: application/json","Content-Type: application/"})
    Call<UpdateProfileResponse> updateProfile(String object, @Query())*/



}
