package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.databinding.ActivityReadBinding;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Article;
import com.py.cheng.nong.xiang.dailyreadjava.presenter.ReadPresenter;
import com.py.cheng.nong.xiang.dailyreadjava.share.CollapsingToolbarLayoutState;
import com.py.cheng.nong.xiang.dailyreadjava.view.ReadView;

public class ReadActivity extends AppCompatActivity implements ReadView {

    private ActivityReadBinding binding;
    private ReadPresenter presenter;
    private CollapsingToolbarLayoutState state = CollapsingToolbarLayoutState.EXPANDED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_read);
        presenter = new ReadPresenter(this);
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    public void initViews() {
        initStatusBar();
        initToolBar();
    }

    /**
     * 设置状态栏的颜色（透明）
     */
    private void initStatusBar() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

    /**
     * 设置ToolBar
     */
    private void initToolBar() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbarLayout.setTitle(" ");
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void loadArticle(Article article) {
        //加载文章并，载入css
        binding.markdownView.loadMarkdown(article.getBody(), "file:///android_asset/style.css");
        Glide.with(this).load(article.getImage()).into(binding.background);
        binding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                //展开状态栏
                if (state != CollapsingToolbarLayoutState.EXPANDED) {
                    state = CollapsingToolbarLayoutState.EXPANDED;
                    binding.toolbarLayout.setTitle(" ");
                    binding.articleTitle.setText(article.getTitle());
                    invalidateOptionsMenu();
                }
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                //折叠状态栏
                binding.toolbarLayout.setTitle(article.getTitle());
                state = CollapsingToolbarLayoutState.COLLAPSED;
                invalidateOptionsMenu();
            } else {
                if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                    binding.toolbarLayout.setTitle(article.getTitle());
                    binding.articleTitle.setText(" ");
                    state = CollapsingToolbarLayoutState.INTERNEDIATE;
                    invalidateOptionsMenu();
                }
            }
        });

        Intent sharingIntent = new Intent().setAction(Intent.ACTION_SEND).setType("text/plain");
        String sharingText = article.getTitle() + '\n' + article.getShare_url();
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sharingText);
        binding.fab.setOnClickListener(v -> startActivity(Intent.createChooser(sharingIntent, article.getTitle())));
        binding.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                default:
                    break;
            }
            return true;
        });
    }
}
