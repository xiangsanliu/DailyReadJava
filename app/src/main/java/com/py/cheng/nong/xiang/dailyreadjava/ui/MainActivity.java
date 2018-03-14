package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.databinding.ActivityMainBinding;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.presenter.MainPresenter;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new MainPresenter(this);
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadStoryList(StoryAdapter storyAdapter) {

    }
}
