package com.example.myapp.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerDataLearningAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> myList;
    Context context;


    public ViewPagerDataLearningAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> myList, Context context) {
        super(fm);
        this.myList = myList;
        this.context = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myList.get(position);
    }

    @Override
    public int getCount() {
        return myList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "למדתי";
            int i =2;
        }
        else if (position == 1)
        {
            title ="לא למדתי";

        }
        else if (position == 2)
        {
            title ="דילגתי";

        }
        return title;
    }
}
