package UTNFRGP.TP4_Grupo11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import dao.DaoHibernatePaciente;
import dao.DaoHibernateMedico;
import entidad.Medico;
import entidad.Paciente;
import excepciones.PK_Paciente_Repetida;

/**
 * Hello world!
 *
 */ 
public class App 
{
    public static void main( String[] args )
    {
    	LocalDate fechaLocal = LocalDate.of(2000, 1, 1);
    	java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechaLocal);
	
        Paciente paciente = new Paciente(
				        		12345678,
				        		"pacienteUno",
				        		"apellidoUno",
				        		"paciente1@email.com",
				        		"telefono1",
				        		fechaNacimiento,
				        		"direccion1",
				        		"localidad1",
				        		"provincia1"
				        	);
        try {
        	DaoHibernatePaciente.crear(paciente);
        } catch (PK_Paciente_Repetida e) {
        	e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			paciente.setFecha_nacimiento(fechaNacimiento);
			DaoHibernatePaciente.actualizar(paciente);
			System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
		//	DaoHibernatePaciente.borrar(paciente);
			System.out.println(DaoHibernatePaciente.leerTodos());
		}
        

    }
}

