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
public class TscQueFragment extends Fragment {

    private BottomBarQueFragment bottomBarQueFragment;
    public TscQueFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que_tsc, container, false);
    }

}
