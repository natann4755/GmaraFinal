package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Profile implements Parcelable {
   private ArrayList <String> typeOfStudy = new ArrayList<>();
   private int numberOfReps;
   private boolean hebrewCalendar = true;
   private boolean warning;
   private String alertFrequency;
   private String language;

   public boolean isHebrewCalendar() {
      return hebrewCalendar;
   }

   public void setHebrewCalendar(boolean hebrewCalendar) {
      this.hebrewCalendar = hebrewCalendar;
   }

   public Profile(int numberOfReps) {
      this.numberOfReps = numberOfReps;
   }


   protected Profile(Parcel in) {
      typeOfStudy = in.createStringArrayList();
      numberOfReps = in.readInt();
      hebrewCalendar = in.readByte() != 0;
      warning = in.readByte() != 0;
      alertFrequency = in.readString();
      language = in.readString();
   }

   public static final Creator<Profile> CREATOR = new Creator<Profile>() {
      @Override
      public Profile createFromParcel(Parcel in) {
         return new Profile(in);
      }

      @Override
      public Profile[] newArray(int size) {
         return new Profile[size];
      }
   };

   public ArrayList<String> getTypeOfStudy() {
      return typeOfStudy;
   }

   public void setTypeOfStudy(String typeOfStudy) {
      if (this.typeOfStudy.size()<3)
      this.typeOfStudy.add(typeOfStudy);
   }

   public int getNumberOfReps() {
      return numberOfReps;
   }

   public void setNumberOfReps(int numberOfReps) {
      this.numberOfReps = numberOfReps;
   }

   public boolean isWarning() {
      return warning;
   }

   public void setWarning(boolean warning) {
      this.warning = warning;
   }

   public String getAlertFrequency() {
      return alertFrequency;
   }

   public void setAlertFrequency(String alertFrequency) {
      this.alertFrequency = alertFrequency;
   }

   public String getLanguage() {
      return language;
   }

   public void setLanguage(String language) {
      this.language = language;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeStringList(typeOfStudy);
      dest.writeInt(numberOfReps);
      dest.writeByte((byte) (hebrewCalendar ? 1 : 0));
      dest.writeByte((byte) (warning ? 1 : 0));
      dest.writeString(alertFrequency);
      dest.writeString(language);
   }
}
