package com.example.digishop.base.domain.bo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * SSH
 *
 * @author SunTao
 * @since 2022-11-10
 */
@Data
@AllArgsConstructor
@ApiModel("节点 SSH 信息")
public class Ssh implements Serializable {
	/**
	 * 节点ip
	 */
	@ApiModelProperty("节点ip")
	private String ip;

	/**
	 * 节点端口
	 */
	@ApiModelProperty("节点端口")
	private Integer port;

	/**
	 * ssh用户
	 */
	@ApiModelProperty("ssh用户")
	private String user;

	/**
	 * ssh密码
	 */
	@ApiModelProperty("ssh密码")
	private String password;
}