package com.ys.qdq.springshu.main.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseRecyclerAdapter;
import com.ys.qdq.springshu.base.BaseViewHolder;
import com.ys.qdq.springshu.entity.Record;
import com.ys.qdq.springshu.util.GlideUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */

public class RecordAdapter extends BaseRecyclerAdapter<Record> {

    public RecordAdapter(Context mContext, int layoutResId, List<Record> dataList) {
        super(mContext, layoutResId, dataList);
    }

    @Override
    protected void bindData(BaseViewHolder holder, Record data, int position) {
        ImageView record_iv = holder.getView(R.id.record_iv);
        GlideUtil.getInstance().displayImage(data.getPhoto().getUrl(), record_iv);
    }
}
