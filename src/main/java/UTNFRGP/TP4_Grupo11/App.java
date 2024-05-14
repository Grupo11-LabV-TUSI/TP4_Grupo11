package UTNFRGP.TP4_Grupo11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.DaoHibernatePaciente;
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
        System.out.println( "Hello World!" );
        Paciente paciente = new Paciente(
				        		12345678,
				        		"pacienteUno",
				        		"apellidoUno",
				        		"paciente1@email.com",
				        		"telefono1",
				        		LocalDate.of(1900,1,1),
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
			paciente.setFecha_nacimiento(LocalDate.of(2000, 1, 1));
			DaoHibernatePaciente.actualizar(paciente);
			System.out.println(DaoHibernatePaciente.leer(paciente.getDni()));
			DaoHibernatePaciente.borrar(paciente);
			System.out.println(DaoHibernatePaciente.leerTodos());
		}
    }
}
