package com.example.vungoctruong.project5.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vungoctruong.project5.R;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class PlayerFragment extends Fragment {
    public static final int HEADER = 0;
    public static final int CLUB = 1;
    public static final int PLAYER = 2;
    public static final int FOOTER = 3;

    private static final String KEY_TYPE = "type";
    private static final String KEY_CONTENT = "content";


    private int type;
    private String content;

    private TextView mTitleView;

    public static PlayerFragment newInstance(int type, String content) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TYPE, type);
        bundle.putString(KEY_CONTENT, content);
        PlayerFragment detailFragment = new PlayerFragment();
        detailFragment.setArguments(bundle);
        return detailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            type = savedInstanceState.getInt(KEY_TYPE);
            content = savedInstanceState.getString(KEY_CONTENT);
        } else {
            type = getArguments().getInt(KEY_TYPE);
            content = getArguments().getString(KEY_CONTENT);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_TYPE, type);
        outState.putString(KEY_CONTENT, content);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitleView = (TextView) view.findViewById(R.id.title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (type) {
            case HEADER:
                mTitleView.setText("Header");
                break;
            case CLUB:
                mTitleView.setText("Football team: " + content);
                break;
            case PLAYER:
                mTitleView.setText("Football Player: " + content);
                break;
            case FOOTER:
                mTitleView.setText("Footer" + content);
                break;
        }
    }
}
