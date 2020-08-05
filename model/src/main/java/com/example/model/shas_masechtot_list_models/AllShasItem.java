package com.example.model.shas_masechtot_list_models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class AllShasItem  {

//    @SerializedName("seder")
    private List<SederItem> seder;

    protected AllShasItem(Parcel in) {
    }


    public List<SederItem> getSeder() {
        return seder;
    }

    public void setSeder(List<SederItem> seder) {
        this.seder = seder;
    }


}
