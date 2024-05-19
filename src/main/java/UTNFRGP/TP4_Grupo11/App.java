package UTNFRGP.TP4_Grupo11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.Date;

import dao.DaoHibernatePaciente;
import dao.DaoHibernateTurno;
import dao.ConfigHibernate;
import dao.DaoHibernateEspecialidad;
import dao.DaoHibernateMedico;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Usuario;
import excepciones.PK_Paciente_Repetida;
import entidad.Turno;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//		LocalDate fechaLocal = LocalDate.of(2000, 1, 2);
//		java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechaLocal);
//
//		Paciente paciente = new Paciente(12345630, "pacientecuatro", 
//				"apellidoCuatro", "paciente4@email.com", "telefono4",
//				fechaNacimiento, "direccion1", "localidad1", "provincia1");
//		try {
//			DaoHibernatePaciente.crear(paciente);
//		} catch (PK_Paciente_Repetida e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			paciente.setFecha_nacimiento(fechaNacimiento);
//			DaoHibernatePaciente.actualizar(paciente);
//			System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
//			// DaoHibernatePaciente.borrar(paciente);
//			System.out.println(DaoHibernatePaciente.leerTodos());
//		}
//		Usuario usuario = new Usuario();
//		usuario.setUsuario("doctor4");
//		usuario.setContrasena("password1");
//
//		Medico medico = new Medico();
//		medico.setNombre("Dr. Juan gris");
//		medico.setUsuario(usuario);
//		usuario.setMedico(medico);
//
//		DaoHibernateMedico.crearMedico(medico);
//
//		Especialidad espe = new Especialidad("Clinico");
//
//		DaoHibernateEspecialidad.crearEspecialidad(espe);
//		
//        Turno turno = new Turno();
//        turno.setMedico(medico);
//        turno.setPaciente(paciente);
//        turno.setFecha(Date.valueOf("2024-06-01"));
//        turno.setHora("10:00");
//        turno.setObservacion("Revisión general");
//        turno.setEstado("pendiente");
//
//        DaoHibernateTurno.crearTurno(turno);
        
        // Listar todos los médicos
        List<Medico> medicos;
		try {
			medicos = DaoHibernateMedico.leerTodos();
			System.out.println("Lista de médicos:");
			for (Medico med : medicos) {
				System.out.println("Nombre del Médico: " + med.getNombre());
				// Agregar más detalles si necesitas
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
