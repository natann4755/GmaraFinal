package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.DafLearning1;
import com.example.model.Profile;
import com.example.myapp.R;
import com.example.myapp.dataBase.AppDataBase;
import com.example.myapp.utils.ConvertIntToPage;
import com.example.myapp.utils.ManageSharedPreferences;
import com.example.myapp.utils.UtilsCalender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class OneDafAdapter extends RecyclerView.Adapter<OneDafAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private Profile mProfile;
    private ArrayList<DafLearning1> myListMaster1 = new ArrayList<>();
    private ArrayList<DafLearning1> myListMaster2 = new ArrayList<>();
    private ArrayList<DafLearning1> myListMaster3 = new ArrayList<>();

    private ArrayList<DafLearning1> myListALLDaf = new ArrayList<>();
    private ArrayList<DafLearning1> myListDafToDisplay = new ArrayList<>();
    private ArrayList<DafLearning1> myListFilterDaf = new ArrayList<>();

    public OneDafAdapter(Context context, ArrayList<DafLearning1> myListMaster1 , ArrayList<DafLearning1> myListMaster2, ArrayList<DafLearning1> myListMaster3) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.myListMaster1 = myListMaster1;
        this.myListMaster2 = myListMaster2;
        this.myListMaster3 = myListMaster3;
        this.myListALLDaf.addAll(myListMaster1);
        this.myListDafToDisplay.addAll(myListALLDaf);
        initProfile();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_daf, parent, false);
        return new OneDafAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setHolder(myListDafToDisplay.get(position));

    }

    @Override
    public int getItemCount() {
        return myListDafToDisplay.size();
    }

    private void initProfile() {
        mProfile = ManageSharedPreferences.getProfile(context);
    }

    public void filterChangeTypeStudy(int typeStudy){
        switch(typeStudy) {
            case 1:
                myListALLDaf.addAll(myListMaster1);
                changeDisplayList(myListALLDaf);
                break;
            case 2:
                myListALLDaf.addAll(myListMaster2);
                changeDisplayList(myListALLDaf);
                break;
            case 3:
                myListALLDaf.addAll(myListMaster3);
                changeDisplayList(myListALLDaf);
                break;
        }
    }



    public void filterAllMasechtot(String myNameMasechet){
        myListFilterDaf.clear();
        for (int i = 0; i <myListALLDaf.size() ; i++) {
            if (myListALLDaf.get(i).getMasechet().equals(myNameMasechet)) {
                myListFilterDaf.add(myListALLDaf.get(i));
            }
        }
        changeDisplayList(myListFilterDaf);
    }

    public void filterLearned(){
        myListFilterDaf.clear();
        for (int i = 0; i <myListALLDaf.size() ; i++) {
            if (myListALLDaf.get(i).isLearning()) {
                myListFilterDaf.add(myListALLDaf.get(i));
            }
        }
        Collections.reverse(myListFilterDaf);
        changeDisplayList(myListFilterDaf);
    }

    public void filterSkipped(){
        myListFilterDaf.clear();
        int todayDaf = -1;
        int myLastLerneng = -1;
        if(myListALLDaf.size()<2000){
            myLastLerneng = findLastLearned();
            if (myLastLerneng != -1) {
                for (int i = 0; i <= myLastLerneng; i++) {
                    if (!myListALLDaf.get(i).isLearning()) {
                        myListFilterDaf.add(myListALLDaf.get(i));
                    }
                }
            }
        }
        if(myListALLDaf.size()>2000){
            todayDaf = findTodayDafMoveRV();
            if (todayDaf != -1) {
                for (int i = 0; i <= todayDaf; i++) {
                    if (!myListALLDaf.get(i).isLearning()) {
                        myListFilterDaf.add(myListALLDaf.get(i));
                    }
                }
            }
        }
        Collections.reverse(myListFilterDaf);
        changeDisplayList(myListFilterDaf);
    }

    private int findLastLearned() {
        int lastLearned =-1;
        for (int i = myListALLDaf.size()-1; i >= 0 ; i--) {
            if (myListALLDaf.get(i).isLearning()) {
                lastLearned = i;
                break;
            }
        }
        return lastLearned;
    }

    public  int findTodayDafMoveRV() {
        int todayDafInList = -1;
        String today = UtilsCalender.dateStringFormat(Calendar.getInstance());
        for (int i = 0; i < myListALLDaf.size(); i++) {
            if (myListALLDaf.get(i).getPageDate().equals(today)) {
                todayDafInList = i;
                break;
            }
        }
        return todayDafInList;
    }

    public void filterAllDapim(){
        changeDisplayList(myListALLDaf);
    }

    private void changeDisplayList(ArrayList<DafLearning1> mNewList) {
        myListDafToDisplay.clear();
        myListDafToDisplay.addAll(mNewList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        CheckBox ifLearning;
        TextView masechet;
        TextView numDaf;
        TextView date;
        LinearLayout linearLayoutChazara;
        CheckBox chazara1;
        CheckBox chazara2;
        CheckBox chazara3;
        DafLearning1 mDaf;


        ViewHolder(View itemView) {
            super(itemView);
            ifLearning = itemView.findViewById(R.id.one_daf_checkbox);
            masechet = itemView.findViewById(R.id.one_daf_Tv_masechet);
            numDaf = itemView.findViewById(R.id.one_daf_Tv_numPage);
            date = itemView.findViewById((R.id.one_daf_Tv_date));
            linearLayoutChazara = itemView.findViewById((R.id.one_daf_chazara_LL));
            chazara1 = itemView.findViewById((R.id.chazara_1_CB));
            chazara2 = itemView.findViewById((R.id.chazara_2_CB));
            chazara3 = itemView.findViewById((R.id.chazara_3_CB));
            initNumOfChazara();

            ifLearning.setOnClickListener(v -> {
                if (!ifLearning.isChecked()){
                    if (chazara1.isChecked()){chazara1.performClick();}
                }
                AppDataBase.getInstance(context).daoLearning1().updateIsLearning(ifLearning.isChecked(), mDaf.getMasechet(),mDaf.getPageNumber());
                updateListIfLearning(ifLearning.isChecked());
            });

            chazara1.setOnClickListener(v -> {
                if (chazara1.isChecked()){
                    ListenerChazara(1);
                }else {
                    ListenerChazara(0);
                }
            });
            chazara2.setOnClickListener(v -> {
            if (chazara2.isChecked()){
                ListenerChazara(2);
            }else {
                ListenerChazara(1);
            }
        });
            chazara3.setOnClickListener(v -> {
                if (chazara3.isChecked()){
                    ListenerChazara(3);
                }else {
                    ListenerChazara(2);
                }
            });
        }

        private void updateListIfLearning(boolean checked) {
            for (int i = 0; i <myListALLDaf.size() ; i++) {
                if (myListALLDaf.get(i).getMasechet().equals(mDaf.getMasechet()) && myListALLDaf.get(i).getPageNumber() == mDaf.getPageNumber()){
                    myListALLDaf.get(i).setLearning(checked);
                    return;
                }
            }
        }


        private void ListenerChazara(int chazara) {
            switch(chazara) {
                case 0:
                    UpdateListAndDB(0);
                    chazara2.setChecked(false);
                    chazara3.setChecked(false);
                    break;
                case 1:
                    UpdateListAndDB(1);
                    if (!ifLearning.isChecked()){
                        ifLearning.performClick();
                    }
                    chazara2.setChecked(false);
                    chazara3.setChecked(false);
                    break;
                case 2:
                    chazara1.setChecked(true);
                    UpdateListAndDB(2);
                    chazara3.setChecked(false);
                    if (!ifLearning.isChecked()){
                        ifLearning.performClick();
                    }
                    break;
                case 3:
                    chazara1.setChecked(true);
                    chazara2.setChecked(true);
                    UpdateListAndDB(3);
                    if (!ifLearning.isChecked()){
                        ifLearning.performClick();
                    }
                    break;
            }
        }

        private void UpdateListAndDB(int chazara) {
            AppDataBase.getInstance(context).daoLearning1().updateNumOfChazara(chazara,mDaf.getMasechet(), mDaf.getPageNumber());
            updateListInChazara(chazara);
        }

        private void updateListInChazara(int chazara) {
            for (int i = 0; i <myListALLDaf.size() ; i++) {
                if (myListALLDaf.get(i).getMasechet().equals(mDaf.getMasechet()) && myListALLDaf.get(i).getPageNumber() == mDaf.getPageNumber()){
                    myListALLDaf.get(i).setChazara(chazara);
                    return;
                }
            }
        }

        private void initNumOfChazara() {
            int numOfChazara = mProfile.getNumberOfReps();
            switch(numOfChazara) {
                case 0:
                 linearLayoutChazara.setVisibility(View.GONE);
                    break;
                case 1:
                    chazara2.setVisibility(View.GONE);
                    chazara3.setVisibility(View.GONE);
                    break;
                case 2:
                    chazara3.setVisibility(View.GONE);
                    break;
            }
        }


        public void setHolder(DafLearning1 mDaf) {
            this.mDaf = mDaf;
            ifLearning.setChecked(mDaf.isLearning());
            masechet.setText(mDaf.getMasechet());
            numDaf.setText(ConvertIntToPage.intToPage(mDaf.getPageNumber()));
            initChazara(mDaf.getChazara());
            if (mDaf.getPageDate() != null && !mDaf.getPageDate().equals("")) {
                date.setText(UtilsCalender.convertDateToHebrewDate(mDaf.getPageDate()));
            }
        }
        private void initChazara(int chazara) {
            switch(chazara) {
                case 0:
                    chazara1.setChecked(false);
                    chazara2.setChecked(false);
                    chazara3.setChecked(false);
                    break;
                case 1:
                    chazara1.setChecked(true);
                    chazara2.setChecked(false);
                    chazara3.setChecked(false);
                    break;
                case 2:
                    chazara1.setChecked(true);
                    chazara2.setChecked(true);
                    chazara3.setChecked(false);
                    break;
                case 3:
                    chazara1.setChecked(true);
                    chazara2.setChecked(true);
                    chazara3.setChecked(true);
                    break;
            }
        }

    }
}

