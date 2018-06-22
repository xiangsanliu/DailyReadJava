package com.py.cheng.nong.xiang.dailyreadjava.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * @author xiang
 */
public class HttpClient {

    public static void simpleGet(String url, CallBack callBack) {
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                callBack.onSuccess(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callBack.onFailure(error.getMessage());
            }
        });
    }

    public interface CallBack {
        /**
         * 成功回调
         *
         * @param data data
         */
        void onSuccess(String data);

        /**
         * 失败回调
         *
         * @param msg 错误信息
         */
        void onFailure(String msg);
    }

}
