package com.example.mrlopito.grupella.view.adapter;

import android.support.v4.app.Fragment;

import com.example.mrlopito.grupella.view.fragment.FragmentPrimary;
import com.example.mrlopito.grupella.view.fragment.FragmentSecond;
import com.example.mrlopito.grupella.view.fragment.MainFragment;

/**
 * Created by Gian Fonseca on 05/15/2018.
 */
public class FragmentAdapter implements FragmentNavigatorAdapter {

    private static final String TABS[] = {"Descrição", "Localização", "Dados"};

    @Override
    public Fragment onCreateFragment(int position) {
        switch (position) {
            case 1:
                return FragmentPrimary.newInstance(position);

            case 2:
                return FragmentSecond.newInstance(position);

            default:
                return MainFragment.newInstance(TABS[position]);

        }
    }

    @Override
    public String getTag(int position) {
        if (position == 1) {
            return FragmentPrimary.TAG;
        }
        return MainFragment.TAG + TABS[position];
    }

    @Override
    public int getCount() {
        return TABS.length;
    }
}
