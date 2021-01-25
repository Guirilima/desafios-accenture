package br.com.thundercoders.bankline;
import javax.persistence.EntityManager;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.service.UsuarioService;
import br.com.thundercoders.utils.ConexaoFactory;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("Oiee");
        EntityManager em = ConexaoFactory.getConexao();

        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setLogin("Guirilima");
        usuarioEntity.setNome("Guilherme");
        usuarioEntity.setCpf("3434344");
        usuarioEntity.setSenha("1234");

        UsuarioRepository repository = new UsuarioRepository(em);
        repository.save(usuarioEntity);

        //Buscando usuario pelo login
        usuarioEntity = new Usuario();
        usuarioEntity = repository.findById(1);

        //Alterando Dados do Usuario
        usuarioEntity.setNome("NOVO NOME");
        repository.update(usuarioEntity);


        //2 - PARTE DO TESTE
        Usuario usuarioEntity2 = new Usuario();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        ///////////////////////
        UsuarioService service = new UsuarioService(repository);
        service.save(usuarioEntity);





        ///// TESTE COM CONTA
        usuarioEntity = new Usuario();
        usuarioEntity.setLogin("Guirilima2");
        usuarioEntity.setNome("Guilherme2");
        usuarioEntity.setCpf("34343");
        usuarioEntity.setSenha("4321");

        Conta conta = usuarioEntity.getConta();
        conta.setNumeroConta("232323");
        conta.setSaldo(11.1);

        service.save(usuarioEntity);
    }
}
