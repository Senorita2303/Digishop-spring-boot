package com.example.digishop.log.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.digishop.log.domain.dto.LogQueryDto;
import com.example.digishop.log.domain.entity.Log;
import com.example.digishop.log.domain.vo.LogVo;

/**
 * 日志数据持久层
 *
 * @author SunTao
 * @since 2021-05-16
 */
public interface LogMapper extends BaseMapper<Log> {
	/**
	 * 查询日志列表
	 *
	 * @param param 查询参数
	 * @return LogVoList
	 */
	List<LogVo> selectLogList(LogQueryDto param);

	/**
	 * 删除日志列表
	 *
	 * @param logType 日志类型
	 */
	void deleteLog(@Param("logType") Integer logType);

	/**
	 * 查询日志堆栈详情
	 *
	 * @param logId 日志序号
	 * @return exceptionDetail
	 */
	String selectLogErrorDetail(@Param("logId") Long logId);
}