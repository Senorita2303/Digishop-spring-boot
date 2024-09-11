package com.example.digishop.base.domain.bo;

import java.util.List;

import com.example.digishop.base.domain.entity.Interface;
import com.example.digishop.base.domain.entity.Router;

import lombok.Data;

/**
 * 路由 - 接口信息封装
 *
 * @author SunTao
 * @since 2022-06-23
 */
@Data
public class RouterInterface {
	/**
	 * 路由列表
	 */
	List<Router> routers;

	/**
	 * 受权限管控的接口列表
	 */
	List<Interface> permInterfaces;

	/**
	 * 不可以访问的接口列表
	 */
	List<Interface> nullInterfaces;
}