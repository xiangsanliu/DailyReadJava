package com.py.cheng.nong.xiang.dailyreadjava.view;

import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;

/**
 * Created by xiang on 2018/3/14.
 * 
 */

public interface MainView extends BaseView {
    void loadStoryList(StoryAdapter storyAdapter);
}
