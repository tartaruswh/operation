package com.guide.zzdts.operation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.guide.zzdts.operation.R;
import com.guide.zzdts.operation.fragment.BottomBarCommuFragment;
import com.guide.zzdts.operation.fragment.BottomBarQueFragment;
import com.guide.zzdts.operation.fragment.BottomBarUseFragment;
import com.guide.zzdts.operation.fragment.BottomBarMineFragment;

public class MainActivity extends AppCompatActivity {
    private Button button_bottom_bar_que,button_bottom_bar_use,button_bottom_bar_commu,button_bottom_bar_mine;
    private BottomBarQueFragment bottomBarQueFragment;
    private BottomBarUseFragment bottomBarUseFragment;
    private BottomBarCommuFragment bottomBarCommuFragment;
    private BottomBarMineFragment bottomBarMineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        /**
         * 去除actionBar
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        initView();
    }
    //

    /**
     * 初始化界面
     */
    private void initView()
    {
        Log.e("MainActivity","MainActivity");
        button_bottom_bar_que = (Button) findViewById(R.id.button_bottom_bar_que);
        button_bottom_bar_use = (Button) findViewById(R.id.button_bottom_bar_use);
        button_bottom_bar_commu = (Button) findViewById(R.id.button_bottom_bar_commu);
        button_bottom_bar_mine = (Button) findViewById(R.id.button_bottom_bar_mine);
        bottomBarQueFragment = new BottomBarQueFragment();
        bottomBarUseFragment = new BottomBarUseFragment();
        bottomBarMineFragment = new BottomBarMineFragment();
        bottomBarCommuFragment = new BottomBarCommuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone, bottomBarQueFragment);
        defaultButton();
    }
    //

    /**
     * 设置默认的底栏安按钮
     */
    public void defaultButton()
    {
        button_bottom_bar_que.setSelected(true);
        button_bottom_bar_use.setSelected(false);
        button_bottom_bar_commu.setSelected(false);
        button_bottom_bar_mine.setSelected(false);
        //显示默认的fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone, bottomBarQueFragment).commit();
    }
    //

    /**
     * 切换不同按钮改变selected状态
     * @param view
     */
    public void click_button_bar(View view)
    {
        switch (view.getId()){
            case R.id.button_bottom_bar_que:
                button_bottom_bar_que.setSelected(true);
                button_bottom_bar_use.setSelected(false);
                button_bottom_bar_commu.setSelected(false);
                button_bottom_bar_mine.setSelected(false);
                /**
                 * 改变对应的fragment
                 */
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone, bottomBarQueFragment).commit();
                break;
            case R.id.button_bottom_bar_use:
                button_bottom_bar_que.setSelected(false);
                button_bottom_bar_use.setSelected(true);
                button_bottom_bar_commu.setSelected(false);
                button_bottom_bar_mine.setSelected(false);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone, bottomBarUseFragment).commit();
                break;
            case R.id.button_bottom_bar_commu:
                button_bottom_bar_que.setSelected(false);
                button_bottom_bar_use.setSelected(false);
                button_bottom_bar_commu.setSelected(true);
                button_bottom_bar_mine.setSelected(false);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone, bottomBarCommuFragment).commit();
                break;
            case R.id.button_bottom_bar_mine:
                button_bottom_bar_que.setSelected(false);
                button_bottom_bar_use.setSelected(false);
                button_bottom_bar_commu.setSelected(false);
                button_bottom_bar_mine.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_zone,bottomBarMineFragment).commit();
                break;
        }
    }

}
