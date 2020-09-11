package com.pluralsight.gadsleaderboard_final;

import android.os.Parcel;
import android.os.Parcelable;

public class SkillIQ implements Parcelable {

    private String mName;
    private int mScore;
    private String mCountry;

    public SkillIQ(){};

    public SkillIQ(String name, int score, String country)
    {
        mName = name;
        mScore = score;
        mCountry = country;
    }

    private SkillIQ(Parcel source)
    {
        mName = source.readString();
        mScore = source.readInt();
        mCountry = source.readString();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mScore);
        dest.writeString(mCountry);
    }

    public static final Creator<SkillIQ> CREATOR = new Creator<SkillIQ>() {
        @Override
        public SkillIQ createFromParcel(Parcel in) {
            return new SkillIQ(in);
        }

        @Override
        public SkillIQ[] newArray(int size) {
            return new SkillIQ[size];
        }
    };


}
