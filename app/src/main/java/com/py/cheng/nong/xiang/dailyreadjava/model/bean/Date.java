package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

import java.util.List;

/**
 * Created by xiang on 2018/3/5.
 *
 */

public class Date {
    private String date;
    private List<Story> stories;
    private List<TopStory> topStories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<TopStory> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<TopStory> topStories) {
        this.topStories = topStories;
    }

    public Date() {

    }
}
