package com.example.android.whatsapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Adapter to populate the view pager
 */
public class WhatsAppPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public WhatsAppPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new EmptyFragment();
            case 1:return new ChatsFragment();
            case 2:return new EmptyFragment();
            case 3:return new EmptyFragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return null;
            case 1:return mContext.getString(R.string.tab_chats);
            case 2:return mContext.getString(R.string.tab_status);
            case 3:return mContext.getString(R.string.tab_calls);
            default:return null;
        }
    }
}
