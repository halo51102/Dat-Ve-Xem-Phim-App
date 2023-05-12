package com.example.dat_ve_xem_phim_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dat_ve_xem_phim_app.APIService;
import com.example.dat_ve_xem_phim_app.adapter.CategoryAdapter;
import com.example.dat_ve_xem_phim_app.R;
import com.example.dat_ve_xem_phim_app.RetrofitClient;
import com.example.dat_ve_xem_phim_app.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    CategoryAdapter categoryAdapter;
    RecyclerView rcCate;
    APIService apiService;
    List<FilmModel> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phim_main);
        AnhXa();
        GetCategory();
    }
    private void AnhXa(){
        rcCate=findViewById(R.id.rc_film);
    }
    private void GetCategory(){
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getCategoryAll().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if(response.isSuccessful()){
                    categoryList=response.body();
                    categoryAdapter=new CategoryAdapter(categoryList,MainActivity.this);
                    rcCate.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager((getApplicationContext()),LinearLayoutManager.VERTICAL,false);
                    rcCate.setLayoutManager(layoutManager);
                    rcCate.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                }else{
                    int statusCode=response.code();
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                Log.d("logg",t.getMessage());
            }
        });
    }
}