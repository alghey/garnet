package mx.com.garnet.persistence.entities;
//<<<<<<< HEAD
// Generated 23 jul 2019 12:19:15 by Hibernate Tools 5.1.10.Final
//=======
// Generated 23/07/2019 12:10:14 PM by Hibernate Tools 5.1.10.Final
//>>>>>>> master

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DatDueno generated by hbm2java
 */
@Entity
@Table(name = "Dat_Dueno", catalog = "garnet")
public class DatDueno implements java.io.Serializable {

	private Integer idDueno;
	private String nombre;
	private String direccion;
	private String telefono;
	private boolean status;
	private Set<DatPaciente> datPacientes = new HashSet<DatPaciente>(0);

	public DatDueno() {
	}

	public DatDueno(String nombre, String direccion, String telefono, boolean status) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.status = status;
	}

	public DatDueno(String nombre, String direccion, String telefono, boolean status, Set<DatPaciente> datPacientes) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.status = status;
		this.datPacientes = datPacientes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idDueno", unique = true, nullable = false)
	public Integer getIdDueno() {
		return this.idDueno;
	}

	public void setIdDueno(Integer idDueno) {
		this.idDueno = idDueno;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "direccion", nullable = false, length = 150)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono", nullable = false, length = 10)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "datDueno")
	public Set<DatPaciente> getDatPacientes() {
		return this.datPacientes;
	}

	public void setDatPacientes(Set<DatPaciente> datPacientes) {
		this.datPacientes = datPacientes;
	}

}
