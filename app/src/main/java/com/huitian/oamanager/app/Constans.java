package com.huitian.oamanager.app;

/**
 * 字符串常量类
 * Created by Chen on 2017/4/27.
 */

public class Constans {
    //  应用终端名
    public static String appname = "android";
    // 应用终端版本
    public static String ver = "v1.0.0";
    // 应用密匙串
    public static String api_key = "huitian_o+!Gks9=_android";
    // 一次握手参数
    public static String s = "";
    // 随机生成的字符串
    public static String r = "";
    // m = z   服务器通过客户端随机字符串生成的校验密串
    public static String m = "";
    // 通过接口返回的数据字段y进行base64反解码
    public static String n = "";
    // 通过接口返回的数据字段x进行base64反解码
    public static String t = "";
    // 二次认证密匙k
    public static String k = "";
    // 免密登陆字段
    public static String keyStr = "key_str";
    // SharePreference名称
    public static final String SP_NAME = "config";
    // 过期时间戳
    public static long expire = 0;
    // 保存在sp里面的字段名
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String M = "m";
    public static final String N = "n";
    public static final String T = "t";
    public static final String K = "k";
    public static final String EXPIRE_TIME = "expire";
    // 进入APP，当时间戳没有过期，后面一分钟更新一次握手
    public static final long TASK_TIME = 1 * 1000;
    // 保存cookie到本地
    public static final String COOKIE_PREF = "cookies_prefs";
}