package com.ys.qdq.springshu.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseActivity;
import com.ys.qdq.springshu.entity.User;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.user_et)
     EditText user_et;
    @BindView(R.id.pass_et)
     EditText pass_et;

    @OnClick({R.id.register_bt})
    public void click(View view){
        switch (view.getId()){
            case R.id.register_bt:
                requestServer();
                break;
        }
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {

    }

    private void requestServer() {
        String username=user_et.getText().toString().trim();
        String password=pass_et.getText().toString().trim();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this,"用户名或密码不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegisterActivity.this,"注册失败！"+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
