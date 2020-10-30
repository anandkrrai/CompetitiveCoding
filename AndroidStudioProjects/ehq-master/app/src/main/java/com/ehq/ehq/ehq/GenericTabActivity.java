package com.ehq.ehq.ehq;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ehq.ehq.ehq.fragments.comedy;
import com.ehq.ehq.ehq.fragments.dance;
import com.ehq.ehq.ehq.fragments.music;
import com.ehq.ehq.ehq.fragments.originals;
import com.ehq.ehq.ehq.fragments.reality;
import com.ehq.ehq.ehq.fragments.social;
import com.ehq.ehq.ehq.fragments.story;

public class GenericTabActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    public String title="";
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_tab);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        final Bundle bundle = getIntent().getExtras();
        title=bundle.getString("title");


        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        tab.setText(title);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_generic_tab, menu);
        return true;
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_generic_tab, container, false);
            TextView textView =  rootView.findViewById(R.id.section_label);

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
                if(title.equals("originals")){
                    return new originals();
                }else if(title.equals("comedy")){
                    return new comedy();
                }else if(title.equals("social")){
                    return new social();
                }else if(title.equals("reality")){
                    return new reality();
                }else if(title.equals("dance")){
                    return new dance();
                }else if(title.equals("music")){
                    return new music();
                }else if(title.equals("story")){
                    return new story();
                }

            return new comedy();
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
