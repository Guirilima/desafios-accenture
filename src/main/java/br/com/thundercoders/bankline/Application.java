package br.com.thundercoders.bankline;
import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.service.UsuarioService;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Oiee");

        Usuario usuario = new Usuario();
        usuario.setLogin("Guirilima");
        usuario.setNome("Guilherme");
        usuario.setCpf("3434344");
        usuario.setSenha("1234");

        UsuarioRepository repository = new UsuarioRepository();
        repository.incluir(usuario);

        //Buscando usuario pelo login
        usuario = new Usuario();
        usuario = repository.buscar(1);

        //Alterando Dados do Usuario
        usuario.setNome("NOVO NOME");
        repository.alterar(usuario);


        //2 - PARTE DO TESTE
        Usuario usuario2 = new Usuario();
        usuario.setLogin("Guirilima2");
        usuario.setNome("Guilherme2");
        usuario.setCpf("34343");
        usuario.setSenha("4321");

        ///////////////////////
        UsuarioService service = new UsuarioService();
        service.incluir(usuario);

        ///// TESTE COM CONTA
        usuario = new Usuario();
        usuario.setLogin("Guirilima2");
        usuario.setNome("Guilherme2");
        usuario.setCpf("34343");
        usuario.setSenha("4321");

        Conta conta = usuario.getConta();
        conta.setNumero("232323");
        conta.setSaldo(11.1);

        service.incluir(usuario);
    }
}
