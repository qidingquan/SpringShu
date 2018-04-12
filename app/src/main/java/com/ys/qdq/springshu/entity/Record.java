package com.ys.qdq.springshu.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Author:qdq
 * Discription:生活记录
 * Date: 2016/9/5
 */
public class Record extends BmobObject{

    private BmobFile photo;

    public BmobFile getPhoto() {
        return photo;
    }

    public void setPhoto(BmobFile photo) {
        this.photo = photo;
    }

}
