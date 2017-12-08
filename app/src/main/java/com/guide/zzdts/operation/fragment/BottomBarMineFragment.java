package com.guide.zzdts.operation.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guide.zzdts.operation.activity.MainActivity;
import com.guide.zzdts.operation.R;
import com.guide.zzdts.operation.activity.MapActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomBarMineFragment extends Fragment {

    private MainActivity mainActivity;
    private TextView textView_map;
    View view;
    public BottomBarMineFragment() {
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
        view = inflater.inflate(R.layout.fragment_bottom_bar_mine, container, false);
        textView_map = (TextView) view.findViewById(R.id.textView_map);
        textView_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);
                startActivity(intent);
                Log.e("BottomBarMineFragment","执行");
            }
        });
        return view;
    }
}
