package com.ys.qdq.springshu.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/1/10.
 * RecyclerView ViewHolder
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 通过view id获取指定view实例
     *
     * @param viewId 控件id
     * @param <T>    控件实体
     * @return
     */
    public <T extends View> T getView(int viewId) {
        return itemView.findViewById(viewId);
    }
}
