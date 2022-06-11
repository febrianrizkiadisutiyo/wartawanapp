package com.example.wartawanapp.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("id_wartawan")
	private String idWartawan;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("email")
	private String email;

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setIdWartawan(String idWartawan){
		this.idWartawan = idWartawan;
	}

	public String getIdWartawan(){
		return idWartawan;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}