package com.example.vungoctruong.project5.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class Player implements Parcelable {

    public String name;
    public String field;
    public String age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.field);
        dest.writeString(this.age);
    }

    public Player() {
    }

    protected Player(Parcel in) {
        this.name = in.readString();
        this.field = in.readString();
        this.age = in.readString();
    }

    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
