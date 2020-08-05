package com.example.model.shas_masechtot_list_models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SederItem implements Parcelable {

    @SerializedName("name")
    private String name;

    @SerializedName("masechtot")
    private List<MasechetItem> masechtot;

    private boolean isOpen = false;

    public SederItem(String name, List<MasechetItem> masechet) {
        this.name = name;
        this.masechtot = masechet;
    }

    protected SederItem(Parcel in) {
        name = in.readString();
        masechtot = in.createTypedArrayList(MasechetItem.CREATOR);
        isOpen = in.readByte() != 0;
    }

    public static final Creator<SederItem> CREATOR = new Creator<SederItem>() {
        @Override
        public SederItem createFromParcel(Parcel in) {
            return new SederItem(in);
        }

        @Override
        public SederItem[] newArray(int size) {
            return new SederItem[size];
        }
    };

    public boolean isOpen() { return isOpen; }

    public void setOpen(boolean open) { isOpen = open; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MasechetItem> getMasechtot() {
        return masechtot;
    }

    public void setMasechtot(List<MasechetItem> masechet) {
        this.masechtot = masechet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(masechtot);
        dest.writeByte((byte) (isOpen ? 1 : 0));
    }
}
