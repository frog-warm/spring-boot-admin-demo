package com.github.frogwarm.spring.boot.admin.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class AuthHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final Map<String, String> headers = new HashMap<>();

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public AuthHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = this.headers.get(name);
        if (headerValue != null) {
            return headerValue;
        }
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        if (this.headers.isEmpty()) {
            return super.getHeaderNames();
        }
        Set<String> set = new HashSet<>(this.headers.keySet());
        // 添加自定义header
        Enumeration<String> e = super.getHeaderNames();
        while (e.hasMoreElements()) {
            String n = e.nextElement();
            set.add(n);
        }
        return Collections.enumeration(set);
    }
}
