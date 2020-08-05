package com.example.myapp.utils;

import android.content.Context;
import com.example.model.DafLearning1;
import com.example.model.Profile;


import java.util.ArrayList;

public class ManageSharedPreferences {
    public static String KEY_haveProfile = "KEYisConnected";
    public static String KEY_haveLearning = "KEY_haveLearning";
    public static String KEY_ListLearning = "ListLearning";


    public static void setProfile (Profile profile, Context context) {

        InstanceSharedPreferences.getInstance(context).setProfile(KEY_haveProfile, profile);

    }

    public static Profile getProfile(Context context) {
        Profile profile = InstanceSharedPreferences.getInstance(context)
                .getProfile(KEY_haveProfile);
        return profile;

    }

    public static void setHaveLearning (boolean haveLearning, Context context) {

        InstanceSharedPreferences.getInstance(context).setHaveLearning(KEY_haveLearning, haveLearning);

    }

    public static boolean getHaveLearning(Context context) {
        boolean haveLearning = InstanceSharedPreferences.getInstance(context)
                .getHaveLearning(KEY_haveLearning,false);
        return haveLearning;

    }

    public static void saveArrayList (ArrayList<DafLearning1> list, Context context) {
        InstanceSharedPreferences.getInstance(context)
                .setArrayList(list, KEY_ListLearning);
    }

    public static ArrayList<DafLearning1> getArrayList(Context context){
        ArrayList mArrayList =  InstanceSharedPreferences.getInstance(context)
                .getArrayList(KEY_ListLearning);
        return mArrayList;
    }

}
