package br.com.thundercoders.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.thundercoders.config.TokenService;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLogin;
import br.com.thundercoders.model.dto.DtoToken;
import br.com.thundercoders.model.dto.DtoUsuario;
import br.com.thundercoders.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@Api(value= "usuario-controller", tags = "Usuário")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	@ApiOperation(value = "cria um novo usuário no banco de dados")
	public ResponseEntity<DtoUsuario> incluirUsuario(@RequestBody @Valid DtoUsuario dtoUsuario,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioService.save(dtoUsuario);
		URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DtoUsuario(usuario));
	}

	@GetMapping("/findByid")
	@ApiOperation(value = "lista os dados do usuário (se ele existir) com base em seu id cadastrado no banco")
	public Usuario buscarUsuario(@ApiParam(value = "id do usuário", example = "1", required = true)  @RequestParam(value = "id", required = true) Integer id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/findAll")
	@ApiOperation(value = "lista os dados de todos os usuários cadastrados no banco")
	public List<Usuario> buscarUsuarios() {
		return usuarioService.findAll();
	}

	@PostMapping("/logar")
	@ApiOperation(value = "realiza a operação de login do usuário selecionado, autenticando seu acesso às requisições restritas")
	public ResponseEntity<DtoToken> logar(@ApiParam(value = "DtoLogin", required = true)  @RequestBody DtoLogin dtoLogin) {
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
