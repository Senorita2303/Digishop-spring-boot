package com.example.digishop.base.domain.dto;

import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户角色
 *
 * @author SunTao
 * @since 2022-09-13
 */
@Data
@ApiModel("用户角色信息")
public class UserRoleDto {
	/**
	 * 角色id
	 */
	@ApiModelProperty("角色id")
	private Long roleId;

	/**
	 * 用户id列表
	 */
	@ApiModelProperty("用户id列表")
	private Set<Long> userIds;
}