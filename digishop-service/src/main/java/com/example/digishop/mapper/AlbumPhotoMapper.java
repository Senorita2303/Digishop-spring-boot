package com.example.digishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.digishop.core.base.BaseMapper;
import com.example.digishop.domain.dto.query.AlbumPhotoQueryDto;
import com.example.digishop.domain.entity.AlbumPhoto;
import com.example.digishop.domain.vo.AlbumPhotoVo;

/**
 * 照片数据持久层
 *
 * @author SunTao
 * @since 2022-12-15
 */
public interface AlbumPhotoMapper extends BaseMapper<AlbumPhoto> {
	/**
	 * 查询照片列表
	 *
	 * @param queryDto 查询参数
	 * @return PhotoVoList
	 */
	List<AlbumPhotoVo> selectAlbumPhotoList(AlbumPhotoQueryDto queryDto);

	/**
	 * 查询回收站照片列表
	 *
	 * @param queryDto 查询参数
	 * @return PhotoVoList
	 */
	List<AlbumPhotoVo> selectDeletePhotoList(AlbumPhotoQueryDto queryDto);

	/**
	 * 批量插入照片列表
	 *
	 * @param photos 批量插入照片列表
	 */
	void batchInsert(List<AlbumPhoto> photos);

	/**
	 * 删除相册照片
	 *
	 * @param photoIdList 相册照片ID列表
	 */
	void deleteAlbumPhoto(List<Long> photoIdList);

	/**
	 * 移动相册照片
	 *
	 * @param albumId     相册ID
	 * @param photoIdList 相册照片ID列表
	 */
	void moveAlbumPhoto(@Param("albumId") Long albumId, List<Long> photoIdList);

	/**
	 * 恢复相册照片
	 *
	 * @param photoIdList 相册照片信息
	 */
	void recoverAlbumPhoto(List<Long> photoIdList);
}