package com.example.myapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.model.Profile;
import com.example.model.shas_masechtot_list_models.AllShasItem;
import com.example.model.shas_masechtot_list_models.SederItem;
import com.example.myapp.R;
import com.example.myapp.adapters.RecyclerViewStudyOptionsMasechetAdapter;
import com.example.myapp.adapters.RecyclerViewStudyOptionsSederAdapter;
import com.example.myapp.databinding.FragmentTypeStudyBinding;
import com.example.myapp.databinding.FragmentTypeStudyProfileBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TypeStudyProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TypeStudyProfileFragment extends Fragment implements RecyclerViewStudyOptionsMasechetAdapter.CreateTypeOfStudy {
    private FragmentTypeStudyProfileBinding binding;
    public static final String TAG = TypeStudyProfileFragment.class.getSimpleName();
    private OnFragmentTypeStudyProfile mListener;
    private static String KEY_profile = "KEY_profile";
    private static String KEY_AllShas = "KEY_AllShas";
    private Profile mProfile;
    private AllShasItem mAllShas;
    private RecyclerView myRecyclerViewStudyOptions;
    private RecyclerViewStudyOptionsSederAdapter mRecyclerViewStudyOptionsAdapter;
    private boolean mOptionTalmudBavlyOpen = false;

    private TextView studyOptionDafHyomy;
    private TextView studyOptionTalmudBavly;

    public TypeStudyProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TypeStudyProfileFragment newInstance(Profile profile, AllShasItem mAllShas) {
        TypeStudyProfileFragment fragment = new TypeStudyProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_profile, profile);
        args.putParcelable(KEY_AllShas, mAllShas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProfile = getArguments().getParcelable(KEY_profile);
            mAllShas = getArguments().getParcelable(KEY_AllShas);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTypeStudyProfileBinding.inflate(inflater, container, false);
        initViews();
        initListener();
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentTypeStudyProfile) {
            mListener = (OnFragmentTypeStudyProfile) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initViews() {
        studyOptionDafHyomy = binding.studyOptionDafHyomy;
        studyOptionTalmudBavly = binding.studyOptionTalmudBavly;
    }

    private void initListener() {
        studyOptionDafHyomy.setOnClickListener(v -> {
            mListener.updateActivityTypeStudy("דף היומי", 2711);
        });
        studyOptionTalmudBavly.setOnClickListener(v -> {
            if (mOptionTalmudBavlyOpen == false){
                mOptionTalmudBavlyOpen = true;
                initRecyclerView();
            }else {
                mOptionTalmudBavlyOpen = false;
                myRecyclerViewStudyOptions.setVisibility(View.GONE);
            }

        });
        binding.typeStudyOkTV.setOnClickListener(v -> mListener.typeStudyOk());
    }

    private void initRecyclerView() {
        myRecyclerViewStudyOptions = binding.myRecyclerView;
        myRecyclerViewStudyOptions.setVisibility(View.VISIBLE);
        myRecyclerViewStudyOptions.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewStudyOptionsAdapter = new RecyclerViewStudyOptionsSederAdapter(getContext(), (ArrayList<SederItem>) mAllShas.getSeder(),this);
        myRecyclerViewStudyOptions.setAdapter(mRecyclerViewStudyOptionsAdapter);
    }

    @Override
    public void CreateListTypeOfStudy(String stringTypeOfStudy, int pages) {
        mListener.updateActivityTypeStudy(stringTypeOfStudy, pages);
    }


    public interface OnFragmentTypeStudyProfile {
       void updateActivityTypeStudy(String TypeOfStudy, int Pages);
        void typeStudyOk ();
    }
}