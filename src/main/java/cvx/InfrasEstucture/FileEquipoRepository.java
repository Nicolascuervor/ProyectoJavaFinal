package cvx.InfrasEstucture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import cvx.Domain.Equipo;
import cvx.Interfaces.EquipoRepository;

import java.util.List;

public class FileEquipoRepository implements EquipoRepository {
    private final EntityManagerFactory emf;
    
    public FileEquipoRepository() {
        emf = Persistence.createEntityManagerFactory("EquipoUp");
    }

    @Override
    public void saveEquipo(Equipo equipo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(equipo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateEquipo(Equipo equipo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(equipo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteEquipo(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Equipo equipo = em.find(Equipo.class, id);
            if (equipo != null) {
                em.remove(equipo);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Equipo findEquipoId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Equipo> findAllEquipos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Equipo p", Equipo.class)
                    .getResultList();
        }
    }

}
