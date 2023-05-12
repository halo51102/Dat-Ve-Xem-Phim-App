package com.example.dat_ve_xem_phim_app.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TheLoaiModel implements Serializable {
    @SerializedName("maTheLoai")
    private int maTheLoai;
    @SerializedName("tenTheLoai")
    private String tenTheLoai;
    public int getMaTheLoai() {
        return maTheLoai;
    }
    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
    public String getTenTheLoai() {
        return tenTheLoai;
    }
    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

}

