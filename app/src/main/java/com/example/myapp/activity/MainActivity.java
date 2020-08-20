package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.model.DafLearning1;
import com.example.myapp.R;
import com.example.myapp.databinding.ActivityMainBinding;
import com.example.myapp.fragment.ShewStudyRvFragment;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

import static com.example.myapp.activity.SplashActivity.KEY_EXTRA_List1;


public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    ArrayList<DafLearning1> myList1;
    ArrayList<DafLearning1>  myList2;
    ArrayList<DafLearning1>  myList3;
    private ShewStudyRvFragment mShewStudyRvFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        myList1 = getIntent().getParcelableArrayListExtra(KEY_EXTRA_List1);
        openFragment(mShewStudyRvFragment = ShewStudyRvFragment.newInstance(myList1, myList2 , myList3), ShewStudyRvFragment.TAG);
        initViews();
    }

    public void openFragment(Fragment myFragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.MA_frameLayout, myFragment)
                .addToBackStack(tag)
                .commit();
    }

    private void initViews() {
        if (myList1 != null && myList1.size()>0){
            binding.typeOfStudy1BU.setText(myList1.get(0).getTypeOfStudy());
        }
        if (myList2 != null && myList2.size()>0){
            binding.typeOfStudy2BU.setText(myList2.get(0).getTypeOfStudy());
        }
        if (myList3 != null && myList3.size()>0){
            binding.typeOfStudy3BU.setText(myList3.get(0).getTypeOfStudy());
        }
        binding.typeOfStudy1BU.setOnClickListener(v -> {mShewStudyRvFragment.changeLearning(1);});
        binding.typeOfStudy2BU.setOnClickListener(v -> {mShewStudyRvFragment.changeLearning(2);});
        binding.typeOfStudy3BU.setOnClickListener(v -> {mShewStudyRvFragment.changeLearning(3);});
    }
}