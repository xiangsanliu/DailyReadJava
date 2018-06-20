package com.py.cheng.nong.xiang.dailyreadjava.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.databinding.ActivityReadBinding;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Article;
import com.py.cheng.nong.xiang.dailyreadjava.presenter.ReadPresenter;
import com.py.cheng.nong.xiang.dailyreadjava.share.CollapsingToolbarLayoutState;
import com.py.cheng.nong.xiang.dailyreadjava.share.SharedConstants;
import com.py.cheng.nong.xiang.dailyreadjava.view.ReadView;

/**
 * @author xiang
 */

public class ReadActivity extends BaseActivity<ActivityReadBinding> implements ReadView {

    private ReadPresenter presenter;

    private CollapsingToolbarLayoutState state = CollapsingToolbarLayoutState.EXPANDED;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadArticle(Article article) {
        //加载文章并，载入css
        binding.markdownView.loadMarkdown(article.getBody(), "file:///android_asset/style.css");
        Glide.with(this).load(article.getImage()).into(binding.background);
        binding.articleTitle.setText(article.getTitle());
        binding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                //展开状态栏
                if (state != CollapsingToolbarLayoutState.EXPANDED) {
                    state = CollapsingToolbarLayoutState.EXPANDED;
                    binding.toolbarLayout.setTitle(" ");
                    binding.articleTitle.setText(article.getTitle());
                }
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                //折叠状态栏
                binding.toolbarLayout.setTitle(article.getTitle());
                state = CollapsingToolbarLayoutState.COLLAPSED;
            } else {
                if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                    binding.toolbarLayout.setTitle(article.getTitle());
                    binding.articleTitle.setText(" ");
                    state = CollapsingToolbarLayoutState.INTERNEDIATE;
                }
            }
        });
        binding.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_share:
                    share(article);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_read, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_share).setVisible(state == CollapsingToolbarLayoutState.EXPANDED);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_read;
    }

    @Override
    protected void initViews() {
        initStatusBar();
        initToolBar();
    }

    @Override
    protected void initData() {
        presenter.loadArticle(getIntent().getStringExtra(SharedConstants.ARTICLE_ID_KEY));
    }

    @Override
    protected void initPresenter() {
        presenter = new ReadPresenter(this);
        presenter.attachView(this);
    }

    private void share(Article article) {
        Intent sharingIntent = new Intent().setAction(Intent.ACTION_SEND).setType("text/plain");
        String sharingText = article.getTitle() + '\n' + article.getShareUrl();
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sharingText);
        startActivity(Intent.createChooser(sharingIntent, article.getTitle()));
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

}
