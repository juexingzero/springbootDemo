package com.demo.shiro.model;

import lombok.Data;

/**
 * @author 陈智颖
 * @create 2018-08-01 上午9:06
 **/
@Data
public class ShiroProperties {

    // shiro redis缓存时长，默认值 1800 秒
    private int timeout = 1800;
    // session 超时时间，默认 1800000毫秒
    private long sessionTimeout = 1800000L;
    // rememberMe 有效时长，默认为 86400 秒，即一天
    private int cookieTimeout = 86400;

    private String anonUrl;

    private String loginUrl;

    private String successUrl;

    private String logoutUrl;

    private String unauthorizedUrl;
}
