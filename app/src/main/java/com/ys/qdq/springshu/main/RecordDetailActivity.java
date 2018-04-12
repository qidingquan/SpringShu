package com.ys.qdq.springshu.main;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseActivity;
import com.ys.qdq.springshu.entity.Record;
import com.ys.qdq.springshu.util.GlideUtil;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/12.
 * 记录详情
 */

public class RecordDetailActivity extends BaseActivity {

    public static final String INTENT_PARAMS_RECORD = "INTENT_PARAMS_RECORD";

    public static Intent goToRecordDetail(Context context, Record record) {
        Intent intent = new Intent(context, RecordDetailActivity.class);
        intent.putExtra(INTENT_PARAMS_RECORD, record);
        return intent;
    }

    @BindView(R.id.iv_photo)
    ImageView ivPhoto;

    private Record record;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_record_detail;
    }

    @Override
    protected void initData() {
        this.record = (Record) getIntent().getSerializableExtra(INTENT_PARAMS_RECORD);
        if (record != null) {
            GlideUtil.getInstance().displayImage(record.getPhoto().getUrl(), ivPhoto);
        }
    }

}
