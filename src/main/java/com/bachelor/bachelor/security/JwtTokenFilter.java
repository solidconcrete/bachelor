package com.bachelor.bachelor.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@RequiredArgsConstructor
@CommonsLog
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtParser jwtParser;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        final String header = request.getHeader("Authorization");

        // validate request header
        if(header.equals("") || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        final String token = header.substring(7);

        // validate token
        try {
            jwtParser.validateToken(token);
        } catch (Exception ExpiredJwtException) {
            log.info(ExpiredJwtException);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        User.UserBuilder builder = User.withUsername(
                jwtParser.getUsernameFromToken(token))
                .authorities(jwtParser.getAuthoritiesFromToken(token))
                .password("");

        UserDetails userDetails = builder.build();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails.getAuthorities());


        authentication
                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}
