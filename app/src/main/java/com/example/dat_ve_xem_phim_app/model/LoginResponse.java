package com.example.dat_ve_xem_phim_app.model;

import com.example.dat_ve_xem_phim_app.model.TaiKhoanModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("accountModel")
    private TaiKhoanModel accountModel;
    public LoginResponse() {
        super();
    }
    public LoginResponse(boolean success, String message, TaiKhoanModel accountModel) {
        super();
        this.success = success;
        this.message = message;
        this.accountModel = accountModel;
    }
    public LoginResponse(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public TaiKhoanModel getAccountModel() {
        return accountModel;
    }
    public void setAccountModel(TaiKhoanModel accountModel) {
        this.accountModel = accountModel;
    }

}
