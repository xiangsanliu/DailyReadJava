package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.py.cheng.nong.xiang.dailyreadjava.model.HttpClient;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Article;
import com.py.cheng.nong.xiang.dailyreadjava.share.SharedConstants;
import com.py.cheng.nong.xiang.dailyreadjava.view.ReadView;

import cz.msebera.android.httpclient.Header;

/**
 * @author xiang
 * @date 2018/3/14
 */

public class ReadPresenter extends BasePresenter<ReadView> {

    private Context context;

    public ReadPresenter(Context context) {
        this.context = context;
    }

    /**
     * 加载文章
     *
     * @param id 文章的id
     */
    public void loadArticle(String id) {
        HttpClient.simpleGet(SharedConstants.ARTICLE_URL + id, new HttpClient.CallBack() {
            @Override
            public void onSuccess(String data) {
                Article article = JSON.parseObject(data, Article.class);
                view.loadArticle(article);
            }

            @Override
            public void onFailure(String msg) {
                showToast(context, msg);
            }
        });
    }


}
