/**
 * @Title: DateUtil.java
 * @Package com.manhui.gsl.jbqgsl.common.util
 * @Description: TODO(日期时间工具类)
 * @author LiuBin
 * @date 2018年8月8日
 * @version V1.0
 * @modify By:
 * @Copyright: 版权由满惠科技拥有
 */
package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

    /**
     * @方法名称 getDateTime
     * @功能描述 按传入格式获取当前日期时间
     * @return
     */
    public static String getDateTime( String format ) {
        return new SimpleDateFormat( format ).format( new Date() );
    }

    /**
     * @方法名称 strToDate
     * @功能描述 字符串转Date
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date strToDate( String str, String format ) {
        Date date = null;
        try {
            date = new SimpleDateFormat( format ).parse( str );
        }
        catch ( ParseException e ) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        return df.format( new Date() );
    }

}
