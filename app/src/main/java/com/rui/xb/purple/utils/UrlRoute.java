package com.rui.xb.purple.utils;


/**
 * Created by Rui on 2018/5/31.
 */

public class UrlRoute {

    /** 标记、是否使用https */
    static boolean USE_SSL = false;

    static String SCHEME = USE_SSL ? "https://" : "http://";

    static String HOSTS = "www.baidu.com";

    public static String BASE_URL = SCHEME + HOSTS;

}
