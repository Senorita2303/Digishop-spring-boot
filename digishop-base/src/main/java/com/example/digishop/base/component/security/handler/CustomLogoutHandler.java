package com.example.digishop.base.component.security.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import com.example.digishop.base.component.security.jwt.storage.JwtTokenStorage;
import com.example.digishop.base.domain.entity.User;
import com.example.digishop.base.service.DigishopService;
import com.example.digishop.base.service.UserService;
import com.example.digishop.base.util.Constants;
import com.example.digishop.cache.util.GlobalCacheHelper;
import com.example.digishop.util.net.IpUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义登出处理器
 *
 * @author SunTao
 * @since 2022-01-20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {
	private final DigishopService digishopService;

	private final UserService userService;

	private final JwtTokenStorage jwtTokenStorage;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if (authentication != null && authentication.getPrincipal() != null) {
			User user = (User) authentication.getPrincipal();
			String username = user.getUsername();
			log.info("用户 {} 正在注销...", username);

			// 注销 token
			jwtTokenStorage.expire(user.getId());
			userService.clearUserStorageToken(user.getId());
			GlobalCacheHelper
					.remove(Constants.CacheKey.preTkn.cacheKey().concat(":").concat(String.valueOf(user.getId())));

			// 清除统一登陆的用户信息
			String ip = IpUtils.getIp(request);
			GlobalCacheHelper.remove(Constants.CacheKey.ssoTkn.cacheKey().concat(":").concat(ip));

			// 清除 RememberMe
			digishopService.removeRememberMe(username);
		}
	}
}