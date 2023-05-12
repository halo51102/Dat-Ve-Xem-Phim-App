package com.example.dat_ve_xem_phim_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("movies")
    Call<List<FilmModel>> getCategoryAll();


}
