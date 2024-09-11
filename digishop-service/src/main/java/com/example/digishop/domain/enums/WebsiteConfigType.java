package com.example.digishop.domain.enums;

public enum WebsiteConfigType {
	/**
	 * 网站信息
	 */
	WEB_INFO(1),

	/**
	 * 社交信息
	 */
	SOCIAL_INFO(2),

	/**
	 * 其他信息
	 */
	OTHER_INFO(3);

	private final Integer type;

	WebsiteConfigType(Integer type) {
		this.type = type;
	}

	public Integer value() {
		return type;
	}
}