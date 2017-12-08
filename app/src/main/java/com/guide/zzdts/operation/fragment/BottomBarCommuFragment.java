package com.guide.zzdts.operation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.zzdts.operation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomBarCommuFragment extends Fragment {


    public BottomBarCommuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_bar_commu, container, false);
    }

}
