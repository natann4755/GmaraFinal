package com.example.myapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.model.DafLearning1;
import com.example.model.Profile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class InstanceSharedPreferences {

    private static InstanceSharedPreferences mInstanceSharedPreferences;

    private SharedPreferences mSharedPreferences;

    private Gson gson = new Gson();


    public static InstanceSharedPreferences getInstance(Context context) {

        if (mInstanceSharedPreferences == null) {

            mInstanceSharedPreferences = new InstanceSharedPreferences(context);
        }

        return mInstanceSharedPreferences;
    }

    public InstanceSharedPreferences(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setProperty(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public void setProperty(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }



    public void setProperty(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setHaveLearning(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setProfile(String key, Profile value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        String json = gson.toJson(value);
        editor.putString(key, json);
        editor.apply();
    }


    public String getProperty(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }


    public int getProperty(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }



    public boolean getProperty(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public boolean getHaveLearning(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public Profile getProfile(String key) {
        Profile mProfile = null;
        String json = mSharedPreferences.getString(key, null);
        if (json != null) {
            mProfile = gson.fromJson(json, Profile.class);
        }
        return mProfile;
    }

    public void setArrayList (ArrayList<DafLearning1> list, String key){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    public ArrayList <DafLearning1> getArrayList (String key){
        String json = mSharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<DafLearning1>>() {}.getType();
        return gson.fromJson(json, type);
    }




    public boolean deleteAll() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        return editor.commit();
    }



}
