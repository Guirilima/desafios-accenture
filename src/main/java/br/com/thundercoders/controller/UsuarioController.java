package br.com.thundercoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public void incluirUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioService.incluir(usuario);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/findByid")
	public Usuario buscarUsuario(@RequestParam (value="id", required=true) Integer id) {
		return usuarioService.findById(id);
	}
	
	@RequestMapping("/findAll")
	public List<Usuario> buscarUsuarios() {
		return usuarioService.findAll();
	}
}
