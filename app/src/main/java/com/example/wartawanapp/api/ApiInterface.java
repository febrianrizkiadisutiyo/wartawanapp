package com.example.wartawanapp.api;

import com.example.wartawanapp.model.login.Login;
import com.example.wartawanapp.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Login> LoginResponse(
            @Field("id_wartawan") String id_wartawan,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> RegisterResponse(
            @Field("id_wartawan") String id_wartawan,
            @Field("password") String password,
            @Field("nama_lengkap") String nama_lengkap,
            @Field("email") String email,
            @Field("no_hp") String no_hp,
            @Field("jenis_kelamin") String jenis_kelamin
    );
}
