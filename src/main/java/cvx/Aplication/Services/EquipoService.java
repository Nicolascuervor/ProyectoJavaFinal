package cvx.Aplication.Services;

import cvx.Domain.Equipo;
import cvx.Interfaces.EquipoRepository;

import java.util.List;

public class EquipoService {

    private final EquipoRepository equipoRepository;


    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public void registrarEquipo(Equipo equipo) {
        equipoRepository.saveEquipo(equipo);
    }

    public List<Equipo> listaEquipos() {
        return equipoRepository.findAllEquipos();
    }

    public void eliminarEquipo(int id) {
        equipoRepository.deleteEquipo(id);
    }

    public Equipo obtenerEquipo(int id) {
        return equipoRepository.findEquipoId(id);
    }

    public void actualizarEquipo(Equipo equipo) {
        equipoRepository.updateEquipo(equipo);
    }
}
