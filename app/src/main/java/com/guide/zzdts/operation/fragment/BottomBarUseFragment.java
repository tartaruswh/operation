package com.guide.zzdts.operation.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.zzdts.operation.activity.MainActivity;
import com.guide.zzdts.operation.R;
import com.guide.zzdts.operation.adapter.FragmentViewPagerAdapter;
import com.guide.zzdts.operation.ui.DefineActionBar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomBarUseFragment extends Fragment {

    private MainActivity mainActivity;
    private ViewPager viewPagerMiddle;
    private View view;
    private ArrayList<Fragment> arrayListMiddle;
    private TscUseFragment tscUseFragment;
    private ZzUseFragment zzUseFragment;
    private DefineActionBar defineActionBarMiddle;
    private FragmentManager fragmentManager;

    public BottomBarUseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //view中的布局都是通过该父布局进行查找
        view = inflater.inflate(R.layout.fragment_bottom_bar_use, null);
        defineActionBarMiddle = (DefineActionBar) view.findViewById(R.id.defineActionBarMiddle);
        initFragment();
        initViewPager(view);
        return view;
    }
    public void initFragment()
    {
        zzUseFragment = new ZzUseFragment();
        tscUseFragment = new TscUseFragment();
        arrayListMiddle = new ArrayList<>();
        arrayListMiddle.add(zzUseFragment);
        arrayListMiddle.add(tscUseFragment);
        fragmentManager = getChildFragmentManager();
    }
    public void initViewPager(View parentView)
    {
        click();
        viewPagerMiddle = (ViewPager) parentView.findViewById(R.id.viewPagerMiddle);
        viewPagerMiddle.setAdapter(new FragmentViewPagerAdapter(getChildFragmentManager(),arrayListMiddle));
        viewPagerMiddle.setCurrentItem(0);
        viewPagerMiddle.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        defineActionBarMiddle.findViewById(R.id.textView_zz).setSelected(true);
                        defineActionBarMiddle.findViewById(R.id.textView_tsc).setSelected(false);
                        break;
                    case 1:
                        defineActionBarMiddle.findViewById(R.id.textView_zz).setSelected(false);
                        defineActionBarMiddle.findViewById(R.id.textView_tsc).setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerMiddle.setOffscreenPageLimit(2);
    }

    /**
     * 点击事件在fragment中嵌套viewPager使用xml的onClick与实现接口onClick都报错，直接设置clickListener
     * 可解决。
     */
    public void click()
    {
        defineActionBarMiddle.findViewById(R.id.textView_zz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerMiddle.setCurrentItem(0);
            }
        });
        defineActionBarMiddle.findViewById(R.id.textView_tsc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerMiddle.setCurrentItem(1);
            }
        });
    }

}
