package com.example.digishop.base.service;

import com.example.digishop.base.domain.bo.LoginUser;
import com.example.digishop.base.domain.vo.UserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * 部分公共接口
 *
 * @author SunTao
 * @since 2022-07-24
 */
public interface DigishopService {
    /**
     * 清除记住我信息
     *
     * @param username 用户名
     */
    void removeRememberMe(String username);

    /**
     * 检查用户的登录状态
     *
     * @param request 请求信息
     * @return LoginUser
     */
    LoginUser checkUserLoginStatus(HttpServletRequest request);
}