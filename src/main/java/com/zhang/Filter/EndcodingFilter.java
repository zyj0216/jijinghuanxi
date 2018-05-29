package com.zhang.Filter;

import com.sun.net.httpserver.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/17.
 */
@WebFilter(urlPatterns = {"/*"})
public class EndcodingFilter implements javax.servlet.Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤请求、响应中的字符参数，解决中文乱码问题
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
