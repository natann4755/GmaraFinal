package com.example.myapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.Profile;
import com.example.myapp.R;
import com.example.myapp.databinding.FragmentNumberOfRepetitionsProfileBinding;
import com.example.myapp.databinding.FragmentTypeStudyProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumberOfRepetitionsProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberOfRepetitionsProfileFragment extends Fragment {
    public static final String TAG = NumberOfRepetitionsProfileFragment.class.getSimpleName();
    private FragmentNumberOfRepetitionsProfileBinding binding;
    private OnFragmentNumberOfRepetitionsProfile mListener;
    private static String KEY_profile = "KEY_profile";
    private Profile mProfile;

    public NumberOfRepetitionsProfileFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NumberOfRepetitionsProfileFragment newInstance(Profile profile) {
        NumberOfRepetitionsProfileFragment fragment = new NumberOfRepetitionsProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_profile,profile);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         mProfile = getArguments().getParcelable(KEY_profile);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            binding = FragmentNumberOfRepetitionsProfileBinding.inflate(inflater,container,false);
            initViewListeners();
            return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentNumberOfRepetitionsProfile) {
            mListener = (OnFragmentNumberOfRepetitionsProfile) context;
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

    private void initViewListeners() {
        binding.NumberOfRepOkTV.setOnClickListener(v -> {
            onRadioNumberOfReps();
            mListener.numberOfRepOk();
        });
    }

    public void onRadioNumberOfReps() {
        int selectedId = binding.ProfileNumberOfRepsRG.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.radio_No_thanks:
                mProfile.setNumberOfReps(0);
                break;
            case R.id.radio_Once:
                mProfile.setNumberOfReps(1);
                break;
            case R.id.radio_Twice:
                mProfile.setNumberOfReps(2);
                break;
            case R.id.radio_3_times:
                mProfile.setNumberOfReps(3);
                break;
        }
    }

    public interface OnFragmentNumberOfRepetitionsProfile {
        void numberOfRepOk ();
    }
}