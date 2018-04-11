package com.ys.qdq.springshu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created on 2016/8/12.
 * Author：qdq
 * Description:状态View
 */
public class BaseView extends FrameLayout {


    public static final String NOMAL="NOMAL";//正常状态
    public static final String LOADING="LOADING";//正在加载
    private LinearLayout notice_layout;//点击提示重新加载
    private ImageView noticeIv;//提示图片
    private TextView noticeTv;//提示文字
    private ProgressBar progressBar;
    private OverLoadListener loadListener;
    private Context context;
    public void setOverLoadListener(OverLoadListener loadListener){
        this.loadListener=loadListener;
    }
    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }


    /**
     * 自定义BaseView采用FrameLayout
     * 最后添加状态View保证它在所有View的顶层
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.loading_state,this);
        initView(view);
        initListener();
    }
    private void initView(View view) {
        notice_layout= (LinearLayout) view.findViewById(R.id.notice_layout);
        noticeIv= (ImageView) view.findViewById(R.id.noticeIv);
        noticeTv= (TextView) view.findViewById(R.id.noticeTv);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar);
    }
    private void initListener() {
        //设置点击重载监听
        notice_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loadListener!=null){
                    loadListener.overLoad();
                }
            }
        });
    }


    /**
     * 动态修改状态显示
     * @param state
     *  1.NOMAL正常状态，不显示状态View
     *  2.LOADING加载数据状态，显示加载
     *  3.其他情况，state表示要显示的提示文字描述
     * @param resId
     *  表示要显示的图片资源id,为-1时显示图片
     */
    public void setState(String state, int resId){
        if(NOMAL.equals(state)){//正常获取数据
            notice_layout.setVisibility(GONE);
            progressBar.setVisibility(GONE);
        }else if(LOADING.equals(state)){//正在加载数据
            notice_layout.setVisibility(GONE);
            progressBar.setVisibility(VISIBLE);
        }else {//其他情况提示
            progressBar.setVisibility(GONE);
            notice_layout.setVisibility(VISIBLE);
            noticeTv.setText(state);
            if(resId!=-1){//有图片提示
                noticeIv.setImageResource(resId);
            }
        }
    }


    /**
     * 重新加载监听
     */
    public interface OverLoadListener{
        void overLoad();
    }
}
