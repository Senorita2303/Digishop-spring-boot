package com.example.digishop.domain.dto.query;

import com.example.digishop.core.base.PageParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 说说查询
 *
 * @author SunTao
 * @since 2022-12-12
 */
@Getter
@Setter
@ToString
@ApiModel("说说查询参数")
public class TalkQueryDto extends PageParam {
	/**
	 * 当前登录用户
	 */
	@ApiModelProperty(value = "当前登录用户", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
	private String loginUser;

	/**
	 * 说说状态
	 */
	@ApiModelProperty(value = "说说状态，1：公开、2、私密")
	private Integer status;
}