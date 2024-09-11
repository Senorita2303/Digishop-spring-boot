package com.example.digishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.TalkQueryDto;
import com.example.digishop.domain.entity.Talk;
import com.example.digishop.domain.vo.TalkVo;

/**
 * 说说数据持久层
 *
 * @author SunTao
 * @since 2022-12-12
 */
public interface TalkMapper extends BaseMapper<Talk> {
	/**
	 * 分页查询说说列表
	 *
	 * @param queryDto 查询参数
	 * @return TalkVoList
	 */
	List<TalkVo> selectTalkList(TalkQueryDto queryDto);

	/**
	 * 查询说说详情
	 *
	 * @param talkId 说说ID
	 * @return TalkVo
	 */
	TalkVo selectTalkDetail(@Param("talkId") Long talkId);

	/**
	 * 刷新说说置顶信息
	 *
	 * @param talkId 说说ID
	 */
	void updateTopStatus(@Param("talkId") Long talkId);

	/**
	 * 查询首页轮播的说说列表
	 *
	 * @return TalkList
	 */
	List<TalkVo> queryBoardTalkList();

	/**
	 * 查询前台说说列表
	 *
	 * @param queryDto 查询参数
	 * @return TalkList
	 */
	List<TalkVo> selectWebTalkList(TalkQueryDto queryDto);

	/**
	 * 查询前台说说详情
	 *
	 * @param talkId 查询详情
	 * @return TalkVo
	 */
	TalkVo selectWebTalkDetail(@Param("talkId") Long talkId);
}