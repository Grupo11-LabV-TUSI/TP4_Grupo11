package entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "especialidad_id")
	private Especialidad especialidad;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Turno> turnos;

	public Medico(String nombre, Usuario usuario, Especialidad especialidad) {
		super();

		this.nombre = nombre;
		this.usuario = usuario;
		this.especialidad = especialidad;

	}

	public Medico() {
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", especialidad=" + especialidad
				+ ", turnos=" + turnos + "]";
	}

}
