package dao;

import java.util.List;

import entidad.Turno;

public interface IHibernateTurnoDao {
    void crearTurno(Turno turno);
    Turno obtenerTurnoPorId(Long id);
    void actualizarTurno(Turno turno);
    void borrarTurno(Long id);
    List<Turno> leerTodos();
}
