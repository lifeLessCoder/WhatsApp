package com.example.android.whatsapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.setCurrentItem(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        WhatsAppPagerAdapter whatsAppPagerAdapter = new WhatsAppPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(whatsAppPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);

        // Set the icon on the tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_photo_camera);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(mViewPager.getCurrentItem() == 0) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (cameraIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(cameraIntent);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });

        LinearLayout layout = ((LinearLayout) ((LinearLayout) tabLayout.getChildAt(0)).getChildAt(0));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.weight = 0.47f; // e.g. 0.5f
        layout.setLayoutParams(layoutParams);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
