package com.example.model.shas_masechtot_list_models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class AllShasItem implements Parcelable {

//    @SerializedName("seder")
    private List<SederItem> seder;

    protected AllShasItem(Parcel in) {
    }

    public static final Creator<AllShasItem> CREATOR = new Creator<AllShasItem>() {
        @Override
        public AllShasItem createFromParcel(Parcel in) {
            return new AllShasItem(in);
        }

        @Override
        public AllShasItem[] newArray(int size) {
            return new AllShasItem[size];
        }
    };

    public List<SederItem> getSeder() {
        return seder;
    }

    public void setSeder(List<SederItem> seder) {
        this.seder = seder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
