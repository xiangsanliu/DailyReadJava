package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.py.cheng.nong.xiang.dailyreadjava.view.BaseView;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements BaseView {

    T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initPresenter();
        initViews();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initPresenter();

}
