package com.example.wartawanapp.model.postberita;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("tkp")
    private String tkp;

    @SerializedName("photo")
    private String photo;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("judul")
    private String judul;

    @SerializedName("id_berita")
    private int idBerita;

    @SerializedName("tags")
    private String tags;

    public void setTkp(String tkp) {
        this.tkp = tkp;
    }

    public String getTkp() {
        return tkp;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setIdBerita(int idBerita) {
        this.idBerita = idBerita;
    }

    public int getIdBerita() {
        return idBerita;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }
}