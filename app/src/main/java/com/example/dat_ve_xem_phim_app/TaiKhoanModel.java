package com.example.dat_ve_xem_phim_app;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TaiKhoanModel implements Serializable {
    @SerializedName("email")
    private String email;
    @SerializedName("pass")

    private String pass;

    @SerializedName("rolee")
    private int rolee;
    @SerializedName("ten")
    private String ten;


    public TaiKhoanModel() {
        super();
    }

    public TaiKhoanModel(String email, String pass, int rolee, String ten) {
        super();
        this.email = email;
        this.pass = pass;
        this.rolee = rolee;
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRolee() {
        return rolee;
    }

    public void setRolee(int rolee) {
        this.rolee = rolee;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
