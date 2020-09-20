package com.github.frogwarm.spring.boot.admin.client;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(((HttpServletRequest) servletRequest).getAuthType());
        AuthHttpServletRequestWrapper requestWrapper = new AuthHttpServletRequestWrapper(((HttpServletRequest) servletRequest));
        requestWrapper.addHeader("CRUN-TOKEN", "asdasdaskjdddddddddddddddddddddddasjasdjuas");
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
