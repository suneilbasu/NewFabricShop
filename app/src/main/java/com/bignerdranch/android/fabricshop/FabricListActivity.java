package com.bignerdranch.android.fabricshop;

import android.support.v4.app.Fragment;

public class FabricListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FabricListFragment();
    }
}
