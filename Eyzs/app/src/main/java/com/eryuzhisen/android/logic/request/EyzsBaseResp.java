package com.eryuzhisen.android.logic.request;

import com.na.mvp.net.response.LogicBaseResp;

/**
 * @actor:taotao
 * @DATE: 2017/8/19
 */

public class EyzsBaseResp extends LogicBaseResp {
    private static final long serialVersionUID = 5829960233646379464L;

    //  "ret":"1",//0 成功 1 失败
    //  "errcode":"10001",//错误码 ret为1时出现,详情请查看附录
    //  "errinfo":"xxxx",
    private String ret;
    private String errcode;
    private String errinfo;

}
