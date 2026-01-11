package com.katusoft.api.auth;

import com.katusoft.model.authentication.gateways.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final UserDetailsService userDetailsService;

  public JwtAuthenticationFilter(TokenService tokenService, UserDetailsService userDetailsService) {
    this.tokenService = tokenService;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    //Obtener el header de Authorization
    final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    //Verificar si existe y tiene el formato correcto
    if (header == null || !header.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    //Extraer el token del header
    final String token = header.split(" ")[1].trim();

    //Extraer el nombre de usuario del token
    String username = tokenService.extractUsername(token);

    //Verificar que el usurio no esté ya autenticado
    if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      if(tokenService.isTokenValid(token, username)) {
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
            );

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //Establecer la autenticación en el contexto
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);

  }
}
