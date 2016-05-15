package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.entities.Player;
import com.example.vungoctruong.project5.fragments.PlayerFragment;
import com.example.vungoctruong.project5.navigation.NavigationManager;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class PlayerView extends LinearLayout {
    Player player;

    NavigationManager navigationManager;
    TextView nameView;

    public PlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameView = (TextView) findViewById(R.id.title);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player == null) {
                    return;
                }
                navigationManager.displayFragment(PlayerFragment.newInstance(PlayerFragment.PLAYER, player.name));
            }
        });
    }

    public void display(NavigationManager navigationManager, Player player) {
        this.navigationManager = navigationManager;
        this.player = player;

        if (player != null) {
            nameView.setText(player.name);
        } else {
            nameView.setText("");
        }
    }
}
