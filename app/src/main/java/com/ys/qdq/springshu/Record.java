package com.ys.qdq.springshu;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Company Name:成都够用云科技有限公司
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
