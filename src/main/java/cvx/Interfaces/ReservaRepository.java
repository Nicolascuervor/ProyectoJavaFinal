package cvx.Interfaces;

import cvx.Domain.Reserva;

import java.util.List;

public interface ReservaRepository {

    void saveReserva(Reserva reserva);
    void deleteReserva(int id);
    void updateReserva(Reserva reserva);

    Reserva findReservaId(int id);
    List<Reserva> findAllReservas();
}
