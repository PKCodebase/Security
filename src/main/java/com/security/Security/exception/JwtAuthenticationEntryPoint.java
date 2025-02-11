//package com.security.Security.exception;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        logger.error("Unauthorized access: {}", authException.getMessage());  // Log the error
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json");
//        response.getWriter().write("{\"error\": \"Unauthorized - Please login first\"}");
//    }
//}
