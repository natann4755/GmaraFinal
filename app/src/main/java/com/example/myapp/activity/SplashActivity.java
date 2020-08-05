package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.model.DafLearning1;
import com.example.model.Profile;
import com.example.myapp.R;
import com.example.myapp.dataBase.AppDataBase;
import com.example.myapp.utils.Language;
import com.example.myapp.utils.ManageSharedPreferences;
import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    public static String KEY_EXTRA_List1 = "KEY_EXTRA_List1";
    public static String KEY_EXTRA_List2 = "KEY_EXTRA_List2";
    public static String KEY_EXTRA_List3 = "KEY_EXTRA_List3";

    private boolean isHaveLearning;
    private Profile mProfile;
    private ArrayList <DafLearning1> mArrayListStudy1;
    private ArrayList  mArrayListStudy2;
    private ArrayList  mArrayListStudy3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isFirstTime();
        setLanguage();

        moveToNextActivity();
        if (isHaveLearning) {
            initData();
        }
    }

    private void isFirstTime() {
        isHaveLearning = ManageSharedPreferences.getHaveLearning(getBaseContext());
    }

    private void setLanguage() {
        mProfile = ManageSharedPreferences.getProfile(getBaseContext());
        if (mProfile == null) { return; }
        Language.setAppLanguage(mProfile.getLanguage(), getBaseContext());
    }

    private void moveToNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
                finish();
            }
        }, 3000);
    }


    private void initData() {
//        AppDataBase.getInstance(this).daoLearning1().deleteAll();
        mArrayListStudy1 = (ArrayList<DafLearning1>) AppDataBase.getInstance(this).daoLearning1().getAllLearning();
    }

    private void startNextActivity() {
        if (!isHaveLearning){
            startActivity(new Intent(SplashActivity.this, ProfileActivity.class));
            finish();
        }else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra(KEY_EXTRA_List1, mArrayListStudy1);
            intent.putExtra(KEY_EXTRA_List2, mArrayListStudy2);
            intent.putExtra(KEY_EXTRA_List3, mArrayListStudy3);
            startActivity(intent);
            finish();
        }
    }
}