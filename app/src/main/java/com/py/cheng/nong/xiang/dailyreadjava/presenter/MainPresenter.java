package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Date;
import com.py.cheng.nong.xiang.dailyreadjava.share.ShareConsts;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiang on 2018/3/14.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {
        loadStoryList();
    }

    private void loadStoryList() {
        new AsyncHttpClient().get(ShareConsts.MAIN_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Date date = JSON.parseObject(new String(responseBody), Date.class);
                StoryAdapter adapter = new StoryAdapter(date.getStories());
                view.loadStoryList(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showToast(context, error.getMessage());
            }
        });
    }
}
