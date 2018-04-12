package com.ys.qdq.springshu.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by qdq on 2018/1/10.
 * recyclerview适配器基类
 */

public abstract class BaseRecyclerAdapter<E> extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int NOMARL_TYPE = 0;//正常
    private static final int HEEAD_TYPE = 1;//头部
    private static final int FOOT_TYPE = 2;//底部

    private List<E> mDataList;//数据
    private Context mContext;
    private int layoutResId;//布局资源id
    private View headView;//头部view
    private View footView;//底部view

    public BaseRecyclerAdapter(Context mContext, int layoutResId, List<E> dataList) {
        this.mDataList = dataList;
        this.layoutResId = layoutResId;
        this.mContext = mContext;
    }

    /**
     * 更新数据
     *
     * @param mDataList
     */
    public void updateData(List<E> mDataList) {
        this.mDataList = mDataList;
        notifyDataSetChanged();
    }

    /**
     * 添加头部
     *
     * @param headView
     */
    public void addHeadView(View headView) {
        this.headView = headView;
        notifyDataSetChanged();
    }

    /**
     * 添加底部
     *
     * @param footView
     */
    public void addFootView(View footView) {
        this.footView = footView;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("onCreateViewHolder", "onCreateViewHolder");
        View view = null;
        switch (viewType) {
            case HEEAD_TYPE:
                view = headView;
                break;
            case FOOT_TYPE:
                view = footView;
                break;
            default:
                view = LayoutInflater.from(mContext).inflate(layoutResId, parent, false);
                break;
        }
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Log.e("onBindViewHolder", "onBindViewHolder");
        switch (getItemViewType(position)) {
            case HEEAD_TYPE:
                break;
            case FOOT_TYPE:
                break;
            default:
                holder.itemView.setOnClickListener(v -> {
                    if (itemListener != null) {
                        itemListener.onItemClick(holder, getItemPosition(position));
                    }
                });
                bindData(holder, mDataList.get(getItemPosition(position)), getItemPosition(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("getItemViewType", "getItemViewType");
        int viewType = NOMARL_TYPE;
        if (headView != null) {
            if (position == 0) {
                viewType = HEEAD_TYPE;
            }
        }
        if (footView != null) {
            if (position == getItemCount() - 1) {
                viewType = FOOT_TYPE;
            }
        }

        return viewType;
    }

    private int getItemPosition(int position) {
        if (headView != null) {
            position--;
        }
        return position;
    }

    protected abstract void bindData(BaseViewHolder holder, E data, int position);

    @Override
    public int getItemCount() {
        int itemCount = mDataList != null ? mDataList.size() : 0;
        if (headView != null) {
            itemCount = itemCount + 1;
        }
        if (footView != null) {
            itemCount = itemCount + 1;
        }
        return itemCount;
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public interface ItemListener {
        void onItemClick(BaseViewHolder holder, int position);
    }
}
