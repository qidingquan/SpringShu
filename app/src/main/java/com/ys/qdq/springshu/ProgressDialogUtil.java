package com.ys.qdq.springshu;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created on 2016/7/28.
 * Author：qdq
 * Description:加载对话框
 */
public class ProgressDialogUtil {

    private static ProgressDialog progressDialog;

    public static void showDialog(Context context){
        if(progressDialog == null){
            progressDialog=new ProgressDialog(context);
            progressDialog.setMessage("正在加载");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }
    public static void cancelDialog(){
        if(progressDialog != null){
            progressDialog.cancel();
            progressDialog=null;
        }
    }
}
