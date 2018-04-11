package com.ys.qdq.springshu;

import android.app.Application;

import org.xutils.x;

import cn.bmob.v3.Bmob;

/**
 * Company Name:成都够用云科技有限公司
 * Author:qdq
 * Discription:初始化bmob
 * Date: 2016/9/5
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true);
        //默认初始化
        Bmob.initialize(this,"64ee73e1658cdcc560b9560d8806db02");
        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
    }
}
