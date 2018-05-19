package com.py.cheng.nong.xiang.dailyreadjava.view;

import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Article;

/**
 * Created by xiang on 2018/3/14.
 */

public interface ReadView extends BaseView {
    void loadArticle(Article article);
}
