package com.example.wartawanapp.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.wartawanapp.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public static final String IS_LOGGED_IN ="isLoggedIn";
    public static final String id_wartawan ="id_wartawan";
    public static final String nama_lengkap ="nama_lengkap";
    public static final String email ="email";
    public static final String no_hp ="no_hp";
    public static final String jenis_kelamin ="jenis_kelamin";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();

    }
    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN,true);
        editor.putString(id_wartawan, user.getIdWartawan());
        editor.putString(nama_lengkap, user.getNamaLengkap());
        editor.putString(email, user.getEmail());
        editor.putString(no_hp, user.getNoHp());
        editor.putString(jenis_kelamin, user.getJenisKelamin());
        editor.commit();
    }
    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(id_wartawan, sharedPreferences.getString(id_wartawan,null));
        user.put(nama_lengkap,sharedPreferences.getString(nama_lengkap,null));
        user.put(email, sharedPreferences.getString(email,null));
        user.put(no_hp, sharedPreferences.getString(no_hp,null));
        user.put(jenis_kelamin, sharedPreferences.getString(jenis_kelamin,null));
        return user;
    }
    public void logoutSession(){
        editor.clear();
        editor.commit();
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);

    }
}
