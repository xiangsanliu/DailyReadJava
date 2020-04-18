package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.py.cheng.nong.xiang.dailyreadjava.model.HttpClient;
import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.StoryDate;
import com.py.cheng.nong.xiang.dailyreadjava.share.SharedConstants;
import com.py.cheng.nong.xiang.dailyreadjava.view.MainView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author xiang
 * @date 2018/3/14
 */

public class MainPresenter extends BasePresenter<MainView> {

    private Context context;

    private Date date;

    private DateFormat format;

    public MainPresenter(Context context) {
        this.context = context;
        this.date = new Date();
        this.format = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    }

    public void loadStoryList() {
        HttpClient.simpleGet(SharedConstants.MAIN_URL, new HttpClient.CallBack() {
            @Override
            public void onSuccess(String data) {
                StoryDate storyDate = JSON.parseObject(data, StoryDate.class);
                StoryAdapter adapter = new StoryAdapter(storyDate.getStories());
                view.loadStoryList(adapter);
            }

            @Override
            public void onFailure(String msg) {
                showToast(context, msg);
            }
        });
    }

    public void loadMoreStory(StoryAdapter adapter) {
        HttpClient.simpleGet(SharedConstants.BASE_URL + calculateDate(), new HttpClient.CallBack() {
            @Override
            public void onSuccess(String data) {
                StoryDate storyDate = JSON.parseObject(data, StoryDate.class);
                adapter.addData(storyDate.getStories());
                adapter.loadMoreComplete();
            }

            @Override
            public void onFailure(String msg) {
                showToast(context, msg);
                adapter.loadMoreFail();
            }
        });
    }

    /**
     * 计算“当前日期”的前一天
     *
     * @return 前一天
     */
    private String calculateDate() {
        this.date = new Date(this.date.getTime() - SharedConstants.MILLIS_ONE_DAY);
        return format.format(this.date);
    }

}
