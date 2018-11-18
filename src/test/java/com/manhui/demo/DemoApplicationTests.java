package com.manhui.demo;

import com.demo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	private RedisService RedisService;

	@Test
	public void contextLoads() {
		RedisService.set("redis","123213");
	}

}
