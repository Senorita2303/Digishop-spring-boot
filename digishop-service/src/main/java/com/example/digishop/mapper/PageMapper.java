package com.example.digishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.bo.PageInfo;
import com.example.digishop.domain.entity.Page;
import com.example.digishop.domain.vo.PageVo;

/**
 * 页面数据持久层
 *
 * @author SunTao
 * @since 2022-12-14
 */
public interface PageMapper extends BaseMapper<Page> {
	/**
	 * 查询页面配置列表
	 *
	 * @return PageVoList
	 */
	List<PageVo> selectPageList();

	/**
	 * 查询页面详情
	 *
	 * @param pageId 页面ID
	 * @return PageVo
	 */
	PageVo selectPageDetail(@Param("pageId") Long pageId);

	/**
	 * 查询前台页面列表
	 *
	 * @return PageList
	 */
	List<PageInfo> selectWebPageList();
}