package com.example.mvpchouqu.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> frag;
    private String[] names;

    public VPAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> frag, String[] names) {
        super(fm);
        this.frag = frag;
        this.names = names;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frag.get(position);
    }

    @Override
    public int getCount() {
        return frag.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
