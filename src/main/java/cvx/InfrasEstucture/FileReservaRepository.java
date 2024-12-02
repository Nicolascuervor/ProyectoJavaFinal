package cvx.InfrasEstucture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import cvx.Domain.Reserva;
import cvx.Interfaces.ReservaRepository;

import java.util.List;

public class FileReservaRepository implements ReservaRepository {

    private final EntityManagerFactory emf;

    public FileReservaRepository() {
        emf = Persistence.createEntityManagerFactory("ReservaUp");
    }

    @Override
    public void saveReserva(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateReserva(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteReserva(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                em.remove(reserva);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Reserva findReservaId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Reserva> findAllReservas() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Reserva p", Reserva.class)
                    .getResultList();
        }
    }
}
