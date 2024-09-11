package com.example.digishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.digishop.base.runner.InitRouterBlackWhiteListRunner;
import com.example.digishop.log.annotation.EnableLog;

/**
 * 前后端分离个人博客开源项目 - digishop.
 * 本项目链接：<a href="https://github.com/stazxr/zblog">...</a> 基于单体的 3.1
 * 版本进行改造，单体链接：<a href="https://github.com/stazxr/Blog">...</a>
 *
 * @author SunTao
 * @since 2020-11-14
 * @version 4.0.0
 */
@EnableLog
@EnableCaching
@SpringBootApplication
public class DigishopApplication {
	public static void main(String[] args) {
		SpringApplication.run(DigishopApplication.class, args);

		// 开启刷新黑白名单
		InitRouterBlackWhiteListRunner.start();
	}
}