import Utils.ConexaoFactory;
import model.Conta;
import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

import javax.persistence.EntityManager;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Oiee");

        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setLogin("Guirilima");
        usuarioEntity.setNome("Guilherme");
        usuarioEntity.setCpf("3434344");
        usuarioEntity.setSenha("1234");

        UsuarioRepository repository = new UsuarioRepository();
        repository.incluir(usuarioEntity);

        //Buscando usuario pelo login
        usuarioEntity = new Usuario();
        usuarioEntity = repository.buscar(1);

        //Alterando Dados do Usuario
        usuarioEntity.setNome("NOVO NOME");
        repository.alterar(usuarioEntity);


        //2 - PARTE DO TESTE
        Usuario usuarioEntity2 = new Usuario();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        ///////////////////////
        UsuarioService service = new UsuarioService();
        service.incluir(usuarioEntity);





        ///// TESTE COM CONTA
        usuarioEntity = new Usuario();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        Conta conta = usuarioEntity.getConta();
        conta.setNumeroConta("232323");
        conta.setSaldo(11.1);

        service.incluir(usuarioEntity);
    }
}
