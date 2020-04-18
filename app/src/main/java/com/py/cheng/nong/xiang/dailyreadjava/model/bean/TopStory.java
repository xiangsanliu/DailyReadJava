package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author xiang
 * @date 2018/3/5
 */

class TopStory {

    private List<String> images;

    private int type;

    private String id;

    @JSONField(name = "ga_prefix")
    private String gaPrefix;

    private String title;

    public TopStory() {
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
