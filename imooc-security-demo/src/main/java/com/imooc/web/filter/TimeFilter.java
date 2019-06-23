package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timefilter start");
        Long start=new Date().getTime();
        filterChain.doFilter(request,response);
        System.out.println("timefilter :"+(new Date().getTime()-start));
        System.out.println("timefilter finsh");
    }

    @Override
    public void destroy() {

    }
}
