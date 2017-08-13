package com.eryuzhisen.android.model;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.MessageFragmentContract;
import com.eryuzhisen.android.model.entity.SetItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class MessageFragmentModel implements MessageFragmentContract.Model {
    private SetItemEntity commentItem;
    private SetItemEntity msgItem;


    @Override
    public List getData() {


        List data = new ArrayList();

        if (commentItem == null) {
            commentItem = new SetItemEntity();
            commentItem.setIconResId(R.mipmap.icon_comment);
            commentItem.setBgResId(R.drawable.shape_bg3_corner_up);
            commentItem.setTitleResId(R.string.comment);
            commentItem.setMsgNum(0);
            commentItem.setShowline(true);
            commentItem.setType(SetItemEntity.TypeNum);
        }

        if (msgItem == null) {
            msgItem = new SetItemEntity();
            msgItem.setIconResId(R.mipmap.icon_msg);
            msgItem.setBgResId(R.drawable.shape_bg3_corner_down);
            msgItem.setTitleResId(R.string.message);
            msgItem.setMsgNum(0);
            msgItem.setShowline(false);
            msgItem.setType(SetItemEntity.TypeNum);
        }

        data.add(commentItem);
        data.add(msgItem);
        return data;
    }
}
