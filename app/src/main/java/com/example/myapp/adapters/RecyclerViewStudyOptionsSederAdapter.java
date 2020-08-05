package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.shas_masechtot_list_models.AllShasItem;
import com.example.model.shas_masechtot_list_models.SederItem;
import com.example.myapp.R;

import java.util.ArrayList;

public class RecyclerViewStudyOptionsSederAdapter extends RecyclerView.Adapter<RecyclerViewStudyOptionsSederAdapter.Holder> {

    private Context mContext;
    private ArrayList<SederItem> mStudyOptions = new ArrayList<>();
    private RecyclerViewStudyOptionsMasechetAdapter.CreateTypeOfStudy createTypeOfStudy;

    public RecyclerViewStudyOptionsSederAdapter(Context mContext, ArrayList<SederItem> sederOptions, RecyclerViewStudyOptionsMasechetAdapter.CreateTypeOfStudy c) {
        this.mContext = mContext;
        this.mStudyOptions = sederOptions;
        this.createTypeOfStudy = c;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_study_options, parent, false);
        return new RecyclerViewStudyOptionsSederAdapter.Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setHolder(mStudyOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return mStudyOptions.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView study;
        private SederItem sederItem;
        private LinearLayout mRvLinearLayout;
        private RecyclerView mMasechtotRecyclerView;
        private RecyclerViewStudyOptionsMasechetAdapter mRecyclerViewStudyOptionsMasechetAdapter;

        public Holder(@NonNull View itemView) {
            super(itemView);
            study = itemView.findViewById(R.id.item_rv_study_TV);
            mMasechtotRecyclerView = itemView.findViewById(R.id.item_rv_RV);
            mRvLinearLayout = itemView.findViewById(R.id.item_rv_study_rv_LL);

            itemView.setOnClickListener(v -> {
                if (sederItem.isOpen()) {
                    sederItem.setOpen(false);
                    mRvLinearLayout.setVisibility(View.GONE);
                } else {
                    sederItem.setOpen(true);
                    mMasechtotRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
                    mRecyclerViewStudyOptionsMasechetAdapter = new RecyclerViewStudyOptionsMasechetAdapter(sederItem.getMasechtot(), mContext, createTypeOfStudy);
                    mMasechtotRecyclerView.setAdapter(mRecyclerViewStudyOptionsMasechetAdapter);
                    mRvLinearLayout.setVisibility(View.VISIBLE);
                }
            });
        }



        public void setHolder (SederItem seder){
            this.sederItem = seder;
            study.setText(seder.getName());
        }
    }
}
