package mx.com.garnet.persistence.entities;
// Generated 23/07/2019 12:10:14 PM by Hibernate Tools 5.1.10.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DatConsulta generated by hbm2java
 */
@Entity
@Table(name = "Dat_Consulta", catalog = "garnet")
public class DatConsulta implements java.io.Serializable {

	private Integer idConsulta;
	private DatMedico datMedico;
	private DatPaciente datPaciente;
	private Date fecha;
	private String diagnostico;
	private String tratamiento;
	private BigDecimal costo;

	public DatConsulta() {
	}

	public DatConsulta(DatMedico datMedico, DatPaciente datPaciente, Date fecha, BigDecimal costo) {
		this.datMedico = datMedico;
		this.datPaciente = datPaciente;
		this.fecha = fecha;
		this.costo = costo;
	}

	public DatConsulta(DatMedico datMedico, DatPaciente datPaciente, Date fecha, String diagnostico, String tratamiento,
			BigDecimal costo) {
		this.datMedico = datMedico;
		this.datPaciente = datPaciente;
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.costo = costo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idConsulta", unique = true, nullable = false)
	public Integer getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMedico", nullable = false)
	public DatMedico getDatMedico() {
		return this.datMedico;
	}

	public void setDatMedico(DatMedico datMedico) {
		this.datMedico = datMedico;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPaciente", nullable = false)
	public DatPaciente getDatPaciente() {
		return this.datPaciente;
	}

	public void setDatPaciente(DatPaciente datPaciente) {
		this.datPaciente = datPaciente;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "diagnostico", length = 65535)
	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Column(name = "tratamiento", length = 65535)
	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Column(name = "costo", nullable = false, precision = 16)
	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

}
