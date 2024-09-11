package com.example.digishop.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.entity.CommentLike;

/**
 * 评论点赞数据持久层
 *
 * @author SunTao
 * @since 2023-02-06
 */
public interface CommentLikeMapper extends BaseMapper<CommentLike> {
	/**
	 * 判断用户是否点过赞
	 *
	 * @param userId    用户ID
	 * @param commentId 评论ID
	 * @return boolean
	 */
	boolean isLiked(@Param("userId") Long userId, @Param("commentId") Long commentId);

	/**
	 * 删除点赞记录
	 *
	 * @param userId    用户ID
	 * @param commentId 评论ID
	 */
	void deleteLike(@Param("userId") Long userId, @Param("commentId") Long commentId);
}