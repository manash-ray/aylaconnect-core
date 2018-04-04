package com.ayla.rest;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.filter.OncePerRequestFilter;


public class Html5ModeUrlSupportFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {
        if (isStatic(request) || isApi(request)) {
            filterChain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private boolean isApi(HttpServletRequest request) {
        return request.getRequestURI().indexOf("/aylaconnectcore/") >= 0;
    }

    private boolean isStatic(HttpServletRequest request) {
        return Pattern.matches(".+\\.((html)|(css)|(js)|(jpg)|(png)|(jpeg))$", request.getRequestURI());
    }
}