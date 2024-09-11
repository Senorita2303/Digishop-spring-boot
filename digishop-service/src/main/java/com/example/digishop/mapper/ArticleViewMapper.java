package com.example.digishop.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.entity.ArticleView;

/**
 * 文章浏览数据持久层
 *
 * @author SunTao
 * @since 2023-02-08
 */
public interface ArticleViewMapper extends BaseMapper<ArticleView> {
	/**
	 * 查找最近的浏览记录
	 *
	 * @param articleId 文章ID
	 * @param accessIp  访问IP
	 * @return ArticleView
	 */
	ArticleView selectLastedRecord(@Param("articleId") Long articleId, @Param("accessIp") String accessIp);
}