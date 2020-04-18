package com.py.cheng.nong.xiang.dailyreadjava.ui;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author xiang
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initPresenter();
        initViews();
        initData();
    }

    /**
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * getLayout
     *
     * @return layout
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化presenter
     */
    protected abstract void initPresenter();

}
