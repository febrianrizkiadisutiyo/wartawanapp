package com.example.wartawanapp.model.tampilanberita;

import com.google.gson.annotations.SerializedName;

public class DataBerita {

	@SerializedName("photo")
	public static String photo;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("judul")
	private String judul;

	@SerializedName("id_berita")
	private String idBerita;

	@SerializedName("tags")
	private String tags;

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public static String getPhoto(){
		return photo;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setIdBerita(String idBerita){
		this.idBerita = idBerita;
	}

	public String getIdBerita(){
		return idBerita;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return tags;
	}
}