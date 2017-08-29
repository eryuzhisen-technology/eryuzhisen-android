package com.eryuzhisen.android.logic;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public interface Constants {

    int CommandHomeBanner = 1000;

    int CommandPicVerifyCode = CommandHomeBanner + 1;
    int CommandPhoneVerifyCode = CommandPicVerifyCode + 1;
    int CommandLogin = CommandPhoneVerifyCode + 1;
    int CommandRegister = CommandLogin + 1;
    int CommandResetPassword = CommandRegister + 1;
}
