package com.kedacom.kedabootdo.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedacom.web.ResultMessage;

/**
 * 用户登录控制的controller
 * @author chenghogntao
 * created on 2016年5月10日
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    @Qualifier(value = "sas")
    private SessionAuthenticationStrategy sessionStrategy;// = new NullAuthenticatedSessionStrategy();

    /**
     * 尝试个数
     */
    private static final String TRY_MAX_COUNT = "tryMaxCount";
    /**
     * 最大尝试个数
     */
    private final int maxTryCount = 5;
    /**
     * 保存用户姓名的key
     */
    private static final String LAST_USERNAME = "SPRING_SECURITY_LAST_USERNAME";

    /**
     * 用户登录认证
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @throws java.io.IOException
     */
    @SuppressWarnings("finally")
    @RequestMapping("login.do")
    @ResponseBody
    public ResultMessage login(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        ResultMessage r = new ResultMessage();
        boolean error = false;
        HttpSession session;
        Integer tryCount;
        try {
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名密码为空!");
                r.setResult(0);
                r.setMessage("用户名密码为空!");
                return r;
            }
            // 通过userName去拿用户表(sys_user)获取用户信息,用户表相关的SQL位于SysUser.map.xml文件中
            // spring security 相关信息加密保存处理,将用户认证信息放入SecurityContext
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    password);
            authRequest.setDetails(new WebAuthenticationDetails(request));

            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication auth = this.authenticationManager.authenticate(authRequest);
            securityContext.setAuthentication(auth);
            request.getSession().setAttribute(this.LAST_USERNAME, username);
            this.sessionStrategy.onAuthentication(auth, request, response);
        } catch (BadCredentialsException e) {
        	logger.error("BadCredentialsException",e);
            request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名密码输入错误!");
            r = new ResultMessage(0, "用户名密码为空!");
        } catch (LockedException e) {
        	logger.error("LockedException",e);
            request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, username + ":用户被锁定!");
            error = true;
            r.setResult(0);
        } catch (DisabledException e) {
        	logger.error("DisabledException",e);
            request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, username + ":用户被禁用!");
            error = true;
            r.setResult(0);
        } finally {
            if (error) {
                session = request.getSession();
                tryCount = (Integer) session.getAttribute(TRY_MAX_COUNT);
                if (tryCount == null) {
                    session.setAttribute(TRY_MAX_COUNT, Integer.valueOf(1));
                } else {
                    if (tryCount.intValue() < maxTryCount) {
                        session.setAttribute(TRY_MAX_COUNT, Integer.valueOf(tryCount.intValue() + 1));
                    }
                }
            }
            response.sendRedirect(request.getContextPath() + "/platform/console/main.do");
        }
        return r;
    }
}
