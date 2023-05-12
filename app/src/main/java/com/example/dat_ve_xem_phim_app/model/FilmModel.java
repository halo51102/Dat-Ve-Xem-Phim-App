package com.example.dat_ve_xem_phim_app.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FilmModel implements Serializable {
    @SerializedName("maPhim")
    private int maPhim;
    @SerializedName("tenPhim")
    private String TenPhim;
    @SerializedName("hinhAnh")
    private String HinhAnh;
    @SerializedName("moTa")
    private String MoTa;
    @SerializedName("theLoaiModel")
    private TheLoaiModel theLoaiModel;



    public TheLoaiModel getTheLoaiModel() {
        return theLoaiModel;
    }
    public void setTheLoaiModel(TheLoaiModel theLoaiModel) {
        this.theLoaiModel = theLoaiModel;
    }
    public int getMaPhim() {
        return maPhim;
    }
    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }
    public String getTenPhim() {
        return TenPhim;
    }
    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }
    public String getHinhAnh() {
        return HinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
    public String getMoTa() {
        return MoTa;
    }
    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

}
