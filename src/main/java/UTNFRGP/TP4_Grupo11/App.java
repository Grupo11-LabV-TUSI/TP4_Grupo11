package UTNFRGP.TP4_Grupo11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import java.sql.Date;

import dao.DaoHibernatePaciente;
import dao.DaoHibernateTurno;
import dao.DaoHibernateUsuario;
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

		// Lista de nombres de especialidades médicas
		List<String> especialidades = Arrays.asList("Cardiología", "Psiquiatría", "Pediatría", "Dermatología",
				"Ginecología", "Oftalmología", "Neurología", "Ortopedia", "Urología", "Endocrinología");

		// Crear registros para cada especialidad
		for (String nombreEspecialidad : especialidades) {
			Especialidad espe = new Especialidad(nombreEspecialidad);
			DaoHibernateEspecialidad.crearEspecialidad(espe);
		}

		// Leo las especialidades desde BD
		List<Especialidad> listaEspecialidades = DaoHibernateEspecialidad.leerTodos();
		for (Especialidad espe : listaEspecialidades) {
			System.out.println(espe.toString());
		}

		// Creo instancias de usuarios y médicos
		Usuario user1 = new Usuario("JGarcia", "JG123");
		Medico medico1 = new Medico("Jose Garcia", user1, listaEspecialidades.get(0));
		DaoHibernateMedico.crearMedico(medico1);

		Usuario user2 = new Usuario("JPepe", "JP456");
		Medico medico2 = new Medico("Juan Pepe", user2, listaEspecialidades.get(1));
		DaoHibernateMedico.crearMedico(medico2);

		Usuario user3 = new Usuario("JPerez", "JP789");
		Medico medico3 = new Medico("Juan Perez", user3, listaEspecialidades.get(2));
		DaoHibernateMedico.crearMedico(medico3);

		Usuario user4 = new Usuario("JRamirez", "JR101");
		Medico medico4 = new Medico("Juan Ramirez", user4, listaEspecialidades.get(3));
		DaoHibernateMedico.crearMedico(medico4);

		Usuario user5 = new Usuario("JLopez", "JL112");
		Medico medico5 = new Medico("Juan Lopez", user5, listaEspecialidades.get(4));
		DaoHibernateMedico.crearMedico(medico5);

		Usuario user6 = new Usuario("JMartinez", "JM131");
		Medico medico6 = new Medico("Juan Martinez", user6, listaEspecialidades.get(5));
		DaoHibernateMedico.crearMedico(medico6);

		Usuario user7 = new Usuario("JGomez", "JG141");
		Medico medico7 = new Medico("Juan Gomez", user7, listaEspecialidades.get(5));
		DaoHibernateMedico.crearMedico(medico7);

		Usuario user8 = new Usuario("JSanchez", "JS151");
		Medico medico8 = new Medico("Juan Sanchez", user8, listaEspecialidades.get(6));
		DaoHibernateMedico.crearMedico(medico8);

		Usuario user9 = new Usuario("JFernandez", "JF161");
		Medico medico9 = new Medico("Juan Fernandez", user9, listaEspecialidades.get(7));
		DaoHibernateMedico.crearMedico(medico9);

		Usuario user10 = new Usuario("JRodriguez", "JR171");
		Medico medico10 = new Medico("Juan Rodriguez", user10, listaEspecialidades.get(8));
		DaoHibernateMedico.crearMedico(medico10);

		Usuario user11 = new Usuario("ERanco", "ER976");
		Medico medico11 = new Medico("Elena Ranco", user11, listaEspecialidades.get(8));
		DaoHibernateMedico.crearMedico(medico11);

		Usuario user12 = new Usuario("JShakira", "JS654");
		Medico medico12 = new Medico("Juana Shakira", user12, listaEspecialidades.get(9));
		DaoHibernateMedico.crearMedico(medico12);

		// Creo instancias de pacientes

		LocalDate fechaLocal1 = LocalDate.of(2000, 1, 2);
		java.sql.Date fechaNac1 = java.sql.Date.valueOf(fechaLocal1);
		Paciente paciente1 = new Paciente(399547, "Aldo", "Ramirez", "aldoRamirez@gmail.com", "16546545", fechaNac1,
				"Calle 1", "Benavidez", "BSAS");
		DaoHibernatePaciente.crear(paciente1);

		LocalDate fechaLocal2 = LocalDate.of(1995, 8, 15);
		java.sql.Date fechaNac2 = java.sql.Date.valueOf(fechaLocal2);
		Paciente paciente2 = new Paciente(123456, "María", "González", "mariaGonzalez@gmail.com", "12345678", fechaNac2,
				"Avenida 2", "La Plata", "BSAS");
		DaoHibernatePaciente.crear(paciente2);

		LocalDate fechaLocal3 = LocalDate.of(1987, 12, 31);
		java.sql.Date fechaNac3 = java.sql.Date.valueOf(fechaLocal3);
		Paciente paciente3 = new Paciente(789012, "Juan", "López", "juanLopez@gmail.com", "98765432", fechaNac3,
				"Calle 3", "Rosario", "Santa Fe");
		DaoHibernatePaciente.crear(paciente3);

		LocalDate fechaLocal4 = LocalDate.of(1998, 5, 20);
		java.sql.Date fechaNac4 = java.sql.Date.valueOf(fechaLocal4);
		Paciente paciente4 = new Paciente(246810, "Lucía", "Martínez", "luciaMartinez@gmail.com", "98765432", fechaNac4,
				"Calle 4", "Córdoba", "Córdoba");
		DaoHibernatePaciente.crear(paciente4);

		LocalDate fechaLocal5 = LocalDate.of(1980, 9, 10);
		java.sql.Date fechaNac5 = java.sql.Date.valueOf(fechaLocal5);
		Paciente paciente5 = new Paciente(135790, "Carlos", "Gutiérrez", "carlosGutierrez@gmail.com", "54321678",
				fechaNac5, "Avenida 5", "Mendoza", "Mendoza");
		DaoHibernatePaciente.crear(paciente5);

		LocalDate fechaLocal6 = LocalDate.of(1975, 3, 25);
		java.sql.Date fechaNac6 = java.sql.Date.valueOf(fechaLocal6);
		Paciente paciente6 = new Paciente(112233, "Laura", "Díaz", "lauraDiaz@gmail.com", "12348765", fechaNac6,
				"Calle 6", "Tucumán", "Tucumán");
		DaoHibernatePaciente.crear(paciente6);

		LocalDate fechaLocal7 = LocalDate.of(1993, 7, 12);
		java.sql.Date fechaNac7 = java.sql.Date.valueOf(fechaLocal7);
		Paciente paciente7 = new Paciente(987654, "Martín", "López", "martinLopez@gmail.com", "87654321", fechaNac7,
				"Avenida 7", "Salta", "Salta");
		DaoHibernatePaciente.crear(paciente7);

		LocalDate fechaLocal8 = LocalDate.of(1988, 11, 5);
		java.sql.Date fechaNac8 = java.sql.Date.valueOf(fechaLocal8);
		Paciente paciente8 = new Paciente(564738, "Julieta", "Fernández", "julietaFernandez@gmail.com", "65432187",
				fechaNac8, "Calle 8", "Santa Fe", "Santa Fe");
		DaoHibernatePaciente.crear(paciente8);

		LocalDate fechaLocal9 = LocalDate.of(2002, 2, 28);
		java.sql.Date fechaNac9 = java.sql.Date.valueOf(fechaLocal9);
		Paciente paciente9 = new Paciente(9645654, "Pedro", "Rodríguez", "pedroRodriguez@gmail.com", "36985214",
				fechaNac9, "Avenida 9", "Neuquén", "Neuquén");
		DaoHibernatePaciente.crear(paciente9);

		/// Creo instancias de turno

		LocalDate fechaTurno1 = LocalDate.of(2024, 12, 12);
		java.sql.Date fTurno = java.sql.Date.valueOf(fechaTurno1);

		Turno turno1 = new Turno(paciente1, medico1, fTurno, "15:30", "Reuma", "Ausente");
		DaoHibernateTurno.crearTurno(turno1);

		LocalDate fechaTurno2 = LocalDate.of(2024, 6, 1);
		java.sql.Date fTurno2 = java.sql.Date.valueOf(fechaTurno2);

		Turno turno2 = new Turno(paciente2, medico2, fTurno2, "20:30", "Tiene piojos", "Pendiente");
		DaoHibernateTurno.crearTurno(turno2);

		LocalDate fechaTurno3 = LocalDate.of(2022, 3, 21);
		java.sql.Date fTurno3 = java.sql.Date.valueOf(fechaTurno3);

		Turno turno3 = new Turno(paciente3, medico3, fTurno3, "10:45", "Fiebre", "Ausente");
		DaoHibernateTurno.crearTurno(turno3);

		LocalDate fechaTurno4 = LocalDate.of(2023, 7, 15);
		java.sql.Date fTurno4 = java.sql.Date.valueOf(fechaTurno4);

		Turno turno4 = new Turno(paciente4, medico4, fTurno4, "08:00", "Dolor de cabeza", "Presente");
		DaoHibernateTurno.crearTurno(turno4);

		LocalDate fechaTurno5 = LocalDate.of(2023, 9, 30);
		java.sql.Date fTurno5 = java.sql.Date.valueOf(fechaTurno5);

		Turno turno5 = new Turno(paciente5, medico5, fTurno5, "14:30", "Gripe", "Pendiente");
		DaoHibernateTurno.crearTurno(turno5);

		LocalDate fechaTurno6 = LocalDate.of(2024, 2, 10);
		java.sql.Date fTurno6 = java.sql.Date.valueOf(fechaTurno6);

		Turno turno6 = new Turno(paciente6, medico6, fTurno6, "11:00", "Dolor de garganta", "Presente");
		DaoHibernateTurno.crearTurno(turno6);

		LocalDate fechaTurno7 = LocalDate.of(2024, 4, 5);
		java.sql.Date fTurno7 = java.sql.Date.valueOf(fechaTurno7);

		Turno turno7 = new Turno(paciente7, medico7, fTurno7, "09:45", "Resfriado", "Ausente");
		DaoHibernateTurno.crearTurno(turno7);

		LocalDate fechaTurno8 = LocalDate.of(2024, 8, 20);
		java.sql.Date fTurno8 = java.sql.Date.valueOf(fechaTurno8);

		Turno turno8 = new Turno(paciente8, medico8, fTurno8, "17:20", "Alergia", "Pendiente");
		DaoHibernateTurno.crearTurno(turno8);

		LocalDate fechaTurno9 = LocalDate.of(2024, 10, 12);
		java.sql.Date fTurno9 = java.sql.Date.valueOf(fechaTurno9);

		Turno turno9 = new Turno(paciente3, medico9, fTurno9, "13:00", "Control de rutina", "Presente");
		DaoHibernateTurno.crearTurno(turno9);

		LocalDate fechaTurno10 = LocalDate.of(2024, 11, 28);
		java.sql.Date fTurno10 = java.sql.Date.valueOf(fechaTurno10);

		Turno turno10 = new Turno(paciente8, medico10, fTurno10, "16:40", "Presión alta", "Ausente");
		DaoHibernateTurno.crearTurno(turno10);

		LocalDate fechaTurno11 = LocalDate.of(2025, 1, 5);
		java.sql.Date fTurno11 = java.sql.Date.valueOf(fechaTurno11);

		Turno turno11 = new Turno(paciente8, medico11, fTurno11, "18:30", "Dolor de espalda", "Pendiente");
		DaoHibernateTurno.crearTurno(turno11);
		Usuario usuarios = new Usuario();
// punto 2 
		List<Usuario> users = DaoHibernateUsuario.leerTodos();
		List<Medico> medicos = DaoHibernateMedico.leerTodos();
		long medTest = 3;
		LocalDate fechaTurnoTest = LocalDate.of(2025, 5, 11);
		java.sql.Date fTurnoTest = java.sql.Date.valueOf(fechaTurnoTest);

		// Obtener paciente y médico por sus respectivos IDs
		Paciente paciente = DaoHibernatePaciente.leer(399547);
		Medico med = DaoHibernateMedico.obtenerMedicoPorId(medTest);

		// Verificar si el paciente y el médico existen antes de crear el turno
		if (paciente != null && med != null) {
			Turno turno = new Turno(paciente, med, fTurnoTest, "10:00", "Consulta de rutina", "Pendiente");
			DaoHibernateTurno.crearTurno(turno);

			// Actualizar la observación del turno
			turno.setObservacion("Dolor de estomago");
			DaoHibernateTurno.actualizarTurno(turno);

			// Listar todos los médicos y sus usuarios asociados
			for (Medico lmed : medicos) {
				Usuario user = lmed.getUsuario();
				System.out.println("Medico: " + lmed.getNombre() + ", Usuario: " + user.getUsuario());
			}

			// Borrar un turno por su ID
			long idTurno = 2;
			Turno dturno = DaoHibernateTurno.obtenerTurnoPorId(idTurno);

			if (dturno != null) {
				if (dturno.getId() != null) {
					dturno.setMedico(null);
					dturno.setPaciente(null);

					DaoHibernateTurno.borrarTurno(dturno.getId());
					System.out.println("El turno ha sido eliminado con éxito.");
				} else {
					System.out.println("El turno ya ha sido eliminado.");
				}
			} else {
				System.out.println("El turno no existe.");
			}

			List<Turno> turnos = DaoHibernateTurno.leerTodos();
			for (Turno listTurno : turnos) {
				System.out.println("Turno observacion: " + listTurno.getObservacion() + ", Medico: "
						+ listTurno.getMedico().getNombre() + ", Paciente: " + listTurno.getPaciente().getApellido());
			}
		}

	}
}
