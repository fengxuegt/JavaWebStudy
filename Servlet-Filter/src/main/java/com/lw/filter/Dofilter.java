package com.lw.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.do")
public class Dofilter extends HttpFilter {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 请求前添加过滤规则
        System.out.println("do filter before response");
        chain.doFilter(req, res);
        // 请求后添加过滤规则
        System.out.println("do filter after response");
    }

    public void destroy() {
        super.destroy();
    }
}
