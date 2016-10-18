package com.example.administrator.readingapp.ui.fragment.book;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.readingapp.R;
import com.example.administrator.readingapp.ui.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/18.
 */
public class BookFragment extends BaseFragment {
    @Bind(R.id.m_book_tablayout)
    TabLayout mBookTablayout;
    @Bind(R.id.m_book_viewpager)
    ViewPager mBookViewpager;

    @Override
    protected void init() {
        String[] array = getResources().getStringArray(R.array.book_title);
        List<String> titleList = Arrays.asList(array);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Book1Fragment());
        fragments.add(new Book2Fragment());
       // FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentManager manager = getChildFragmentManager();
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(manager, fragments, titleList);
        mBookViewpager.setAdapter(adapter);
        mBookTablayout.setupWithViewPager(mBookViewpager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }

    /**
     * ViewPager的适配器
     */
    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> mFragments;
        private List<String> mTitle;

        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> title) {
            super(fm);
            this.mFragments = fragments;
            this.mTitle = title;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position % mTitle.size());
        }
    }

}
