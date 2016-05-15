package com.example.vungoctruong.project5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.entities.Player;
import com.example.vungoctruong.project5.entities.Team;
import com.example.vungoctruong.project5.navigation.NavigationManager;

import java.util.ArrayList;
import java.util.List;

import view.FooterView;
import view.HeaderView;
import view.PlayerView;
import view.TeamView;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class TeamAdapter extends BaseAdapter {
    private static final int VIEW_TYPE_COUNT = 4;
    private static final int HEADER_VIEW = 0;
    private static final int CLUB_VIEW = 1;
    private static final int PLAYER_VIEW = 2;
    private static final int FOOTER_VIEW = 3;

    private List<Object> items;
    private LayoutInflater layoutInflater;
    private NavigationManager navigationManager;

    public TeamAdapter(Context context, List<Team> listTeam, NavigationManager navigationManager) {
        layoutInflater = LayoutInflater.from(context);
        this.navigationManager = navigationManager;
        initDatas(listTeam);
    }

    private void initDatas(List<Team> listTeam) {
        items = new ArrayList<>();
        items.add(new Object());
        if (listTeam != null) {
            for (Team team : listTeam) {
                items.add(team);
                if (team.playerList == null) {
                    continue;
                }
                for (Player player : team.playerList) {
                    items.add(player);
                }
            }
        }
        items.add(new Object());
    }

    @Override
    public int getCount() {
        //plus header & footer
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW;
        } else if (position == items.size() - 1) {
            return FOOTER_VIEW;
        } else {
            Object item = items.get(position);
            if (item instanceof Team) {
                return CLUB_VIEW;
            } else {
                return PLAYER_VIEW;
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case HEADER_VIEW:
                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.header_view, parent, false);
                }
                ((HeaderView) convertView).display(navigationManager);
                break;
            case CLUB_VIEW:
                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.team_view, parent, false);
                }
                ((TeamView) convertView).display(navigationManager, (Team) items.get(position));
                break;
            case PLAYER_VIEW:
                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.player_view, parent, false);
                }
                ((PlayerView) convertView).display(navigationManager, (Player) items.get(position));
                break;
            case FOOTER_VIEW:
                if (convertView == null) {
                    convertView = layoutInflater.inflate(R.layout.footer_view, parent, false);
                }
                ((FooterView) convertView).display(navigationManager);
                break;
        }
        return convertView;
    }
}
