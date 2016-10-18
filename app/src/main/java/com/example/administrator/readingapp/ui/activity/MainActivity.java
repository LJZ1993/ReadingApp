package com.example.administrator.readingapp.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.administrator.readingapp.R;
import com.example.administrator.readingapp.ui.BaseActivity;
import com.example.administrator.readingapp.ui.fragment.book.BookFragment;
import com.example.administrator.readingapp.ui.fragment.FilmFragment;
import com.example.administrator.readingapp.ui.fragment.MusicFragemnt;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.m_main_toobar)
    Toolbar mMainToobar;
    @Bind(R.id.m_main_framelayout)
    FrameLayout mMainFramelayout;
    @Bind(R.id.m_main_navi)
    NavigationView mMainNavi;
    @Bind(R.id.m_main_drawerlayout)
    DrawerLayout mMainDrawerlayout;

    @Override
    protected void init() {
        setSupportActionBar(mMainToobar);
        //toolbar和NavigatorLayout进行绑定
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mMainDrawerlayout, mMainToobar, R.string.open, R.string.close);
        toggle.syncState();
        mMainDrawerlayout.setDrawerListener(toggle);
        mMainNavi.setNavigationItemSelectedListener(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navi_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.m_main_framelayout, new BookFragment()).commit();
                mMainToobar.setTitle("BookFragment");
                break;
            case R.id.navi_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.m_main_framelayout, new MusicFragemnt()).commit();
                mMainToobar.setTitle("MusicFragment");
                break;
            case R.id.navi_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.m_main_framelayout, new FilmFragment()).commit();
                mMainToobar.setTitle("FilmFragment");
                break;
        }
        item.setCheckable(true);
        //记得关闭抽屉
        mMainDrawerlayout.closeDrawers();
        return true;
    }
}
