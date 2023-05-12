package com.example.dat_ve_xem_phim_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

EditText edtEmail,ediPass;
private APIService apiService;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }
    private  void AnhXa(){
        edtEmail=(EditText) findViewById(R.id.etUserName);
        ediPass=(EditText) findViewById(R.id.etUserPassword);
        btnLogin=(Button) findViewById(R.id.btnLogin);
    }
    private void userLogin(){
        String username=edtEmail.getText().toString();
        String password=ediPass.getText().toString();
        if(TextUtils.isEmpty(username)){
            edtEmail.setError("Please enter your username");
            edtEmail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            ediPass.setError("Please enter your password");
            ediPass.requestFocus();
            return;
        }

        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.login(username,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse=response.body();
                    if(loginResponse.isSuccess()){
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        TaiKhoanModel user=loginResponse.getAccountModel();
//                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
                        finish();
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    int statusCode=response.code();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}