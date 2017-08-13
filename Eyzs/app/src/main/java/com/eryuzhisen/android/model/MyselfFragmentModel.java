package com.eryuzhisen.android.model;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.MessageFragmentContract;
import com.eryuzhisen.android.contract.MyselfFragmentContract;
import com.eryuzhisen.android.model.entity.SetIntervalEntity;
import com.eryuzhisen.android.model.entity.SetItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class MyselfFragmentModel implements MyselfFragmentContract.Model {
    private SetItemEntity myWritingItem;
    private SetItemEntity inviteFriendItem;

    private SetItemEntity markItem;
    private SetItemEntity feedbackItem;
    private SetItemEntity helpItem;

    private SetItemEntity joinItem;


    @Override
    public List getData() {


        List data = new ArrayList();
        SetIntervalEntity item = new SetIntervalEntity();
        if (myWritingItem == null) {
            myWritingItem = new SetItemEntity();
            myWritingItem.setIconResId(R.mipmap.icon_writting);
            myWritingItem.setBgResId(R.drawable.shape_bg3_corner_up);
            myWritingItem.setTitleResId(R.string.my_writting);
            myWritingItem.setMsgNum(0);
            myWritingItem.setShowline(true);
            myWritingItem.setType(SetItemEntity.TypeNum);
        }
        data.add(myWritingItem);

        if (inviteFriendItem == null) {
            inviteFriendItem = new SetItemEntity();
            inviteFriendItem.setIconResId(R.mipmap.icon_invite);
            inviteFriendItem.setBgResId(R.drawable.shape_bg3_corner_down);
            inviteFriendItem.setTitleResId(R.string.message);
            inviteFriendItem.setMsgNum(0);
            inviteFriendItem.setShowline(false);
            inviteFriendItem.setType(SetItemEntity.TypeArrow);
        }
        data.add(inviteFriendItem);


        data.add(item);

        if (markItem == null) {
            markItem = new SetItemEntity();
            markItem.setIconResId(R.mipmap.icon_mark);
            markItem.setBgResId(R.drawable.shape_bg3_corner_up);
            markItem.setTitleResId(R.string.give_mark);
            markItem.setMsgNum(0);
            markItem.setShowline(true);
            markItem.setType(SetItemEntity.TypeArrow);
        }
        data.add(markItem);

        if (feedbackItem == null) {
            feedbackItem = new SetItemEntity();
            feedbackItem.setIconResId(R.mipmap.icon_feedback);
            feedbackItem.setBgResId(R.drawable.shape_bg3_corner_mid);
            feedbackItem.setTitleResId(R.string.feedback);
            feedbackItem.setMsgNum(0);
            feedbackItem.setShowline(true);
            feedbackItem.setType(SetItemEntity.TypeArrow);
        }
        data.add(feedbackItem);

        if (helpItem == null) {
            helpItem = new SetItemEntity();
            helpItem.setIconResId(R.mipmap.icon_invite);
            helpItem.setBgResId(R.drawable.shape_bg3_corner_down);
            helpItem.setTitleResId(R.string.message);
            helpItem.setMsgNum(0);
            helpItem.setShowline(false);
            helpItem.setType(SetItemEntity.TypeArrow);
        }
        data.add(helpItem);

        data.add(item);
        if (joinItem == null) {
            joinItem = new SetItemEntity();
            joinItem.setIconResId(R.mipmap.icon_qq_group);
            joinItem.setBgResId(R.drawable.shape_bg3_corner);
            joinItem.setTitleResId(R.string.join_qq_group);
            joinItem.setMsgNum(0);
            joinItem.setShowline(false);
            joinItem.setType(SetItemEntity.TypeArrow);
        }
        data.add(joinItem);


        return data;
    }
}
