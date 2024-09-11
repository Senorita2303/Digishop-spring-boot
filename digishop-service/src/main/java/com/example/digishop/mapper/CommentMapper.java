package com.example.digishop.mapper;

import java.util.List;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.CommentQueryDto;
import com.example.digishop.domain.entity.Comment;
import com.example.digishop.domain.vo.CommentReplyVo;
import com.example.digishop.domain.vo.CommentVo;

/**
 * 评论数据持久层
 *
 * @author SunTao
 * @since 2023-02-03
 */
public interface CommentMapper extends BaseMapper<Comment> {
	/**
	 * 查询前台评论列表
	 *
	 * @param queryDto 请求参数
	 * @return CommentVoList
	 */
	List<CommentVo> selectWebCommentList(CommentQueryDto queryDto);

	/**
	 * 查询前台评论回复列表
	 *
	 * @param queryDto 请求参数
	 * @return CommentVoList
	 */
	List<CommentReplyVo> selectWebCommentReplyList(CommentQueryDto queryDto);

	/**
	 * 分页查询后台评论列表
	 *
	 * @param queryDto 查询参数
	 * @return CommentVoList
	 */
	List<CommentVo> selectCommentList(CommentQueryDto queryDto);

	/**
	 * 审核评论
	 *
	 * @param commentIds 评论列表
	 */
	void auditComment(List<Long> commentIds);

	/**
	 * 获取最新评论列表
	 *
	 * @return CommentVos
	 */
	List<CommentVo> selectBoardLastedCommentList();
}