package com.observability.filter;

import com.observability.entity.TraceId;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String header = request.getHeader("X-Trace-Id");

            TraceId traceId = (header == null || header.isBlank())
                    ? TraceId.generate()
                    : new TraceId(header);

            request.setAttribute("traceId", traceId);

            MDC.put("traceId", traceId.value());

            filterChain.doFilter(request, response);

        } finally {
            MDC.remove("traceId");
        }
    }
}