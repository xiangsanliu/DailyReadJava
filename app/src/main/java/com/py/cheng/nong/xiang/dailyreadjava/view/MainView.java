package com.py.cheng.nong.xiang.dailyreadjava.view;

import com.py.cheng.nong.xiang.dailyreadjava.model.adapter.StoryAdapter;

/**
 * @author xiang
 * @date 2018/3/14
 */

public interface MainView extends BaseView {

    /**
     * 获取消息列表
     *
     * @param storyAdapter adapter
     */
    void loadStoryList(StoryAdapter storyAdapter);

}
