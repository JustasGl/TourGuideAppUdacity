package com.example.android.tourguideappudacity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class swiperis extends FragmentPagerAdapter {

    public swiperis(FragmentManager fm) {
        super(fm);
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
        return "Mažeikiai";
        else return "Telšiai";
    }

}