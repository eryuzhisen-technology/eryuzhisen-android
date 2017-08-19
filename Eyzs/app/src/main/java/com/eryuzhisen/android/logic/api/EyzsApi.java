package com.eryuzhisen.android.logic.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @actor:taotao
 * @DATE: 2017/8/15
 */

public class EyzsApi {
    private final static String Https = "Https://";
    private final static String Http = "Http://";
    private final static String Host = "api.eryuzhisen.com";
    private final static String Path = "/java/eryuzhisen-server";

    public final static String UrlDataKeyHomeBanner = "HomeBanner";

    public final static String UrlDataKeyPicVerifyCode = "PicVerifyCode";
    public final static String UrlDataKeyPhoneVerifyCode = "PhoneVerifyCode";
    public final static String UrlDataKeyLogin = "Login";
    public final static String UrlDataKeyRegister = "Register";
    public final static String UrlDataKeyResetPassword = "ResetPassword";

    public final static String UrlDataKeyGetUserInfo = "GetUserInfo";
    public final static String UrlDataKeyGetUserList = "GetUserList";
    public final static String UrlDataKeyAddBlack = "AddBlack";
    public final static String UrlDataKeyDeleteBlack = "DeleteBlack";
    public final static String UrlDataKeyGetBlackList = "GetBlackList";
    public final static String UrlDataKeyAddFollow = "AddFollow";
    public final static String UrlDataKeyCancelFollow = "CancelFollow";
    public final static String UrlDataKeyGetFollowList = "GetFollowList";
    public final static String UrlDataKeyGetFansList = "GetFansList";

    public final static String UrlDataKeyGetNoticeSetting = "GetNoticeSetting";
    public final static String UrlDataKeyUpdateNoticeSetting = "UpdateNoticeSetting";

    public final static String UrlDataKeyUnboundPhone = "UnboundPhone";
    public final static String UrlDataKeyRebindPhone = "RebindPhone";

    public final static String UrlDataKeyAddFeedback = "AddFeedback";

    public final static String UrlDataKeyGetMessageList = "GetMessageList";
    public final static String UrlDataKeyGetMessageDetail = "GetMessageDetail";
    public final static String UrlDataKeyDeleteMessage = "DeleteMessage";
    public final static String UrlDataKeyMarkMessage = "MarkMessage";
    public final static String UrlDataKeyGetUnreadMessage = "GetUnreadMessage";

    public final static String UrlDataKeyGetCommentList = "GetCommentList";
    public final static String UrlDataKeyAddComment = "AddComment";
    public final static String UrlDataKeyAddCommentPraise = "AddCommentPraise";

    public final static String UrlDataKeyGetCatalogList = "GetCatalogList";
    public final static String UrlDataKeyGetChapterList = "GetChapterList";
    public final static String UrlDataKeyGetChapterDetail = "GetChapterDetail";
    public final static String UrlDataKeyGetCatalogDetail = "GetCatalogDetail";
    public final static String UrlDataKeyAddCatalog = "AddCatalog";
    public final static String UrlDataKeyAddChapter = "AddChapter";
    public final static String UrlDataKeyUpdateCatalog = "UpdateCatalog";
    public final static String UrlDataKeyUpdateChapter = "UpdateChapter";

    public final static String UrlDataKeyAddPraise = "AddPraise";
    public final static String UrlDataKeyGetLabelList = "GetLabelList";
    public final static String UrlDataKeyGetCategoryList = "GetCategoryList";
    public final static String UrlDataKeyAddFavorites = "AddFavorites";
    public final static String UrlDataKeyDeleteFavorites = "DeleteFavorites";
    public final static String UrlDataKeyGetFavoritesList = "GetFavoritesList";
    public final static String UrlDataKeyAddReport = "AddReport";
    public final static String UrlDataKeyGetReportConfig = "GetReportConfig";
    public final static String UrlDataKeyGetPolicyAndAccess = "GetPolicyAndAccess";

    public final static String UrlDataKeyUpdateUserInfo = "UpdateUserInfo";
    public final static String UrlDataKeyGetNewestIndex = "GetNewestIndex";
    public final static String UrlDataKeyGetReplyCommentList = "GetReplyCommentList";

    public final static String UrlDataKeyGetAppToken = "GetAppToken";

    public final static String UrlDataKeyDeleteCatalog = "DeleteCatalog";
    public final static String UrlDataKeyDeleteChapter = "DeleteChapter";

    public final static String UrlDataKeyGetHotWords = "GetHotWords";
    public final static String UrlDataKeyGetRecommendUserList = "GetRecommendUserList";
    public final static String UrlDataKeyGetActiveUserList = "GetActiveUserList";
    public final static String UrlDataKeyGetPageModules = "GetPageModules";
    public final static String UrlDataKeyGetInviteCode = "GetInviteCode";

    public final static String UrlDataKeyCheckName = "CheckName";
    public final static String UrlDataKeyGetMyCatalogList = "GetMyCatalogList";
    public final static String UrlDataKeySortChapter = "SortChapter";

    public final static String UrlDataKeyPageviews = "Pageviews";
    public final static String UrlDataKeyGetRandCatalogList = "GetRandCatalogList";
    public final static String UrlDataKeyGetActivityList = "GetActivityList";

    private Map<String, UrlData> urlDataMap = new HashMap<String, UrlData>();
    private static EyzsApi mApi = new EyzsApi();


    private EyzsApi() {
        initDataMap();
    }

    private String getBaseUrl() {
        return Https + Host + Path;
    }

    public UrlData getApiUrlData(String key) {
        UrlData data = urlDataMap.get(key);
        return data;
    }

    public static EyzsApi getEyzsApi() {
        return mApi;
    }

    private void initDataMap() {
        UrlData data = getBannerUrl();
        urlDataMap.put(data.getKey(), data);

        data = getPicVerifyCode();
        urlDataMap.put(data.getKey(), data);
        data = getPhoneVerifyCode();
        urlDataMap.put(data.getKey(), data);
        data = getLogin();
        urlDataMap.put(data.getKey(), data);
        data = getRegister();
        urlDataMap.put(data.getKey(), data);
        data = getResetPassword();
        urlDataMap.put(data.getKey(), data);

        data = getUserInfo();
        urlDataMap.put(data.getKey(), data);
        data = getUserList();
        urlDataMap.put(data.getKey(), data);
        data = addBlack();
        urlDataMap.put(data.getKey(), data);
        data = deleteBlack();
        urlDataMap.put(data.getKey(), data);
        data = getBlackList();
        urlDataMap.put(data.getKey(), data);
        data = addFollow();
        urlDataMap.put(data.getKey(), data);
        data = cancelFollow();
        urlDataMap.put(data.getKey(), data);
        data = getFollowList();
        urlDataMap.put(data.getKey(), data);
        data = getFansList();
        urlDataMap.put(data.getKey(), data);

        data = getNoticeSetting();
        urlDataMap.put(data.getKey(), data);
        data = updateNoticeSetting();
        urlDataMap.put(data.getKey(), data);

        data = unboundPhone();
        urlDataMap.put(data.getKey(), data);
        data = rebindPhone();
        urlDataMap.put(data.getKey(), data);

        data = addFeedback();
        urlDataMap.put(data.getKey(), data);

        data = getMessageList();
        urlDataMap.put(data.getKey(), data);
        data = getMessageDetail();
        urlDataMap.put(data.getKey(), data);

        data = deleteMessage();
        urlDataMap.put(data.getKey(), data);
        data = markMessage();
        urlDataMap.put(data.getKey(), data);
        data = getUnreadMessage();
        urlDataMap.put(data.getKey(), data);

        data = getCommentList();
        urlDataMap.put(data.getKey(), data);
        data = addComment();
        urlDataMap.put(data.getKey(), data);
        data = addCommentPraise();
        urlDataMap.put(data.getKey(), data);

        data = getCatalogList();
        urlDataMap.put(data.getKey(), data);
        data = getChapterList();
        urlDataMap.put(data.getKey(), data);
        data = getChapterDetail();
        urlDataMap.put(data.getKey(), data);
        data = getCatalogDetail();
        urlDataMap.put(data.getKey(), data);
        data = addCatalog();
        urlDataMap.put(data.getKey(), data);
        data = addChapter();
        urlDataMap.put(data.getKey(), data);
        data = updateCatalog();
        urlDataMap.put(data.getKey(), data);
        data = updateChapter();
        urlDataMap.put(data.getKey(), data);
        data = addPraise();
        urlDataMap.put(data.getKey(), data);

        data = getLabelList();
        urlDataMap.put(data.getKey(), data);
        data = getCategoryList();
        urlDataMap.put(data.getKey(), data);

        data = addFavorites();
        urlDataMap.put(data.getKey(), data);
        data = deleteFavorites();
        urlDataMap.put(data.getKey(), data);
        data = getFavoritesList();
        urlDataMap.put(data.getKey(), data);
        data = addReport();
        urlDataMap.put(data.getKey(), data);
        data = getReportConfig();
        urlDataMap.put(data.getKey(), data);

        data = getPolicyAndAccess();
        urlDataMap.put(data.getKey(), data);

        data = updateUserInfo();
        urlDataMap.put(data.getKey(), data);

        data = getNewestIndex();
        urlDataMap.put(data.getKey(), data);

        data = getReplyCommentList();
        urlDataMap.put(data.getKey(), data);

        data = getAppToken();
        urlDataMap.put(data.getKey(), data);

        data = deleteCatalog();
        urlDataMap.put(data.getKey(), data);

        data = deleteChapter();
        urlDataMap.put(data.getKey(), data);

        data = getHotWords();
        urlDataMap.put(data.getKey(), data);

        data = getRecommendUserList();
        urlDataMap.put(data.getKey(), data);

        data = getActiveUserList();
        urlDataMap.put(data.getKey(), data);

        data = getPageModules();
        urlDataMap.put(data.getKey(), data);

        data = getInviteCode();
        urlDataMap.put(data.getKey(), data);

        data = checkName();
        urlDataMap.put(data.getKey(), data);

        data = getMyCatalogList();
        urlDataMap.put(data.getKey(), data);

        data = sortChapter();
        urlDataMap.put(data.getKey(), data);

        data = pageviews();
        urlDataMap.put(data.getKey(), data);

        data = getRandCatalogList();
        urlDataMap.put(data.getKey(), data);

        data = getActivityList();
        urlDataMap.put(data.getKey(), data);

    }

    //1.获取首页banner
    //URL:http://api.eryuzhisen.com/eryuzhisen-server/auth/getPicVerifyCode
    private UrlData getBannerUrl() {
        String key = UrlDataKeyHomeBanner;
        String url = getBaseUrl() + "/getHomeBanner";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //2.获取图形验证码
    private UrlData getPicVerifyCode() {
        String key = UrlDataKeyPicVerifyCode;
        String url = getBaseUrl() + "/auth/getPicVerifyCode";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //3.获取手机号验证码
    private UrlData getPhoneVerifyCode() {
        String key = UrlDataKeyPhoneVerifyCode;
        String url = getBaseUrl() + "auth/getPhoneVerifyCode";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //4.登陆
    private UrlData getLogin() {
        String key = UrlDataKeyLogin;
        String url = getBaseUrl() + "auth/sigin";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //5.注册
    private UrlData getRegister() {
        String key = UrlDataKeyRegister;
        String url = getBaseUrl() + "auth/sigup";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //6.重置密码
    private UrlData getResetPassword() {
        String key = UrlDataKeyResetPassword;
        String url = getBaseUrl() + "auth/resetPwd";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    7.获取用户信息
//    URL:http://domain/eryuzhisen-server/user/getUserInfo
    private UrlData getUserInfo() {
        String key = UrlDataKeyGetUserInfo;
        String url = getBaseUrl() + "user/getUserInfo";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    8.根据作者名称模糊查询用户列表
//    URL:http://domain/eryuzhisen-server/user/getUserList
    private UrlData getUserList() {
        String key = UrlDataKeyGetUserList;
        String url = getBaseUrl() + "user/getUserList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    9.添加黑名单用户(header 中uid为操作用户)
//    URL:http://domain/eryuzhisen-server/user/addBlack/{userId}
    private UrlData addBlack() {
        String key = UrlDataKeyAddBlack;
        String url = getBaseUrl() + "user/addBlack/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    10.删除黑名单用户(header 中uid为操作用户)
//    URL:http://domain/eryuzhisen-server/user/delBlack/{userId}
    private UrlData deleteBlack() {
        String key = UrlDataKeyDeleteBlack;
        String url = getBaseUrl() + "user/delBlack/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    11.获取黑名单用户列表
//    URL:http://domain/eryuzhisen-server/user/getBlackList
    private UrlData getBlackList() {
        String key = UrlDataKeyGetBlackList;
        String url = getBaseUrl() + "user/getBlackList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    12.关注用户
//    URL:http://domain/eryuzhisen-server/user/addFollow/{userId}
    private UrlData addFollow() {
        String key = UrlDataKeyAddFollow;
        String url = getBaseUrl() + "user/addFollow/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    13.取消关注
//    URL:http://domain/eryuzhisen-server/user/delFollow/{userId}
    private UrlData cancelFollow() {
        String key = UrlDataKeyCancelFollow;
        String url = getBaseUrl() + "user/delFollow/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    14.获取关注用户列表
//    URL:http://domain/eryuzhisen-server/user/getFollowList
    private UrlData getFollowList() {
        String key = UrlDataKeyGetFollowList;
        String url = getBaseUrl() + "user/getFollowList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    15.获取粉丝用户列表
//    URL:http://domain/eryuzhisen-server/user/getFansList
    private UrlData getFansList() {
        String key = UrlDataKeyGetFansList;
        String url = getBaseUrl() + "user/getFansList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //  16.获取用户通知设定
//    URL:http://domain/eryuzhisen-server/user/getNoticeSetting
    private UrlData getNoticeSetting() {
        String key = UrlDataKeyGetNoticeSetting;
        String url = getBaseUrl() + "user/getNoticeSetting";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    17.更新用户通知设定
//    URL:http://domain/eryuzhisen-server/user/getNoticeSetting
    private UrlData updateNoticeSetting() {
        String key = UrlDataKeyUpdateNoticeSetting;
        String url = getBaseUrl() + "user/getNoticeSetting";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    18.解除手机号绑定(此协议不做实际解除操作,只是记录标识,重新绑定手机号,必须先通过此协议)
//    URL:http://domain/eryuzhisen-server/auth/unboundPhone
    private UrlData unboundPhone() {
        String key = UrlDataKeyUnboundPhone;
        String url = getBaseUrl() + "auth/unboundPhone";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    19.重新绑定手机号
//    URL:http://domain/eryuzhisen-server/auth/reBindPhone
    private UrlData rebindPhone() {
        String key = UrlDataKeyRebindPhone;
        String url = getBaseUrl() + "auth/reBindPhone";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    20.添加用户反馈信息
//    URL:http://domain/eryuzhisen-server/report/addFeedback
    private UrlData addFeedback() {
        String key = UrlDataKeyAddFeedback;
        String url = getBaseUrl() + "report/addFeedback";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    21.获取用户消息列表
//    URL:http://domain/eryuzhisen-server/user/getMessageList
    private UrlData getMessageList() {
        String key = UrlDataKeyGetMessageList;
        String url = getBaseUrl() + "user/getMessageList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    22.获取消息详情
//    URL:http://domain/eryuzhisen-server/user/getMessageDetail
    private UrlData getMessageDetail() {
        String key = UrlDataKeyGetMessageDetail;
        String url = getBaseUrl() + "user/getMessageDetail";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    23.删除消息
//    URL:http://domain/eryuzhisen-server/user/delMessage/{msgId}
    private UrlData deleteMessage() {
        String key = UrlDataKeyDeleteMessage;
        String url = getBaseUrl() + "user/delMessage/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    24.标记已读消息
//    URL:http://domain/eryuzhisen-server/user/markMessage/{msgType}/{msgId}
    private UrlData markMessage() {
        String key = UrlDataKeyMarkMessage;
        String url = getBaseUrl() + "user/markMessage/%s/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    25.获取未读消息条数
//    URL:http://domain/eryuzhisen-server/user/getUnreadMessage
    private UrlData getUnreadMessage() {
        String key = UrlDataKeyGetUnreadMessage;
        String url = getBaseUrl() + "user/getUnreadMessage";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    26.获取作品评论列表(目前只分二级评论,不同于盖楼显示方式)
//    http://domain/eryuzhisen-server/opus/getCommentList
    private UrlData getCommentList() {
        String key = UrlDataKeyGetCommentList;
        String url = getBaseUrl() + "opus/getCommentList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    27.新增评论
//    http://domain/eryuzhisen-server/opus/addComment
    private UrlData addComment() {
        String key = UrlDataKeyAddComment;
        String url = getBaseUrl() + "opus/addComment";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    28.针对评论的点赞
//    http://domain/eryuzhisen-server/opus/addCommentPraise/{commentId}
    private UrlData addCommentPraise() {
        String key = UrlDataKeyAddCommentPraise;
        String url = getBaseUrl() + "opus/addCommentPraise/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    29.分页获取作品目录列表
//    http://domain/eryuzhisen-server/opus/getCatalogList
    private UrlData getCatalogList() {
        String key = UrlDataKeyGetCatalogList;
        String url = getBaseUrl() + "opus/getCatalogList";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    30.分页获取章节列表
//    http://domain/eryuzhisen-server/opus/getChapterList
    private UrlData getChapterList() {
        String key = UrlDataKeyGetChapterList;
        String url = getBaseUrl() + "opus/getChapterList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    31.获取章节详情
//    URL:http://domain/eryuzhisen-server/opus/getChapterDetail
    private UrlData getChapterDetail() {
        String key = UrlDataKeyGetChapterDetail;
        String url = getBaseUrl() + "opus/getChapterDetail";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    32.获取目录详情
//    URL:http://domain/eryuzhisen-server/opus/getCatalogDetail
    private UrlData getCatalogDetail() {
        String key = UrlDataKeyGetCatalogDetail;
        String url = getBaseUrl() + "opus/getCatalogDetail";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    33.创建目录
//    URL:http://domain/eryuzhisen-server/opus/addCatalog
    private UrlData addCatalog() {
        String key = UrlDataKeyAddCatalog;
        String url = getBaseUrl() + "opus/addCatalog";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    34.创建章节
//    URL:http://domain/eryuzhisen-server/opus/addChapter
    private UrlData addChapter() {
        String key = UrlDataKeyAddChapter;
        String url = getBaseUrl() + "opus/addChapter";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    35.更新目录(更新目录会重新进入审核状态，请前端提示)
//    URL:http://domain/eryuzhisen-server/opus/updateCatalog
    private UrlData updateCatalog() {
        String key = UrlDataKeyUpdateCatalog;
        String url = getBaseUrl() + "opus/updateCatalog";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    36.更新章节内容（已发布的是不能修改的，只针对临时保存的章节）
//    URL:http://domain/eryuzhisen-server/opus/updateChapter
    private UrlData updateChapter() {
        String key = UrlDataKeyUpdateChapter;
        String url = getBaseUrl() + "opus/updateChapter";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    37.作品点赞(如果只针对目录点赞，chapterId设为0)
//    URL:http://domain/eryuzhisen-server/opus/addPraise/{catalogId}/{chapterId}
    private UrlData addPraise() {
        String key = UrlDataKeyAddPraise;
        String url = getBaseUrl() + "opus/addPraise/%s/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    38.随机获取标签列表
//    URL:http://domain/eryuzhisen-server/opus/getLabelList
    private UrlData getLabelList() {
        String key = UrlDataKeyGetLabelList;
        String url = getBaseUrl() + "opus/getLabelList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    39.获取作品分类列表(******所有类别关联的数据，以二级类别为准，如目前只有一级类，会创建一个同名的二级子类，方便以后扩展********)
//    URL:http://domain/eryuzhisen-server/opus/getCategoryList
    private UrlData getCategoryList() {
        String key = UrlDataKeyGetCategoryList;
        String url = getBaseUrl() + "opus/getCategoryList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    40.新增作品收藏(如果只收藏目录,chapterId请设置为0)
//    URL:http://domain/eryuzhisen-server/opus/addFavorites/{catalogId}
    private UrlData addFavorites() {
        String key = UrlDataKeyAddFavorites;
        String url = getBaseUrl() + "opus/addFavorites/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    41.删除收藏
//    URL:http://domain/eryuzhisen-server/opus/delFavorites/{catalogId}
    private UrlData deleteFavorites() {
        String key = UrlDataKeyDeleteFavorites;
        String url = getBaseUrl() + "opus/delFavorites/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    42.获取用户收藏列表
//    URL:http://domain/eryuzhisen-server/opus/getFavoritesList
    private UrlData getFavoritesList() {
        String key = UrlDataKeyGetFavoritesList;
        String url = getBaseUrl() + "opus/getFavoritesList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    43.举报
//    URL:http://domain/eryuzhisen-server/report/addReport
    private UrlData addReport() {
        String key = UrlDataKeyAddReport;
        String url = getBaseUrl() + "report/addReport";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    44.获取举报配置列表
//    URL:http://domain/eryuzhisen-server/report/getReportConfig
    private UrlData getReportConfig() {
        String key = UrlDataKeyGetReportConfig;
        String url = getBaseUrl() + "report/getReportConfig";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    45.获取阿里OSS上传文件的签名及上传policy
//    URL:http://domain/eryuzhisen-server/upload/getPolicyAndAccess
    private UrlData getPolicyAndAccess() {
        String key = UrlDataKeyGetPolicyAndAccess;
        String url = getBaseUrl() + "upload/getPolicyAndAccess";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    46.修改用户信息
//    URL:http://domain/eryuzhisen-server/user/updateUserInfo
    private UrlData updateUserInfo() {
        String key = UrlDataKeyUpdateUserInfo;
        String url = getBaseUrl() + "user/updateUserInfo";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    47.获取章节最新序号
//    URL:http://domain/eryuzhisen-server/opus/getNewestIndex
    private UrlData getNewestIndex() {
        String key = UrlDataKeyGetNewestIndex;
        String url = getBaseUrl() + "opus/getNewestIndex";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    48.获取回复型评论列表
//    URL:http://domain/eryuzhisen-server/opus/getReplyCommentList
    private UrlData getReplyCommentList() {
        String key = UrlDataKeyGetReplyCommentList;
        String url = getBaseUrl() + "opus/getReplyCommentList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    49.获取移动app上传文件token
//    URL:http://domain/eryuzhisen-server/upload/getAppToken
    private UrlData getAppToken() {
        String key = UrlDataKeyGetAppToken;
        String url = getBaseUrl() + "upload/getAppToken";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    50.删除目录
//    URL:http://domain/eryuzhisen-server/opus/delCatalog/{catalogId}
    private UrlData deleteCatalog() {
        String key = UrlDataKeyDeleteCatalog;
        String url = getBaseUrl() + "opus/delCatalog/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    51.删除章节
//    URL:http://domain/eryuzhisen-server/opus/delChapter/{chapterId}
    private UrlData deleteChapter() {
        String key = UrlDataKeyDeleteChapter;
        String url = getBaseUrl() + "opus/deleteChapter/%s";
        String nettype = UrlData.TypeHttpDelete;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    52.随机获取热门词（按redis score大到小排序，每次获取都是随机，如果count大于配置的数量则不变）
//    URL:http://domain/eryuzhisen-server/opus/getHotWords
    private UrlData getHotWords() {
        String key = UrlDataKeyGetHotWords;
        String url = getBaseUrl() + "opus/getHotWords";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    53.获取推荐用户列表（根据作品数，粉丝数排序 前pageSize条数据）
//    URL:http://domain/eryuzhisen-server/user/getRecommendUserList
    private UrlData getRecommendUserList() {
        String key = UrlDataKeyGetRecommendUserList;
        String url = getBaseUrl() + "user/getRecommendUserList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    54.根据标签获取活跃用户列表
//    URL:http://domain/eryuzhisen-server/user/getActiveUserList
    private UrlData getActiveUserList() {
        String key = UrlDataKeyGetActiveUserList;
        String url = getBaseUrl() + "user/getActiveUserList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    55.获取页面模块配置
//    ULR:http://domain/eryuzhisen-server/config/getPageModules
    private UrlData getPageModules() {
        String key = UrlDataKeyGetPageModules;
        String url = getBaseUrl() + "config/getPageModules";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    56.获取邀请码
//    ULR:http://domain/eryuzhisen-server/user/getInviteCode
    private UrlData getInviteCode() {
        String key = UrlDataKeyGetInviteCode;
        String url = getBaseUrl() + "user/getInviteCode";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    57.检查用户昵称是否存在
//    ULR:http://domain/eryuzhisen-server/user/checkName
    private UrlData checkName() {
        String key = UrlDataKeyCheckName;
        String url = getBaseUrl() + "user/checkName";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    58.获取我的主页（用户自己的目录列表）
//    http://domain/eryuzhisen-server/opus/getMyCatalogList
    private UrlData getMyCatalogList() {
        String key = UrlDataKeyGetMyCatalogList;
        String url = getBaseUrl() + "opus/getMyCatalogList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    59.章节排序
//    URL:http://domain/eryuzhisen-server/opus/sortChapter
    private UrlData sortChapter() {
        String key = UrlDataKeySortChapter;
        String url = getBaseUrl() + "opus/sortChapter";
        String nettype = UrlData.TypeHttpPost;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    60.作品浏览(如果只针对目录，chapterId设为0)
//    URL:http://domain/eryuzhisen-server/opus/pageviews/{catalogId}/{chapterId}
    private UrlData pageviews() {
        String key = UrlDataKeyPageviews;
        String url = getBaseUrl() + "opus/pageviews/%s/%s";
        String nettype = UrlData.TypeHttpPut;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    61.首页中的随机获取
//    http://domain/eryuzhisen-server/opus/getRandCatalogList
    private UrlData getRandCatalogList() {
        String key = UrlDataKeyGetRandCatalogList;
        String url = getBaseUrl() + "opus/getRandCatalogList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }

    //    62.获取首页活动列表
//    ULR:http://domain/eryuzhisen-server/config/getActivityList
    private UrlData getActivityList() {
        String key = UrlDataKeyGetActivityList;
        String url = getBaseUrl() + "config/getActivityList";
        String nettype = UrlData.TypeHttpGet;
        UrlData data = new UrlData(key, url, nettype);
        return data;
    }
}
