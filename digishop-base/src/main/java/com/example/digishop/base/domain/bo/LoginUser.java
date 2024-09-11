package com.example.digishop.base.domain.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 左侧菜单元数据
 *
 * @author SunTao
 * @since 2023-06-29
 */
@Getter
@Setter
public class LoginUser implements Serializable {
	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户令牌
	 */
	private String accessToken;
}