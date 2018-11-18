package com.demo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 工具类
 *
 * @author 陈智颖
 * @create 2018-08-03 下午5:19
 **/
public class AppUtil {

    /**
     * 获取两个时间的天数
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return +-(endTime - startTime)
     * @throws Exception
     */
    public static int getDay(String startTime, String endTime){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (int) ((date.parse(endTime).getTime() - date.parse(startTime).getTime()) / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 设置当前cookie 浏览器关闭消失
     *
     * @param response
     * @param name     cookie名称
     * @param value    cookie值
     * @author
     */
    public static void setUserCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = null;
        try {
            cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 清除当前cookie
     *
     * @param response
     * @param name     cookie名称
     * @author
     */
    public static void closeUserCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 清除当前cookie
     *
     * @param response
     * @param name     cookie名称
     * @author
     */
    public static void closeUserCookieManage(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/manage");
        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        try {
            Cookie[] cookies = request.getCookies();
            //cookies不为空，则清除
            if (cookies!=null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    String user_name = URLDecoder.decode(cookie.getName(), "UTF-8");
                    //查找用户名
                    if (user_name.equals(name)) {
                        return URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj){
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            map.put(fieldName, value);
        }
        return map;
    }

    /**
     * 获取cookie
     *
     * @param request
     * @param name    名称
     * @return
     * @author 陈智颖
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 获得一个去掉‘-’的UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
