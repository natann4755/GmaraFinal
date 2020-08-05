package com.example.model.shas_masechtot_list_models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MasechetItem implements Parcelable {
    @SerializedName("pages")
    private int pages;

    @SerializedName("masechet")
    private String name;




    public MasechetItem(int pages, String name) {
        this.pages = pages;
        this.name = name;
    }


    protected MasechetItem(Parcel in) {
        pages = in.readInt();
        name = in.readString();
    }

    public static final Creator<MasechetItem> CREATOR = new Creator<MasechetItem>() {
        @Override
        public MasechetItem createFromParcel(Parcel in) {
            return new MasechetItem(in);
        }

        @Override
        public MasechetItem[] newArray(int size) {
            return new MasechetItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pages);
        dest.writeString(name);
    }
}
