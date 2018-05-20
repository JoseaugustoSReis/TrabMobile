package com.example.mrlopito.grupella.view.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by Gian Fonseca on 05/15/2018.
 */
public interface FragmentNavigatorAdapter {

    public Fragment onCreateFragment(int position);

    public String getTag(int position);

    public int getCount();
}
