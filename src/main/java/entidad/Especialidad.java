package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Especialidad implements Serializable{



private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int especialidad_id;
@Column(name= "Nombre_Especialidad", nullable = false, unique = true)
private String nombre;


public Especialidad () {}

public Especialidad (String nombre) {
	
	
	this.nombre = nombre;
	
}


public int getId() {
	return especialidad_id;
}


public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}






}
