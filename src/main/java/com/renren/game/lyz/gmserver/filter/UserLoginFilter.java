/**
 * $Id: UserLoginFilter.java 17239 2013-09-24 08:22:38Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.renren.game.lyz.gmserver.utils.UserUtils;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-9-23 下午06:36:53
 * @since 1.0
 */
public class UserLoginFilter implements Filter {
    private static String excludePattern = null;

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        if (isExcludePath(request.getRequestURI())) {
            arg2.doFilter(req, resp);
            return;
        }
        
        if (UserUtils.getCurrentUser(request.getSession()) == null) {
            response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/login");
        }
        else {
            arg2.doFilter(req, resp);
        }
        
    }
    
    public boolean isExcludePath(String requestPath) {
        return excludePattern == null || Pattern.matches(excludePattern, requestPath);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        String excludePath = arg0.getInitParameter("excludePath");
        if (!StringUtils.isEmpty(excludePath)) {
            excludePattern = excludePath;
        }
    }

    public static void main(String[] args) {
        System.out.println(Pattern.matches("(.*/login)|(.*/resources/.*)", "/x/resour3ces/css/bootstrap.css"));
    }
}
