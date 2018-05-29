package com.zhang.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/17.
 */
//@WebFilter(urlPatterns = {"/*"})
public class permissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;//HttpServletRequest是servletRequest的父接口，这是强制的父类转子类；
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String requrl = req.getRequestURI();//获取请求的路径；
        //放过去
        if (requrl.endsWith("Login.jsp")||requrl.endsWith("check_code.jpg")//endsWith给静态资源url加上时间戳，防止文件缓存，利与开发调试；
            ||requrl.endsWith("logining.do")||requrl.endsWith(".css")
                ||requrl.endsWith(".js")||requrl.endsWith(".jpg")){//第一次登录的时候，要把登录页面，登录的servlet以及验证码和样式放过去，不然第一次登录就被拦截，连登录页面都无法显示。
            filterChain.doFilter(req,resp);//拦截链接，传给下一个过滤器，完成对请求和回应的过滤，防止中文乱码;
            return;
        }

        //过滤非法用户
        if (null==session.getAttribute("user")){
            resp.setHeader("Cache-Control", "no-store");
            resp.setDateHeader("Expires",0);
            resp.setHeader("Prama", "no-cache");
            resp.sendRedirect(req.getContextPath()+"Login.jsp");//当有非法用户登陆的时候，就是不是通过用户名和密码登录，是企图直接输入路径达到登录的目的的时候，
                                                                    //此代码的结果会拦截住，然后重定向将登录页面发送给浏览器端，使用户通过登录页面输入用户名和密码完成登录。
            return;
        }else {
            filterChain.doFilter(req,resp);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
