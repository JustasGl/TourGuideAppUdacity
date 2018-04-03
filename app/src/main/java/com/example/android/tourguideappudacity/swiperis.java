package com.example.android.tourguideappudacity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class swiperis extends FragmentPagerAdapter {
    Context context;
    public swiperis(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MazeikiuRestoranai_fragmentas();
        } else if (position == 1) {
            return new TelsiuRestoranai_fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
        return context.getString(R.string.Mazeikiai);
        else return context.getString(R.string.Telsiai);
    }

}