package com.example.model.shas_masechtot_list_models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MasechetItem {
    @SerializedName("pages")
    private int pages;

    @SerializedName("masechet")
    private String name;


    public MasechetItem(int pages, String name) {
        this.pages = pages;
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
