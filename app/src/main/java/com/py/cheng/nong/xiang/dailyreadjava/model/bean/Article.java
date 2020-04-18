package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author xiang
 * @date 2018/3/5
 */

@Getter
@Setter
@NoArgsConstructor
public class Article implements Serializable {

    private String body;

    @JSONField(name = "image_source")
    private String imageSource;

    private String title;

    private String image;

    @JSONField(name = "share_url")
    private String shareUrl;

    private String js;

    @JSONField(name = "ga_prefix")
    private String gaPrefix;

    private List<String> images;

    private int type;

    private String id;

    private List<String> css;

}
