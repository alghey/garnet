package mx.com.garnet.persistence.entities;

// Generated 23 jul 2019 12:11:17 by Hibernate Tools 5.1.10.Final

// Generated 23/07/2019 12:10:14 PM by Hibernate Tools 5.1.10.Final


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
 * CatEspecialidad generated by hbm2java
 */
@Entity
@Table(name = "Cat_Especialidad", catalog = "garnet")
public class CatEspecialidad implements java.io.Serializable {

	private Integer idEspecialidad;
	private String nombre;
	private Set<DatMedico> datMedicos = new HashSet<DatMedico>(0);

	public CatEspecialidad() {
	}

	public CatEspecialidad(String nombre) {
		this.nombre = nombre;
	}

	public CatEspecialidad(String nombre, Set<DatMedico> datMedicos) {
		this.nombre = nombre;
		this.datMedicos = datMedicos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEspecialidad", unique = true, nullable = false)
	public Integer getIdEspecialidad() {
		return this.idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEspecialidad")
	public Set<DatMedico> getDatMedicos() {
		return this.datMedicos;
	}

	public void setDatMedicos(Set<DatMedico> datMedicos) {
		this.datMedicos = datMedicos;
	}

}
