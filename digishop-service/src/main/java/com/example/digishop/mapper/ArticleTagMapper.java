package com.example.digishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.ArticleTagQueryDto;
import com.example.digishop.domain.entity.ArticleTag;
import com.example.digishop.domain.vo.ArticleTagVo;
import com.example.digishop.domain.vo.CloudTagVo;

/**
 * 文章标签数据持久层
 *
 * @author SunTao
 * @since 2021-01-17
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
	/**
	 * 查询标签列表
	 *
	 * @param queryDto 查询参数
	 * @return TagVoList
	 */
	List<ArticleTagVo> selectTagList(ArticleTagQueryDto queryDto);

	/**
	 * 查询标签详情
	 *
	 * @param tagId 标签ID
	 * @return TagVo
	 */
	ArticleTagVo selectTagDetail(@Param("tagId") Long tagId);

	/**
	 * 根据标签名称查询标签信息
	 *
	 * @param name 标签名称
	 * @return ArticleTag
	 */
	ArticleTag selectByTagName(@Param("name") String name);

	/**
	 * 查询标签对应的文章数
	 *
	 * @param tagId 标签序号
	 * @return 文章数
	 */
	Long selectArticleCountByTag(@Param("tagId") Long tagId);

	/**
	 * 查询前台标签列表
	 *
	 * @return TagList
	 */
	List<ArticleTagVo> selectWebTagList();

	/**
	 * 获取标签云数据
	 *
	 * @return CloudTagVos
	 */
	List<CloudTagVo> queryBoardTagList();

	/**
	 * 通过加锁的方式获取标签信息
	 *
	 * @param tagId 标签id
	 * @return ArticleTag
	 */
	ArticleTag getByIdWithRowLock(@Param("tagId") Long tagId);
}