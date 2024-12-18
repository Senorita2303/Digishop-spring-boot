package com.example.digishop.base.component.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.digishop.base.component.security.filter.CustomRememberMeFilter;
import com.example.digishop.base.component.security.jwt.JwtTokenGenerator;
import com.example.digishop.base.domain.entity.User;
import com.example.digishop.base.domain.entity.UserTokenStorage;
import com.example.digishop.base.service.UserService;
import com.example.digishop.base.util.Constants;
import com.example.digishop.cache.util.GlobalCacheHelper;
import com.example.digishop.core.model.Result;
import com.example.digishop.core.util.ResponseUtils;
import com.example.digishop.util.net.IpUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CustomAuthenticationSuccessHandler
 *
 * @author SunTao
 * @since 2020-11-15
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private final JwtTokenGenerator jwtTokenGenerator;

	private final UserService userService;

	/**
	 * Called when a user has been successfully authenticated.
	 *
	 * @param request        the request which caused the successful authentication
	 * @param response       the response
	 * @param authentication the <tt>Authentication</tt> object which was created
	 *                       during
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		// get user
		User user = (User) authentication.getPrincipal();

		// generate token
		int tokenVersion = 1;
		String token = jwtTokenGenerator.generateToken(request, user, tokenVersion, null);

		// storage token
		Long userId = user.getId();
		UserTokenStorage tokenStorage = UserTokenStorage.builder().userId(userId).lastedToken(token)
				.version(tokenVersion).build();
		userService.storageUserToken(tokenStorage, 1);

		// sso token
		Constants.CacheKey ssoTkn = Constants.CacheKey.ssoTkn;
		GlobalCacheHelper.put(ssoTkn.cacheKey().concat(":").concat(IpUtils.getIp(request)), token, ssoTkn.duration());

		// set login time
		userService.updateUserLoginInfo(request, userId);

		// remember me
		Boolean fromRememberMe = (Boolean) request.getAttribute(CustomRememberMeFilter.FROM_REMEMBER_ME);
		if (fromRememberMe != null && fromRememberMe) {
			log.info("user {} login with remember me", user.getUsername());
		}

		// return
		Map<String, Object> data = new HashMap<>(2);
		data.put("access_token", Constants.AUTHENTICATION_PREFIX.concat(token));
		data.put("change_pwd", user.getChangePwd());
		ResponseUtils.responseJsonWriter(response, Result.success("登录成功").data(data));
	}
}