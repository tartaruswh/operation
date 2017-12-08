package com.guide.zzdts.operation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 15840 on 2017/3/15.
 */

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    public FragmentViewPagerAdapter(FragmentManager fm,ArrayList <Fragment> fragmentArrayList) {
        super(fm);
        this.arrayList = fragmentArrayList;
        Log.e("QueFragmentAdapter","FragmentViewPagerAdapter");
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
