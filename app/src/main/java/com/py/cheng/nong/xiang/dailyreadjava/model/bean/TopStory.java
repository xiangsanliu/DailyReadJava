package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

import com.alibaba.fastjson.annotation.JSONField;

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
class TopStory {

    private List<String> images;

    private int type;

    private String id;

    @JSONField(name = "ga_prefix")
    private String gaPrefix;

    private String title;

}
