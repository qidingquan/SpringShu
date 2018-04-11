package com.ys.qdq.springshu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    private EditText user_et;
    private EditText pass_et;
    private Button register_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initListener();
    }

    private void initView(){
        user_et= (EditText) findViewById(R.id.user_et);
        pass_et= (EditText) findViewById(R.id.pass_et);
        register_bt= (Button) findViewById(R.id.register_bt);
    }
    private void initListener() {
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestServer();
            }
        });
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
