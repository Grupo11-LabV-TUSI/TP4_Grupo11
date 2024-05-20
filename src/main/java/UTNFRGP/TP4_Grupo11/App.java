package UTNFRGP.TP4_Grupo11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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


		
		

		
		  // Lista de nombres de especialidades médicas
        List<String> especialidades = Arrays.asList(
            "Cardiología", 
            "Psiquiatría", 
            "Pediatría", 
            "Dermatología", 
            "Ginecología", 
            "Oftalmología", 
            "Neurología", 
            "Ortopedia", 
            "Urología", 
            "Endocrinología"
        );

      
		
		
		// Crear registros para cada especialidad
        for (String nombreEspecialidad : especialidades) {
            Especialidad espe = new Especialidad(nombreEspecialidad);
            DaoHibernateEspecialidad.crearEspecialidad(espe); }
            
		
		//Leo las especialidades desde BD
		List <Especialidad> listaEspecialidades = DaoHibernateEspecialidad.leerTodos();
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
        
        
     
        LocalDate fechaLocal1 = LocalDate.of(2000, 1, 2);
        java.sql.Date fechaNac1 = java.sql.Date.valueOf(fechaLocal1);
        Paciente paciente1 = new Paciente(399547, "Aldo", "Ramirez", "aldoRamirez@gmail.com", "16546545", fechaNac1, "Calle 1", "Benavidez", "BSAS");
        DaoHibernatePaciente.crear(paciente1);

        LocalDate fechaLocal2 = LocalDate.of(1995, 8, 15);
        java.sql.Date fechaNac2 = java.sql.Date.valueOf(fechaLocal2);
        Paciente paciente2 = new Paciente(123456, "María", "González", "mariaGonzalez@gmail.com", "12345678", fechaNac2, "Avenida 2", "La Plata", "BSAS");
        DaoHibernatePaciente.crear(paciente2);

        LocalDate fechaLocal3 = LocalDate.of(1987, 12, 31);
        java.sql.Date fechaNac3 = java.sql.Date.valueOf(fechaLocal3);
        Paciente paciente3 = new Paciente(789012, "Juan", "López", "juanLopez@gmail.com", "98765432", fechaNac3, "Calle 3", "Rosario", "Santa Fe");
        DaoHibernatePaciente.crear(paciente3);
		
        LocalDate fechaLocal4 = LocalDate.of(1998, 5, 20);
        java.sql.Date fechaNac4 = java.sql.Date.valueOf(fechaLocal4);
        Paciente paciente4 = new Paciente(246810, "Lucía", "Martínez", "luciaMartinez@gmail.com", "98765432", fechaNac4, "Calle 4", "Córdoba", "Córdoba");
        DaoHibernatePaciente.crear(paciente4);

        LocalDate fechaLocal5 = LocalDate.of(1980, 9, 10);
        java.sql.Date fechaNac5 = java.sql.Date.valueOf(fechaLocal5);
        Paciente paciente5 = new Paciente(135790, "Carlos", "Gutiérrez", "carlosGutierrez@gmail.com", "54321678", fechaNac5, "Avenida 5", "Mendoza", "Mendoza");
        DaoHibernatePaciente.crear(paciente5);

        LocalDate fechaLocal6 = LocalDate.of(1975, 3, 25);
        java.sql.Date fechaNac6 = java.sql.Date.valueOf(fechaLocal6);
        Paciente paciente6 = new Paciente(112233, "Laura", "Díaz", "lauraDiaz@gmail.com", "12348765", fechaNac6, "Calle 6", "Tucumán", "Tucumán");
        DaoHibernatePaciente.crear(paciente6);

        LocalDate fechaLocal7 = LocalDate.of(1993, 7, 12);
        java.sql.Date fechaNac7 = java.sql.Date.valueOf(fechaLocal7);
        Paciente paciente7 = new Paciente(987654, "Martín", "López", "martinLopez@gmail.com", "87654321", fechaNac7, "Avenida 7", "Salta", "Salta");
        DaoHibernatePaciente.crear(paciente7);

        LocalDate fechaLocal8 = LocalDate.of(1988, 11, 5);
        java.sql.Date fechaNac8 = java.sql.Date.valueOf(fechaLocal8);
        Paciente paciente8 = new Paciente(564738, "Julieta", "Fernández", "julietaFernandez@gmail.com", "65432187", fechaNac8, "Calle 8", "Santa Fe", "Santa Fe");
        DaoHibernatePaciente.crear(paciente8);

        LocalDate fechaLocal9 = LocalDate.of(2002, 2, 28);
        java.sql.Date fechaNac9 = java.sql.Date.valueOf(fechaLocal9);
        Paciente paciente9 = new Paciente(9645654, "Pedro", "Rodríguez", "pedroRodriguez@gmail.com", "36985214", fechaNac9, "Avenida 9", "Neuquén", "Neuquén");
        DaoHibernatePaciente.crear(paciente9);
     
        
        /*
		
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
    /*    List<Medico> medicos;
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
		
		
		
		
		
		
		
		
		
		
		
		
		*/
		
		
		
		
		
		
		
		
	}
		
}
