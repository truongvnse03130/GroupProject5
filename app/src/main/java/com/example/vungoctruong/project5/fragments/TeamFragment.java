package com.example.vungoctruong.project5.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.widget.Toast;

import com.example.vungoctruong.project5.activity.MainActivity;
import com.example.vungoctruong.project5.adapter.TeamAdapter;
import com.example.vungoctruong.project5.api.ApiCaller;
import com.example.vungoctruong.project5.entities.Team;
import com.example.vungoctruong.project5.navigation.NavigationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vu Ngoc Truong on 5/9/2016.
 */
public class TeamFragment extends ListFragment implements ApiCaller.ApiListener {

    private static final String KEY_DATA = "data";
    private ApiCaller mApiCaller;
    private ArrayList<Team> teamList;
    TeamAdapter mTeamAdapter;
    NavigationManager navigationManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationManager = ((MainActivity) getActivity()).getNavigationManager();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            teamList = savedInstanceState.getParcelableArrayList(KEY_DATA);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_DATA, teamList);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isDataReady()) {
            bindData();
        } else {
            mApiCaller = new ApiCaller();
            mApiCaller.setApiListener(this);
            mApiCaller.execute("https://api.myjson.com/bins/usgc");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSuccess(List<Team> clubs) {
        teamList = (ArrayList<Team>) clubs;
        bindData();
    }

    @Override
    public void onFailed() {
        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
        setListShown(false);
    }

    private void cancelApi() {
        if (mApiCaller != null) {
            mApiCaller.cancel(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelApi();
        mApiCaller = null;
    }

    private void bindData() {
        if (getListView() == null || teamList == null) return;
        if (mTeamAdapter == null) {
            mTeamAdapter = new TeamAdapter(getActivity(), teamList, navigationManager);
        }
        getListView().setAdapter(mTeamAdapter);
        setListShown(true);
    }

    private boolean isDataReady() {
        return teamList != null;
    }


}



