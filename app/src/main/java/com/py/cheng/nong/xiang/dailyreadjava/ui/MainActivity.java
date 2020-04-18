package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.databinding.ActivityMainBinding;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.presenter.MainPresenter;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

/**
 * @author xiang
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainView {

    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadStoryList(StoryAdapter storyAdapter) {
        binding.storyList.setAdapter(storyAdapter);
        storyAdapter.setOnLoadMoreListener(() -> presenter.loadMoreStory(storyAdapter), binding.storyList);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        binding.storyList.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(binding.toolbar);
    }

    @Override
    protected void initData() {
        presenter.loadStoryList();
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.attachView(this);
    }

}
