package com.guide.zzdts.operation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guide.zzdts.operation.R;

/**
 * Created by 15840 on 2017/3/1.
 */

public class DefineActionBar extends LinearLayout {
    private TextView textView_zz;
    private TextView textView_tsc;
//    private View bottomBarLeftFragment = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_bar_que,null);
//    private ViewPager que_viewPager;
//    public DefineActionBar(Context context) {
//        super(context);
//        initView();
////      que_viewPager = (ViewPager) findViewById(R.id.que_viewPager);
//        LayoutInflater.from(context).inflate(R.layout.define_action_bar, this);
//        Log.e("DefineActionBar","que_viewPager22");
//    }
    public DefineActionBar(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        Log.e("DefineActionBar","que_viewPager");
        LayoutInflater.from(context).inflate(R.layout.define_action_bar, this);
        textView_zz = (TextView) findViewById(R.id.textView_zz);
        textView_tsc = (TextView) findViewById(R.id.textView_tsc);
//        que_viewPager = (ViewPager) findViewById(R.id.que_viewPager);
        Log.e("DefineActionBar","que_viewPager1");
        initView();
        /**
         * 自定义actionBar用在多处，单纯设定相应单个fragment绑定操作会引起程序崩溃。
         * 将操作下放到每个fragment中单独操作。
         */
//        textView_zz.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView_zz.setSelected(true);
//                textView_tsc.setSelected(false);
//                Log.e("DefineActionBar","que_viewPager2");
////                bottomBarLeftFragment.getViewPager().setCurrentItem(0);
//            }
//        });
//        textView_tsc.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView_zz.setSelected(false);
//                textView_tsc.setSelected(true);
////                que_viewPager.setCurrentItem(1);
////                bottomBarLeftFragment.getViewPager().setCurrentItem(1);
//                Log.e("DefineActionBar","que_viewPager3");
//            }
//        });
    }

//    public DefineActionBar(Context context,AttributeSet attributeSet,int defStyle)
//    {
//        super(context,attributeSet,defStyle);
//        initView();
//    }
    public void initView()
    {
        textView_zz.setSelected(true);
        textView_tsc.setSelected(false);
    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId())
//        {
//            case R.id.textView_zz:
//                textView_zz.setSelected(true);
//                textView_tsc.setSelected(false);
//                break;
//            case R.id.textView_tsc:
//                textView_zz.setSelected(false);
//                textView_tsc.setSelected(true);
//                break;
//        }
//    }

    /**
     * 在activity中xml中的点击事件可以响应，在fragment中无法执行，最好使用代码设置不会出现混淆。
     * @param view
     */
//    public void ZzTscClick(View view)
//    {
//        switch (view.getId())
//        {
//            case R.id.textView_zz:
//                textView_zz.setSelected(true);
//                textView_tsc.setSelected(false);
//                break;
//            case R.id.textView_tsc:
//                textView_zz.setSelected(false);
//                textView_tsc.setSelected(true);
//                break;
//        }
//    }
//    public void TextViewClick()
//    {

//    }
}
