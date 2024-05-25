package com.zuriapp.piggybank.application.commons.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class SimpleFilterChain implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain chain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpRequest) {
            String url = httpRequest.getRequestURL().toString();
            log.info("URL being called: {}",  url);
        }

        // Pasar la solicitud al siguiente filtro o servlet en la cadena
        chain.doFilter(servletRequest, servletResponse);
    }
}
