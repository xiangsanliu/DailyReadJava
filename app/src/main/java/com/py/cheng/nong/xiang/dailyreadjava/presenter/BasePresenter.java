package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;
import android.widget.Toast;

import com.py.cheng.nong.xiang.dailyreadjava.view.BaseView;

/**
 * Created by xiang on 2018/3/14.
 *
 */

public abstract class BasePresenter <T extends BaseView> {

    protected T view;

    public abstract void onCreate();

    public void attachView(T view) {
        this.view = view;
    }

    public void showToast(Context context, String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
