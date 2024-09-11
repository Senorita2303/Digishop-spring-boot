package com.example.digishop.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.entity.Visitor;

/**
 * 访客数据持久层
 *
 * @author SunTao
 * @since 2022-12-09
 */
public interface VisitorMapper extends BaseMapper<Visitor> {
	/**
	 * 增加网站访问量
	 */
	void addWebVisitorCount();

	/**
	 * 日期数据是否存在
	 *
	 * @param date 日期
	 * @return boolean
	 */
	boolean existsDate(@Param("date") String date);

	/**
	 * 新增日期访问量
	 *
	 * @param date 日期
	 */
	void insertWebVisitorTodayCount(@Param("date") String date);

	/**
	 * 更新日期访问量
	 *
	 * @param date 日期
	 */
	void addWebVisitorTodayCount(@Param("date") String date);
}