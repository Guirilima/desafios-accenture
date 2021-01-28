package br.com.thundercoders.controller;

import br.com.thundercoders.model.Usuario;

public class MessageServiceForTest {

    public static Usuario getCPF() {
        Usuario usuario = new Usuario();
        usuario.setCpf("45029380841");
        return usuario;
    }

    public static Usuario getApelido() {
        Usuario usuario = new Usuario();
        usuario.setNome("Guilherme");
        return usuario;
    }
}
