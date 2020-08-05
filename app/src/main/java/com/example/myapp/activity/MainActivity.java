package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.model.DafLearning1;
import com.example.myapp.R;
import com.example.myapp.fragment.TypeStudyFragment;


import java.util.ArrayList;

import static com.example.myapp.activity.SplashActivity.KEY_EXTRA_List1;


public class MainActivity extends AppCompatActivity  {

    ArrayList<DafLearning1> myList1;
//    ArrayList<Daf>  myList2 = new ArrayList<>();
//    ArrayList<Daf>  myList3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList1 = getIntent().getParcelableArrayListExtra(KEY_EXTRA_List1);
        openFragment(TypeStudyFragment.newInstance(myList1), TypeStudyFragment.TAG);
    }

    public void openFragment(Fragment myFragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.MA_frameLayout, myFragment)
                .addToBackStack(tag)
                .commit();
    }


}