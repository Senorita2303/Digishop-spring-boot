package com.example.digishop.domain.vo;

import java.util.List;

import com.example.digishop.core.base.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 照片页面展示信息
 *
 * @author SunTao
 * @since 2022-12-15
 */
@Getter
@Setter
public class PortalAlbumPhotoVo extends BaseVo {
	/**
	 * 相册名称
	 */
	private String photoAlbumName;

	/**
	 * 相册作者
	 */
	private String photoAlbumAuthor;

	/**
	 * 相册封面
	 */
	private String photoAlbumCover;

	/**
	 * 照片列表
	 */
	List<AlbumPhotoVo> list;
}