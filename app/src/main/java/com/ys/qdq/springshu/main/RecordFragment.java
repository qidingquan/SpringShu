package com.ys.qdq.springshu.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseFragment;
import com.ys.qdq.springshu.entity.Record;
import com.ys.qdq.springshu.main.adapter.RecordAdapter;

import java.util.List;
import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Author:qdq
 * Discription:记录fragment
 * Date: 2016/9/6
 */
public class RecordFragment extends BaseFragment {

    @BindView(R.id.recycler_record)
    RecyclerView recyclerRecord;

    private List<Record> recordList;
    private RecordAdapter recordAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_record;
    }

    @Override
    protected void initData() {


        recyclerRecord.setLayoutManager(new LinearLayoutManager(getActivity()));
        recordAdapter=new RecordAdapter(getContext(),R.layout.item_record,recordList);
        recyclerRecord.setAdapter(recordAdapter);

        recordAdapter.setItemListener((holder, position) -> startActivity(RecordDetailActivity.goToRecordDetail(getActivity(),recordList.get(position))));

    }
    /**
     * 获取生活记录
     */
    private void getRecord(Context context) {
        BmobQuery<Record> query = new BmobQuery<>();
        query.findObjects(context, new FindListener<Record>() {
            @Override
            public void onSuccess(List<Record> list) {

            }

            @Override
            public void onError(int code, String error) {
            }
        });
    }

}
