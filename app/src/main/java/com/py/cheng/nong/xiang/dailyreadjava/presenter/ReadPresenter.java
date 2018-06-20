package com.py.cheng.nong.xiang.dailyreadjava.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
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
        new AsyncHttpClient().get(SharedConstants.ARTICLE_URL + id, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Article article = JSON.parseObject(new String(responseBody), Article.class);
                view.loadArticle(article);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showToast(context, error.getMessage());
            }
        });
    }


}
