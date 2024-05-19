package dao;

import entidad.Medico;

public interface IHibernateMedicoDao {
    void crearMedico(Medico medico);
    Medico obtenerMedicoPorId(Long id);
    void actualizarMedico(Medico medico);
    void borrarMedico(Long id);
    void leerTodos();
}
