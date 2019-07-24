package mx.com.garnet.common.pacientes.vo;

import java.util.Date;

public class PacienteVo {
    private Integer idPaciente;
   private DuenoVo duenoVo;
    private String nombre;
    private String raza;
    private Date fechaNacimiento;
    private boolean status;
    private String comentarios;
    private String sexo;
    private String foto;
    private Date fechaAlta;
    private String numeroRegistro;

    private Integer catEspecieIdEspecie;
    private String catEspecieNombre;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public DuenoVo getDuenoVo() {
        return duenoVo;
    }

    public void setDuenoVo(DuenoVo duenoVo) {
        this.duenoVo = duenoVo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Integer getCatEspecieIdEspecie() {
        return catEspecieIdEspecie;
    }

    public void setCatEspecieIdEspecie(Integer catEspecieIdEspecie) {
        this.catEspecieIdEspecie = catEspecieIdEspecie;
    }

    public String getCatEspecieNombre() {
        return catEspecieNombre;
    }

    public void setCatEspecieNombre(String catEspecieNombre) {
        this.catEspecieNombre = catEspecieNombre;
    }
}
