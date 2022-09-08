package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String authHeader = req.getHeader("authorization");

        if("OPTIONS".equals(req.getMethod())){

            res.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);

        }else {

            try {
                String token = authHeader.split(" ")[1];

                System.out.println(authHeader);
                System.out.println(token);
                Claims claims = Jwts.parser()
                        .setSigningKey("ustglobal")
                        .parseClaimsJws(token)
                        .getBody();
                System.out.println(claims.getSubject());
                request.setAttribute("claims",claims);
                chain.doFilter(request, response);


            }catch(Exception e) {
                System.out.println("JobSeeker access denied");
            }
        }
    }
}
