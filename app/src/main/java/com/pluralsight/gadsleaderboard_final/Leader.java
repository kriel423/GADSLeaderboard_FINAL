package com.pluralsight.gadsleaderboard_final;

import android.os.Parcel;
import android.os.Parcelable;

public class Leader implements Parcelable {

    private String mName;
    private int mHours;
    private String mCountry;

    public Leader(){}

    public Leader(String name, int hours, String country)
    {
        mName = name;
        mHours = hours;
        mCountry = country;
    }

    private Leader(Parcel source)
    {
        mName = source.readString();
        mHours = source.readInt();
        mCountry = source.readString();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmHours() {
        return mHours;
    }

    public void setmHours(int mHours) {
        this.mHours = mHours;
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
        dest.writeInt(mHours);
        dest.writeString(mCountry);
    }

    public static final Parcelable.Creator<Leader> CREATOR =
            new Parcelable.Creator<Leader>(){

                @Override
                public Leader createFromParcel(Parcel source) {
                    return new Leader(source);
                }

                @Override
                public Leader[] newArray(int size) {
                    return new Leader[size];
                }
            };
}
