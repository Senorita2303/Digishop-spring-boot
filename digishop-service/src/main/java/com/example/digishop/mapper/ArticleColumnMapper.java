package com.example.digishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.ArticleColumnQueryDto;
import com.example.digishop.domain.entity.ArticleCategory;
import com.example.digishop.domain.entity.ArticleColumn;
import com.example.digishop.domain.vo.ArticleColumnVo;
import com.example.digishop.domain.vo.ArticleVo;

/**
 * 文章栏目持久层
 *
 * @author SunTao
 * @since 2022-11-22
 */
public interface ArticleColumnMapper extends BaseMapper<ArticleColumn> {
	/**
	 * 查询栏目列表
	 *
	 * @param queryDto 查询参数
	 * @return ColumnVoList
	 */
	List<ArticleColumnVo> selectColumnList(ArticleColumnQueryDto queryDto);

	/**
	 * 查询栏目详情
	 *
	 * @param columnId 栏目ID
	 * @return ColumnVo
	 */
	ArticleColumnVo selectColumnDetail(@Param("columnId") Long columnId);

	/**
	 * 根据栏目名称查询栏目信息
	 *
	 * @param name 栏目名称
	 * @return ColumnVo
	 */
	ArticleCategory selectByColumnName(@Param("name") String name);

	/**
	 * 查询非专栏对应的文章列表
	 *
	 * @param queryDto 查询参数
	 * @return ArticleVo
	 */
	List<ArticleVo> selectArticleListNotColumn(ArticleColumnQueryDto queryDto);

	/**
	 * 查询前台专栏列表
	 *
	 * @return ColumnList
	 */
	List<ArticleColumnVo> selectWebColumnList();
}