package com.example.dat_ve_xem_phim_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dat_ve_xem_phim_app.APIService;
import com.example.dat_ve_xem_phim_app.R;
import com.example.dat_ve_xem_phim_app.RetrofitClient;
import com.example.dat_ve_xem_phim_app.model.LoginResponse;
import com.example.dat_ve_xem_phim_app.model.SignUpResponse;
import com.example.dat_ve_xem_phim_app.model.TaiKhoanModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private APIService apiService;
    Button btnSignup;
    EditText edtUsername;
    EditText edtPass;
    EditText edtName;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AnhXa();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void AnhXa(){
        tvRegister=findViewById(R.id.tvRegister);
        btnSignup= findViewById(R.id.btnRegister);
        edtUsername=findViewById(R.id.etUserName);
        edtPass=findViewById(R.id.etPassword);
        edtName=findViewById(R.id.etName);
    }
    private void signup(){
        String username=edtUsername.getText().toString();
        String password=edtPass.getText().toString();
        String name=edtName.getText().toString();
        if(TextUtils.isEmpty(username)){
            edtUsername.setError("Please enter your username");
            edtUsername.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            edtPass.setError("Please enter your password");
            edtPass.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(name)){
            edtName.setError("Please enter your password");
            edtName.requestFocus();
            return;
        }

        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.signup(username,password,name).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse=response.body();
                    if(loginResponse.isSuccess()){
                        Toast.makeText(SignupActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        TaiKhoanModel user=loginResponse.getAccountModel();
                        finish();
                        Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(SignupActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
                else {
                    int statusCode=response.code();
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}