package cvx.InfrasEstucture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import cvx.Domain.Usuario;
import cvx.Interfaces.UsuarioRepository;

import java.util.List;

public class FileUsuarioRepository implements UsuarioRepository {
    private final EntityManagerFactory emf;


    public FileUsuarioRepository(){
        emf = Persistence.createEntityManagerFactory("UsuarioUp");
    }
    
    
    @Override
    public void saveUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteUsuario(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario findUsuarioId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Usuario p", Usuario.class)
                    .getResultList();
        }
    }

}
