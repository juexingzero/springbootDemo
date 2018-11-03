package com.demo.controller;

import com.demo.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class IndexController {

	@Resource
	private RedisService RedisService;

	@RequestMapping("/index")
	public String index() {
		return "index"; 
	}

	@RequestMapping("/redis")
	@ResponseBody
	public String redis(){
		RedisService.set("redis", "123213123");
		return "success";
	}

	@RequestMapping("/getredis")
	@ResponseBody
	public String getRedis(){
		String result = (String)RedisService.get("redis");
		return result;
	}
}
