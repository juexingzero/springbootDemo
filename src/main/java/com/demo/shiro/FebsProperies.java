package com.demo.shiro;

import com.demo.shiro.model.ShiroProperties;
import com.demo.shiro.model.ShiroProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈智颖
 * @create 2018-08-01 上午9:07
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "febs")
public class FebsProperies {

    private ShiroProperties shiro = new ShiroProperties();

    private String timeFormat = "yyyy-MM-dd HH:mm:ss";

    private boolean openAopLog = true;
}
