package com.ys.qdq.springshu;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Company Name:成都够用云科技有限公司
 * Author:qdq
 * Discription:用户信息
 * Date: 2016/9/5
 */
public class User extends BmobUser{
    private BmobFile head;

    public BmobFile getHead() {
        return head;
    }

    public void setHead(BmobFile head) {
        this.head = head;
    }
}
