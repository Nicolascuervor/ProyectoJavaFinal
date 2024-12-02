package cvx.Interfaces;

import cvx.Domain.Equipo;

import java.util.List;

public interface EquipoRepository {

    void saveEquipo(Equipo equipo);
    void deleteEquipo(int id);
    void updateEquipo(Equipo equipo);

    Equipo findEquipoId(int id);

    List<Equipo> findAllEquipos();
}
