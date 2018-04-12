package com.ys.qdq.springshu.login;

import android.content.Intent;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseActivity;
import com.ys.qdq.springshu.config.Constants;
import com.ys.qdq.springshu.main.MainActivity;
import com.ys.qdq.springshu.util.AppManager;
import com.ys.qdq.springshu.util.SPUtils;

/**
 * Created by Administrator on 2018/4/12.
 * 欢迎页
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {
        boolean isFirstLogin= (boolean) SPUtils.get(mContext, Constants.LOGIN_STATE_KEY,true);
        if(isFirstLogin){
            startActivity(new Intent(mContext,LoginActivity.class));
        }else {
            startActivity(new Intent(mContext,MainActivity.class));
        }
        finish();
    }
}
