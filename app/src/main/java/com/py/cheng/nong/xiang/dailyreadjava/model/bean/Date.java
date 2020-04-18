package com.py.cheng.nong.xiang.dailyreadjava.model.bean;

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
public class Date {

    private String date;

    private List<Story> stories;

    private List<TopStory> topStories;

}
