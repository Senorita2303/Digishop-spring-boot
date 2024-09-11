package com.example.digishop.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digishop.base.service.DigishopService;
import com.example.digishop.captcha.Captcha;
import com.example.digishop.captcha.handler.CaptchaHandler;
import com.example.digishop.core.annotation.ApiVersion;
import com.example.digishop.core.annotation.Router;
import com.example.digishop.core.base.BaseConst;
import com.example.digishop.core.model.Result;
import com.example.digishop.core.util.SecurityUtils;
import com.example.digishop.log.annotation.IgnoredLog;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 认证管理
 *
 * @author SunTao
 * @since 2022-01-15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Api(value = "AuthController", tags = { "认证控制器" })
public class AuthController {
	private final DigishopService digishopService;

	private final CaptchaHandler captchaHandler;

	@Value("${zblog.globalKey.PublicKey}")
	private String globalPublicKey;

	/**
	 * 获取当前登录用户信息
	 *
	 * @return login username
	 */
	@IgnoredLog
	@GetMapping("/loginId")
	@ApiOperation(value = "获取当前登录用户信息")
	@ApiVersion(group = { BaseConst.ApiVersion.V_4_0_0 })
	@Router(name = "获取当前登录用户信息", code = "loginId", level = BaseConst.PermLevel.PUBLIC)
	public Result currentUserDetail() {
		return Result.success().data(SecurityUtils.getLoginUser());
	}

	/**
	 * 获取登录验证码
	 *
	 * @return {img: %二维码的Base64编码%; uuid: %存储二维码的缓存主键%}
	 */
	@GetMapping("/loginCode")
	@ApiOperation(value = "获取登录验证码", notes = "不需要token")
	@ApiVersion(group = { BaseConst.ApiVersion.V_4_0_0 })
	@Router(name = "获取登录验证码", code = "loginCode", level = BaseConst.PermLevel.OPEN)
	public Result loginCode() {
		Map<String, Object> data = new HashMap<>(2);
		Captcha captcha = captchaHandler.createCaptcha("loginCode");
		data.put("img", captcha.getBase64());
		data.put("uuid", captcha.getCaptchaId());
		return Result.success().data(data);
	}

	/**
	 * 检查用户的登录状态
	 *
	 * @param request 请求信息
	 * @return userId
	 */
	@IgnoredLog
	@PostMapping("/checkUserLoginStatus")
	@ApiOperation(value = "检查用户的登录状态")
	@ApiVersion(group = { BaseConst.ApiVersion.V_4_2_0 })
	@Router(name = "检查用户的登录状态", code = "checkUserLoginStatus", level = BaseConst.PermLevel.OPEN)
	public Result checkUserLoginStatus(HttpServletRequest request) {
		return Result.success().data(digishopService.checkUserLoginStatus(request));
	}

	/**
	 * 获取默认公钥
	 *
	 * @return 默认公钥
	 */
	@GetMapping("/queryGlobalKey")
	@ApiOperation(value = "获取默认公钥")
	@ApiVersion(group = { BaseConst.ApiVersion.V_5_0_0 })
	@Router(name = "获取默认公钥", code = "queryGlobalKey", level = BaseConst.PermLevel.PUBLIC)
	public Result queryGlobalKey() {
		return Result.success().data(globalPublicKey);
	}
}