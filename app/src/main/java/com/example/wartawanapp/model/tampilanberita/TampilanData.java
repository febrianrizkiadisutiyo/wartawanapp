package com.example.wartawanapp.model.tampilanberita;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TampilanData{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataBerita> data;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataBerita> data){
		this.data = data;
	}

	public List<DataBerita> getData(){
		return data;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}