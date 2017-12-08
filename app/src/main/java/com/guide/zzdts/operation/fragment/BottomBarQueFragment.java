package com.guide.zzdts.operation.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
public class BottomBarQueFragment extends Fragment {
    private MainActivity mainActivity;
    private ViewPager viewPagerLeft;
    private View view;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragmentArrayListLeft;
    private ZzQueFragment zzQueFragment;
    private TscQueFragment tscQueFragment;
    private DefineActionBar defineActionBarLeft;
//    private TextView textView_zz;
//    private TextView textView_tsc;

    public BottomBarQueFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("BottomBarQueFragment", getChildFragmentManager().toString()+"0");
        /**
         * 绑定到mainActivity
          */
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("BottomBarQueFragment","onCreatView");
        // Inflate the layout for this fragment
        initFragment();
        Log.e("BottomBarQueFragment","initFragment()");
        //导入fragment的布局。
        view = inflater.inflate(R.layout.fragment_bottom_bar_que, null);
        /**
         * 逻辑与视图分离，获取是都要获取，直接new类获取对象没有视图。报错。
         */
        defineActionBarLeft = (DefineActionBar) view.findViewById(R.id.defineActionBarLeft);
        Log.e("BottomBarQueFragment", view.toString());
        intiViewPager(view);
//        textView_zz = (TextView) new DefineActionBar(new BottomBarQueFragment().getContext()).findViewById(R.id.textView_zz);
//        textView_tsc = (TextView) new DefineActionBar(new BottomBarQueFragment().getContext()).findViewById(R.id.textView_tsc);
        Log.e("BottomBarQueFragment","initViewPager()");
        return view;
    }
    public void initFragment()
    {
        zzQueFragment = new ZzQueFragment();
        tscQueFragment = new TscQueFragment();
        fragmentArrayListLeft = new ArrayList<>();
        fragmentArrayListLeft.add(zzQueFragment);
        fragmentArrayListLeft.add(tscQueFragment);
        fragmentManager = getChildFragmentManager();
    }
    public void intiViewPager(View parentView)
    {
        click();
        viewPagerLeft = (ViewPager) parentView.findViewById(R.id.que_viewPager_left);
        Log.e("BottomBarQueFragment", getChildFragmentManager().toString()+"1");
        viewPagerLeft.setAdapter(new FragmentViewPagerAdapter(getChildFragmentManager(),fragmentArrayListLeft));
        Log.e("BottomBarQueFragment", getChildFragmentManager().toString()+"2");
        viewPagerLeft.setCurrentItem(0);
        viewPagerLeft.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(true);
                        defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(false);
//                        defineActionBarLeft.findViewById(R.id.textView_zz).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(true);
//                                defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(false);
//                            }
//                        });
//                        defineActionBarLeft.findViewById(R.id.textView_tsc).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(false);
//                                defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(true);
//                            }
//                        });
//                        Toast.makeText(mainActivity, "第一个", Toast.LENGTH_SHORT).show();
//                        textView_zz.setSelected(true);
//                        textView_tsc.setSelected(false);
                        break;
                    case 1:
                        defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(false);
                        defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(true);
//                        defineActionBarLeft.findViewById(R.id.textView_zz).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(false);
//                                defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(true);
//                            }
//                        });
//                        defineActionBarLeft.findViewById(R.id.textView_tsc).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                defineActionBarLeft.findViewById(R.id.textView_tsc).setSelected(true);
//                                defineActionBarLeft.findViewById(R.id.textView_zz).setSelected(false);
//                            }
//                        });
//                        Toast.makeText(mainActivity, "第二个", Toast.LENGTH_SHORT).show();
//                        textView_zz.setSelected(false);
//                        textView_tsc.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerLeft.setOffscreenPageLimit(2);
//        viewPager.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getParentFragment().getContext(), "nothing", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    /**
     * actionBar点击响应
     */
    public void click()
    {
        defineActionBarLeft.findViewById(R.id.textView_zz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerLeft.setCurrentItem(0);
            }
        });
        defineActionBarLeft.findViewById(R.id.textView_tsc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerLeft.setCurrentItem(1);
            }
        });
    }
}
