package cvx.Aplication.Services;

import cvx.Domain.Reserva;
import cvx.Interfaces.ReservaRepository;

import java.util.List;

public class ReservaService {
    private final ReservaRepository reservaRepository;


    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void registrarReserva(Reserva reserva) {
        reservaRepository.saveReserva(reserva);
    }

    public List<Reserva> listaReservas() {
        return reservaRepository.findAllReservas();
    }

    public void eliminarReserva(int id) {
        reservaRepository.deleteReserva(id);
    }

    public Reserva obtenerReserva(int id) {
        return reservaRepository.findReservaId(id);
    }

    public void actualizarReserva(Reserva reserva) {
        reservaRepository.updateReserva(reserva);
    }
}
