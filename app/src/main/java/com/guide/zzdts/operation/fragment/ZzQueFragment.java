package com.guide.zzdts.operation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.zzdts.operation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZzQueFragment extends Fragment {

    BottomBarQueFragment bottomBarQueFragment;
    public ZzQueFragment() {

        // Required empty public constructor
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        bottomBarQueFragment = (BottomBarQueFragment) getParentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("ZzQueFragment","ZzQueFragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que_zz, container, false);
    }

}
