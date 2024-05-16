package entidad;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable {
	// Implementar serializable
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="dni")
	private int dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String emial;
	
	@Column(name="telefono")
	private String telefono;

	@Column(name="fecha_nacimiento",  columnDefinition = "DATE")
	private Date fecha_nacimiento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia")
	private String provincia;
	
	// Constructor vacio requerido por Hibernate
	public Paciente() {}

	public Paciente(int dni, String nombre, String apellido, String emial, String telefono, Date fecha_nacimiento,
			String direccion, String localidad, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.emial = emial;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	// Geters y Seters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", emial=" + emial
				+ ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}

}
