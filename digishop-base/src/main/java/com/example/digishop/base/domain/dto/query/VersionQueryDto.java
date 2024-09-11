package com.example.digishop.base.domain.dto.query;

import com.example.digishop.core.base.PageParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 版本查询
 *
 * @author SunTao
 * @since 2022-10-14
 */
@Getter
@Setter
@ToString
@ApiModel("版本查询参数")
public class VersionQueryDto extends PageParam {
	/**
	 * 版本名称
	 */
	@ApiModelProperty(value = "版本名称", notes = "模糊查询")
	private String versionName;

	/**
	 * 版本描述
	 */
	@ApiModelProperty(value = "版本描述", notes = "模糊查询")
	private String updateContent;
}