package com.example.digishop.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.digishop.domain.entity.ArticleImgRelation;

/**
 * 文章封面中间数据数据持久层
 *
 * @author SunTao
 * @since 2022-12-04
 */
public interface ArticleImgRelationMapper extends BaseMapper<ArticleImgRelation> {
	/**
	 * 根据文章序列删除关联数据
	 *
	 * @param articleId 文章序列
	 */
	void deleteByArticleId(@Param("articleId") Long articleId);
}