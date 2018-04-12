package com.ys.qdq.springshu.util;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.ys.qdq.springshu.R;
import com.ys.qdq.springshu.base.BaseApplication;

/**
 * Created by Administrator on 2017/11/22.
 */

public class ToastUtil {

    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void show(String info) {
        TextView view = new TextView(BaseApplication.instance);
        view.setBackgroundResource(R.drawable.bg_toast);
        view.setGravity(Gravity.CENTER);
        view.setTextColor(Color.WHITE);
        view.setText(info);

        if (toast == null) {
            toast = new Toast(BaseApplication.instance);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(view);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (info.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = info;
                toast.setView(view);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

}
