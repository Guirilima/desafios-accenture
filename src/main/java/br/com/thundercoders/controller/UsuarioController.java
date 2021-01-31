package br.com.thundercoders.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.thundercoders.config.TokenService;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLogin;
import br.com.thundercoders.model.dto.DtoToken;
import br.com.thundercoders.model.dto.DtoUsuario;
import br.com.thundercoders.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<DtoUsuario> incluirUsuario(@RequestBody @Valid DtoUsuario dtoUsuario,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioService.save(dtoUsuario);
		URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DtoUsuario(usuario));
	}

	@RequestMapping("/findByid")
	public Usuario buscarUsuario(@RequestParam(value = "id", required = true) Integer id) {
		return usuarioService.findById(id);
	}

	@RequestMapping("/findAll")
	public List<Usuario> buscarUsuarios() {
		return usuarioService.findAll();
	}

	@PostMapping("/logar")
	public ResponseEntity<DtoToken> logar(@RequestBody DtoLogin dtoLogin) {
		System.out.println("Testando");
		try {
			
			UsernamePasswordAuthenticationToken dadosLogin = dtoLogin.converte();
			Authentication authentication = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new DtoToken(token, "Bearer"));
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().build();

		}
	}
}
