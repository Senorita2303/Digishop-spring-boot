package com.example.digishop.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.digishop.core.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章标签关系表
 *
 * @author SunTao
 * @since 2022-06-07
 */
@Getter
@Setter
@TableName("article_tag_relation")
public class ArticleTagRelation extends BaseEntity {
	/**
	 * 主键
	 */
	@TableId
	private Long id;

	/**
	 * 文章序列
	 */
	private Long articleId;

	/**
	 * 标签序列
	 */
	private Long tagId;

	/**
	 * 是否已删除（使用逻辑操作，保护数据），修改时采用硬删除
	 */
	@TableLogic
	private Boolean deleted;
}