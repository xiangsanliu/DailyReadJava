package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.py.cheng.nong.xiang.dailyreadjava.model.HttpClient;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Date;
import com.py.cheng.nong.xiang.dailyreadjava.share.SharedConstants;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

import cz.msebera.android.httpclient.Header;

/**
 * @author xiang
 * @date 2018/3/14
 */

public class MainPresenter extends BasePresenter<MainView> {

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    public void loadStoryList() {
        HttpClient.simpleGet(SharedConstants.MAIN_URL, new HttpClient.CallBack() {
            @Override
            public void onSuccess(String data) {
                Date date = JSON.parseObject(data, Date.class);
                StoryAdapter adapter = new StoryAdapter(date.getStories());
                view.loadStoryList(adapter);
            }

            @Override
            public void onFailure(String msg) {
                showToast(context, msg);
            }
        });
    }
}
