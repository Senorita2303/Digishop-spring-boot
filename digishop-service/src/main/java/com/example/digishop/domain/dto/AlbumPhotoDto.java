package com.example.digishop.domain.dto;

import java.util.List;

import com.example.digishop.base.domain.entity.File;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 相册照片信息
 *
 * @author SunTao
 * @since 2022-12-24
 */
@Getter
@Setter
@ToString
@ApiModel("相册照片信息")
public class AlbumPhotoDto {
	/**
	 * 相册id
	 */
	@ApiModelProperty("相册id")
	private Long albumId;

	/**
	 * 照片列表
	 */
	@ApiModelProperty("照片列表")
	private List<File> photoList;

	/**
	 * 照片id列表
	 */
	@ApiModelProperty("照片id列表")
	private List<Long> photoIdList;
}