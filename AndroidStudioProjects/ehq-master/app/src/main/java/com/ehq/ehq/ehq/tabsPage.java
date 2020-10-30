package com.ehq.ehq.ehq;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ehq.ehq.ehq.fragments.comedy;
import com.ehq.ehq.ehq.fragments.dance;
import com.ehq.ehq.ehq.fragments.home;
import com.ehq.ehq.ehq.fragments.music;
import com.ehq.ehq.ehq.fragments.originals;
import com.ehq.ehq.ehq.fragments.reality;
import com.ehq.ehq.ehq.fragments.social;
import com.ehq.ehq.ehq.fragments.story;


public class tabsPage extends FragmentStatePagerAdapter {


    String[] titles ={"HOME","ORIGINALS","SOCIAL","COMEDY","MOVIE","REALITY","DANCE","MUSIC","STORY"};

    public tabsPage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:{
                fragment = new home();
                break;
            }case 1:{
                fragment = new originals();
                break;
            }case 2:{
                fragment = new social();
                break;
            }case 3:{
                fragment = new comedy();
                break;
            }case 4:{
                fragment = new reality();
                break;
            }case 5:{
                fragment = new dance();

                break;
            }case 6:{
                fragment = new music();
                break;
            }case 7 :{
                fragment= new story();
            }
        }
        return fragment;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return 8;
    }
}
