package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rijul on 3/3/2017.
 */

class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        mContext=context;
    }
    private String tabTitles[] = new String[] { "Number", "Color", "Phrases","Family" };
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumberFragment();
        } else if (position == 1){
            return new ColorsFragment();
        } else if(position == 2){
            return new PhrasesFragment();
        }
        else{
            return new FamilyFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
