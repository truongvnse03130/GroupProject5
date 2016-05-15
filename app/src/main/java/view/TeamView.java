package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.entities.Team;
import com.example.vungoctruong.project5.fragments.PlayerFragment;
import com.example.vungoctruong.project5.navigation.NavigationManager;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class TeamView extends LinearLayout {
    Team team;

    NavigationManager navigationManager;
    TextView nameView;

    public TeamView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameView = (TextView) findViewById(R.id.title);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team == null) {
                    return;
                }
                navigationManager.displayFragment(PlayerFragment.newInstance(PlayerFragment.CLUB, team.name));
            }
        });
    }

    public void display(NavigationManager navigationManager, Team club) {
        this.navigationManager = navigationManager;
        this.team = club;

        if (club != null) {
            nameView.setText(club.name);
        } else {
            nameView.setText("");
        }
    }
}
