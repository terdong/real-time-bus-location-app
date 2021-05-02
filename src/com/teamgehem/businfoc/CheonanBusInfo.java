package com.teamgehem.businfoc;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class CheonanBusInfo extends TabActivity {
    private TabHost tabHost;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tab1")
                       .setIndicator(getText(R.string.tab_title_home),getResources().getDrawable(R.drawable.android_home))
                       .setContent(new Intent(this,TabHome.class))
        );
       /*tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator(getText(R.string.tab_title_state))
                .setContent(new Intent(this,TabState.class))
                );
                */
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator(getText(R.string.tab_title_search),getResources().getDrawable(android.R.drawable.ic_menu_search))
                .setContent(new Intent(this,TabSearchSearch.class))
        );
        /*tabHost.addTab(tabHost.newTabSpec("tab4")
                .setIndicator(getText(R.string.tab_title_option))
                .setContent(new Intent(this,TabOption.class))
        );*/
        tabHost.addTab(tabHost.newTabSpec("tab5")
                .setIndicator(new LinearLayout(this))
                .setContent(new Intent(this,TabSearchSearch.class))
        );
        tabHost.getTabWidget().getChildAt(2).setVisibility(View.GONE);
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId)
            {
                tabHost.getCurrentView().setAnimation(AnimationUtils.loadAnimation(CheonanBusInfo.this, android.R.anim.fade_in));
            }
        });
    }
} // class







