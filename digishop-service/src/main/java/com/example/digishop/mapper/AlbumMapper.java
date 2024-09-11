package com.example.digishop.mapper;

import java.util.List;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.AlbumQueryDto;
import com.example.digishop.domain.entity.Album;
import com.example.digishop.domain.vo.AlbumVo;

/**
 * 相册数据持久层
 *
 * @author SunTao
 * @since 2022-12-15
 */
public interface AlbumMapper extends BaseMapper<Album> {
	/**
	 * 分页查询相册列表
	 *
	 * @param queryDto 查询参数
	 * @return AlbumVoList
	 */
	List<AlbumVo> selectAlbumList(AlbumQueryDto queryDto);

	/**
	 * 查询相册详情
	 *
	 * @param albumId 相册ID
	 * @return AlbumVo
	 */
	AlbumVo selectAlbumDetail(Long albumId);

	/**
	 * 查询用户相册列表
	 *
	 * @param queryDto 查询参数
	 * @return AlbumVoList
	 */
	List<AlbumVo> selectUserAlbumList(AlbumQueryDto queryDto);

	/**
	 * 查询前台相册列表
	 *
	 * @return AlbumVo
	 */
	List<AlbumVo> selectWebAlbumList();
}