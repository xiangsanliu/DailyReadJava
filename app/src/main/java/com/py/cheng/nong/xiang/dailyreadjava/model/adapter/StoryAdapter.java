package com.py.cheng.nong.xiang.dailyreadjava.model.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.py.cheng.nong.xiang.dailyreadjava.R;
import com.py.cheng.nong.xiang.dailyreadjava.model.bean.Story;
import com.py.cheng.nong.xiang.dailyreadjava.share.SharedConstants;
import com.py.cheng.nong.xiang.dailyreadjava.ui.ReadActivity;

import java.util.List;

/**
 * @author xiang
 * @date 2018/3/5
 */

public class StoryAdapter extends BaseQuickAdapter<Story, BaseViewHolder> {


    public StoryAdapter(@Nullable List<Story> data) {
        super(R.layout.item_story, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final Story item) {
        Glide.with(mContext).load(item.getImages().get(0)).into((ImageView) holder.getView(R.id.image));
        holder.setText(R.id.story_title, item.getTitle());
        holder.getView(R.id.card_view).setOnClickListener(view -> {
            Intent intent = new Intent(mContext, ReadActivity.class);
            intent.putExtra(SharedConstants.ARTICLE_ID_KEY, item.getId());
            mContext.startActivity(intent);
        });
    }
}
