package repository;

import Utils.ConexaoFactory;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class UsuarioRepository {
    private EntityManager em = null;

    public UsuarioRepository() {
        this.em = ConexaoFactory.getConexao();
    }

    public Usuario buscar(Integer id) {
        return em.find(Usuario.class, id);
    }

    public boolean exists(String login) {
        Query query = em.createQuery("SELECT tu FROM UsuarioEntity tu WHERE tu.login = :login"); //JPQL
        query.setParameter("login",login);
        return query.getResultList().size() != 0 ;
    }

    public Usuario buscarByLogin(String login) {
        Query query = em.createQuery("SELECT tu FROM UsuarioEntity tu WHERE tu.login = :login"); //JPQL
        query.setParameter("login",login);

        Usuario usuarioEntity = null;
        try {
            usuarioEntity = (Usuario) query.getSingleResult();
        }catch (NoResultException | NonUniqueResultException nre) {
            //usuarioEntity = null; // Irrelevante, pois ele já é null . . .
        }
        return usuarioEntity;
    }

    public void incluir(Usuario usuarioEntity) {

        em.getTransaction().begin();
        em.persist(usuarioEntity);
        em.getTransaction().commit();
    }

    public void alterar(Usuario usuarioEntity) {

        em.getTransaction().begin();
        em.merge(usuarioEntity); //Irá alterar um único objeto
        em.getTransaction().commit();
    }
}
