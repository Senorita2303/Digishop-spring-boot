package com.example.digishop.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.digishop.core.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章点赞
 *
 * @author SunTao
 * @since 2023-02-07
 */
@Getter
@Setter
@TableName("article_like")
public class ArticleLike extends BaseEntity {
	/**
	 * 主键
	 */
	@TableId
	private Long id;

	/**
	 * 点赞用户
	 */
	private Long userId;

	/**
	 * 点赞文章
	 */
	private Long articleId;

	/**
	 * 点赞用户IP
	 */
	private String ipAddress;

	/**
	 * 点赞用户地址
	 */
	private String ipSource;
}