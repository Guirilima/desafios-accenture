package br.com.thundercoders.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.service.UsuarioService;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";

	private TokenService tokenService;

	private UsuarioService usuarioService;

	public JWTAuthorizationFilter(TokenService tokenService, UsuarioService jpaUserDetailService) {
		this.tokenService = tokenService;
		this.usuarioService = jpaUserDetailService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperaToken(request);
		
		if (tokenService.isTokenValid(token)) {
			System.out.println("Token valido");
			autenticaUsuario(token);
		}
		filterChain.doFilter(request, response);

	}

	private String recuperaToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER);
		
		if (jwtToken != null && !jwtToken.isEmpty() && jwtToken.startsWith("Bearer ")) {
			System.out.println("Retornou token");
			return jwtToken.replace(PREFIX, "");
		}
		return null;
	}

	private void autenticaUsuario(String token) {
		Integer idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioService.findById(idUsuario);
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null,
				usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

}
