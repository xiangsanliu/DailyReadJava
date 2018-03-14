package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.view.ReadView;

public class ReadActivity extends AppCompatActivity implements ReadView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
    }

    @Override
    public void initViews() {

    }
}
