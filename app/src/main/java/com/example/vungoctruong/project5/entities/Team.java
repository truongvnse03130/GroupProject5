package com.example.vungoctruong.project5.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class Team implements Parcelable {
    public String name;
    public int playerNumber;
    public List<Player> playerList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.playerNumber);
        dest.writeTypedList(this.playerList);
    }

    public Team() {
    }

    protected Team(Parcel in) {
        this.name = in.readString();
        this.playerNumber = in.readInt();
        this.playerList = in.createTypedArrayList(Player.CREATOR);
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
