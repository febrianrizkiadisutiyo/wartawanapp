package com.example.wartawanapp.api;

import com.example.wartawanapp.model.inputberita.InputBerita;
import com.example.wartawanapp.model.login.Login;
import com.example.wartawanapp.model.register.Register;
import com.example.wartawanapp.model.tampilanberita.TampilanData;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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

    @Multipart
    @POST("inputberita.php")
    Call<InputBerita> InputBeritaResponse(
            @Part MultipartBody.Part gambar,
            @Part("judul") RequestBody judul,
            @Part("tanggal") RequestBody tanggal,
            @Part("tkp") RequestBody tkp,
            @Part("tags") RequestBody tags,
            @Part("deskripsi") RequestBody deskripsi

    );

    @GET("retrieve.php")
    Call<TampilanData> TampilanResponse();
}
