package com.tvmaze_task.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {
    @Value("${api.key}")
    private String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Get the API key and secret from request headers
        String authorizationHeader = request.getHeader("Authorization");
        if(requiresAuthorization(request)) {

            // Validate the key and secret
            if (isValidApiKey(authorizationHeader)) {
                // Continue processing the request
                filterChain.doFilter(request, response);
            }
            else if(authorizationHeader != null ){
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.getWriter().write("403: Forbidden Access.");
            }
            else {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("401: Unauthorized Access");
            }
        }
        else{
            filterChain.doFilter(request, response);
        }
    }

    private boolean requiresAuthorization(HttpServletRequest request) {
        // Implement logic to determine if the request requires authorization
        String path = request.getRequestURI();
        return (path.startsWith("/episode/") || path.startsWith("/show/")) ; // Adjust this based on your requirements
    }

    private boolean isValidApiKey(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String header_key = authorizationHeader.substring(7); // Extracting the API key
            return apiKey.equals(header_key);
        }
        return false;
    }
}