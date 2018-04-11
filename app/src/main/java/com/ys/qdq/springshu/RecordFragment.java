package com.ys.qdq.springshu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Company Name:成都够用云科技有限公司
 * Author:qdq
 * Discription:记录fragment
 * Date: 2016/9/6
 */
public class RecordFragment extends Fragment {
    @ViewInject(R.id.record_iv)
    private ImageView record_iv;
    @ViewInject(R.id.baseView)
    private BaseView baseView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_record,null);
        x.view().inject(this,view);
        baseView.setState(BaseView.LOADING,-1);
        return view;
    }
    public void updateData(Record record){
        if(record.getPhoto()!=null){
            x.image().bind(record_iv,record.getPhoto().getUrl());
            baseView.setState(BaseView.NOMAL,-1);
        }else{
            baseView.setState("没有牛奶",R.mipmap.fail);
        }
    }
}
