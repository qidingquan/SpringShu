package com.ys.qdq.springshu.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseActivity;
import com.ys.qdq.springshu.config.Constants;
import com.ys.qdq.springshu.entity.User;
import com.ys.qdq.springshu.main.MainActivity;
import com.ys.qdq.springshu.util.ProgressDialogUtil;
import com.ys.qdq.springshu.util.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.user_et)
    EditText user_et;
    @BindView(R.id.pass_et)
    EditText pass_et;

    @OnClick({R.id.login_bt, R.id.register_bt})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                requestServer();
                break;
            case R.id.register_bt:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    private void requestServer() {
        String username = user_et.getText().toString().trim();
        String password = pass_et.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.login(this, new SaveListener() {
            @Override
            public void onStart() {
                super.onStart();
                ProgressDialogUtil.showDialog(mContext);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                ProgressDialogUtil.cancelDialog();
            }

            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                SPUtils.put(mContext, Constants.LOGIN_STATE_KEY, false);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "登录失败！" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
