package com.example.digishop.core.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * ZblogProperties，系统基础配置信息
 *
 * @author SunTao
 * @since 2022-06-07
 */
@Data
@ConfigurationProperties(prefix = "digishop")
public class DigishopProperties {
	/**
	 * basePackage
	 */
	private String basePackage = "com.example.digishop";

	/**
	 * 文件的访问地址
	 */
	private String fileDomain;

	/**
	 * 文件上传目录
	 */
	private String fileUploadPath;

	/**
	 * 文件访问域名
	 */
	private String fileBaseUrl = "http://localhost:8080/file";

	/**
	 * 文件上传类型（1，本地；2，阿里云存储；3，七牛云存储；4，ftp-未实现；5...）
	 */
	private int fileUploadType = 1;
}