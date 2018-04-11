package com.ys.qdq.springshu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText user_et;
    private EditText pass_et;
    private Button register_bt;
    private Button login_bt;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initView(){
        user_et= (EditText) findViewById(R.id.user_et);
        pass_et= (EditText) findViewById(R.id.pass_et);
        register_bt= (Button) findViewById(R.id.register_bt);
        login_bt= (Button) findViewById(R.id.login_bt);
    }
    private void initListener() {
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestServer();
            }
        });
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
    private void requestServer() {
        String username=user_et.getText().toString().trim();
        String password=pass_et.getText().toString().trim();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this,"用户名或密码不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this,"登录失败！"+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
