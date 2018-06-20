package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;
import android.widget.Toast;

import com.py.cheng.nong.xiang.dailyreadjava.view.BaseView;

/**
 * @author xiang
 * @date 2018/3/14
 */

public abstract class BasePresenter<T extends BaseView> {

    protected T view;

    public void attachView(T view) {
        this.view = view;
    }

    void showToast(Context context, String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
