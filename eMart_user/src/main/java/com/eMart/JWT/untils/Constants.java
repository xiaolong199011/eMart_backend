package com.eMart.JWT.untils;

/**
 * Created by Administrator on 2018/1/27.
 */
public class Constants {

    public static final long ERR_NUM_OK = 200;
    public static final String ERR_MSG_OK = "成功";

    public static final long ERR_NUM_USER_EXIST = 410;
    public static final String ERR_MSG_USER_EXIST = "用户已存在";
    public static final long ERR_NUM_PWD_ERR = 411;
    public static final String ERR_MSG_PWD_ERR = "密码错误";
    public static final long ERR_NUM_USERNAME_EMPTY = 412;
    public static final String ERR_MSG_USERNAME_EMPTY = "用户名不能为空";
    public static final long ERR_NUM_TOKEN_ERR = 413;
    public static final String ERR_MSG_TOKEN_ERR = "Token解析错误";
    public static final long ERR_NUM_TOKEN_EXP = 414;
    public static final String ERR_MSG_TOKEN_EXP = "Token已过期";
    public static final long ERR_NUM_TOKEN_EMPTY = 415;
    public static final String ERR_MSG_TOKEN_EMPTY = "Token不能为空";
    public static final long ERR_NUM_LOGIN_DOU = 416;
    public static final String ERR_MSG_LOGIN_DOU = "已在别处登录";

    public static final long ERR_NUM_SERVER_ERR = 500;
    public static final String ERR_MSG_SERVER_ERR = "服务器错误";
}
