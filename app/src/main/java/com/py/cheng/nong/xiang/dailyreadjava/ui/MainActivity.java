package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.databinding.ActivityMainBinding;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.presenter.MainPresenter;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainView {

    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initViews() {
        binding.storyList.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public void initData() {
        presenter.loadStoryList();
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    public void loadStoryList(StoryAdapter storyAdapter) {
        binding.storyList.setAdapter(storyAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
