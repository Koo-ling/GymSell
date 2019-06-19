package com.ecut.gymonlineshopping.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Selune
 * @Date: 2019/6/18 16:48
 */

public class SessionInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("/users/login".equals(request.getRequestURI()) || "/users/loginForm".equals(request.getRequestURI())) {
            return true;
        }
        Object object = request.getSession().getAttribute("user");
        if (null == object) {
            response.sendRedirect("/users/loginForm");
            return false;
        }
        return true;
    }
}
