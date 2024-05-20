package entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

	private static final long serialVersionUID = 1L;

	// Medico, Paciente, fecha, hora, observación, estado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dni", nullable = false)
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id", nullable = false)
	private Medico medico;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "hora", nullable = false)
	private String hora;

	@Column(name = "observacion", nullable = false)
	private String observacion;

	@Column(name = "estado", nullable = false)
	private String estado;

	public Turno() {
	}
	
	
	
	

	public Turno(Paciente paciente, Medico medico, Date fecha, String hora, String observacion,
			String estado) {
		
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estado = estado;
	}





	public Long getId() {
		return id;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
