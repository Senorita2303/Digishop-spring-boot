package com.example.digishop.base.component.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.digishop.base.domain.entity.User;
import com.example.digishop.core.enums.ResultCode;
import com.example.digishop.core.model.Result;
import com.example.digishop.core.util.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义登出处理器
 *
 * @author SunTao
 * @since 2022-01-20
 */
@Slf4j
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		if (authentication != null && authentication.getPrincipal() != null) {
			User user = (User) authentication.getPrincipal();
			String username = user.getUsername();
			log.info("用户 {} 注销成功", username);
		}

		Result result = Result.success(ResultCode.LOGOUT_SUCCESS);
		ResponseUtils.responseJsonWriter(response, result);
	}
}