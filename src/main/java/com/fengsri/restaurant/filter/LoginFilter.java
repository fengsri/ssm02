package com.fengsri.restaurant.filter;

import com.fengsri.restaurant.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fengwen
 * @date 2019/4/8 14:59
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = (User)((HttpServletRequest)servletRequest).getSession().getAttribute("user");
        if(user==null){
            String path =  ((HttpServletRequest)servletRequest).getRequestURI();
            if(path.contains("to_login") || path.contains("to_register") || path.contains("user_register") || path.contains("user_login")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletRequest) servletRequest).getRequestDispatcher(((HttpServletRequest)servletRequest).getContextPath()+"/WEB-INF/jsp/login.jsp").forward(servletRequest, servletResponse);
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
