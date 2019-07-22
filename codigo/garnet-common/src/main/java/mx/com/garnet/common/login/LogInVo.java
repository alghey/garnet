package mx.com.garnet.common.login;

import java.util.List;

/*
* Armando Jacobo  
* Fecha: 09/01/19
* Desarrollado por SERTI 
*
*/

public class LogInVo {
    private Integer idTarjetahabiente;
    private String  UserName;
    private String  empresa;
    private String  nombre;
    private String  apellidoPaterno;
    private String  apellidoMaterno;
    
    private String  jwt;
    private String  tokenType = "Bearer";
	
	
    
    
	public Integer getIdTarjetahabiente() {
		return idTarjetahabiente;
	}

	public void setIdTarjetahabiente(Integer idTarjetahabiente) {
		this.idTarjetahabiente = idTarjetahabiente;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	
	
	
	

	

}
