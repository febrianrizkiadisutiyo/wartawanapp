package com.example.wartawanapp.model.inputberita;

import com.google.gson.annotations.SerializedName;

public class InputBerita{

	@SerializedName("data")
	private InputBeritaData inputBeritaData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setData(InputBeritaData inputBeritaData){
		this.inputBeritaData = inputBeritaData;
	}

	public InputBeritaData getData(){
		return inputBeritaData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

}