package com.py.cheng.nong.xiang.dailyreadjava.view;

import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Article;

/**
 * @author xiang
 * @date 2018/3/14
 */

public interface ReadView extends BaseView {

    /**
     * 文章内容加载入控件
     *
     * @param article article
     * @see Article
     */
    void loadArticle(Article article);
}
