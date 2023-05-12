package com.example.dat_ve_xem_phim_app;

import com.example.dat_ve_xem_phim_app.model.FilmModel;
import com.example.dat_ve_xem_phim_app.model.LoginResponse;
import com.example.dat_ve_xem_phim_app.model.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("movies")
    Call<List<FilmModel>> getCategoryAll();
    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("email") String email, @Field("Pass") String pass);
    @POST("register")
    @FormUrlEncoded
    Call<LoginResponse> signup(@Field("email" ) String username,@Field("Pass") String pass, @Field("Ten") String ten);

}
