package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vungoctruong.project5.R;
import com.example.vungoctruong.project5.fragments.PlayerFragment;
import com.example.vungoctruong.project5.navigation.NavigationManager;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class HeaderView extends LinearLayout {
    NavigationManager navigationManager;
    TextView nameView;

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameView = (TextView) findViewById(R.id.title);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationManager.displayFragment(PlayerFragment.newInstance(PlayerFragment.HEADER, ""));
            }
        });
    }

    public void display(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }
}
