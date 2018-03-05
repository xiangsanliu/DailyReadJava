package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

import java.util.List;

/**
 * Created by xiang on 2018/3/5.
 *
 */

class Story {

    private List<String> images;
    private int type;
    private String id;
    private String ga_prefix;
    private String title;

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

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Story() {

    }
}
