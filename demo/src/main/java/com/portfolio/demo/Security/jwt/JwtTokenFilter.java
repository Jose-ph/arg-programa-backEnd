/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Security.jwt;

import com.portfolio.demo.Security.Service.UserDetailsImplements;
import java.io.IOException;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author jose_
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Autowired
    JwtProvider jwtprovider;

    @Autowired
    UserDetailsImplements userdetailsImplements;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            String token = getToken(request);
            if (token != null && jwtprovider.validateToken(token)) {

                String nombreUsuario = jwtprovider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userdetailsImplements.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);

            }

        } catch (Exception e) {

            logger.error("Fallò el mètodo doFIlterInternal");
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
    String header = request.getHeader("Authorization");
    
    if(header != null && header.startsWith("Bearer")){
    return header.replace("Bearer", "");
    }
    return null;
    }
}
