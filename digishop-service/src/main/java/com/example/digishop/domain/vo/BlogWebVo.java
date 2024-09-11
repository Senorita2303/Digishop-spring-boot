package com.example.digishop.domain.vo;

import java.util.List;

import com.example.digishop.domain.bo.PageInfo;
import com.example.digishop.domain.dto.setting.OtherInfo;
import com.example.digishop.domain.dto.setting.SocialInfo;
import com.example.digishop.domain.dto.setting.WebInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 博客前台信息
 *
 * @author SunTao
 * @since 2022-12-09
 */
@Getter
@Setter
@ToString
public class BlogWebVo {
	/**
	 * 文章数量
	 */
	private int articleCount;

	/**
	 * 分类数量
	 */
	private int categoryCount;

	/**
	 * 分类数量
	 */
	private int columnCount;

	/**
	 * 标签数量
	 */
	private int tagCount;

	/**
	 * 访问数
	 */
	private int viewsCount;

	/**
	 * 游客数
	 */
	private int visitorCount;

	/**
	 * 用户数
	 */
	private int userCount;

	/**
	 * 文章阅读数
	 */
	private int articleViewCount;

	/**
	 * 评论数
	 */
	private int commentCount;

	/**
	 * 留言数
	 */
	private int messageCount;

	/**
	 * 网站版本
	 */
	private String websiteVersion;

	/**
	 * 默认封面
	 */
	private String articleDefaultImg;

	/**
	 * 网站信息
	 */
	private WebInfo webInfo;

	/**
	 * 社交信息
	 */
	private SocialInfo socialInfo;

	/**
	 * 其他信息
	 */
	private OtherInfo otherInfo;

	/**
	 * 前端页面信息
	 */
	private List<PageInfo> pageList;
}