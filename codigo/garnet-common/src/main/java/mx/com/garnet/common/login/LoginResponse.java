package mx.com.garnet.common.login;

import mx.com.garnet.common.ServiceResponse;


/*
* Rafael Cortes  / Emmanuel Torres 
* Fecha: 21/12/18
* Desarrollado por SERTI 
*
*/


public class LoginResponse extends ServiceResponse {
	private LogInVo loginVo;

	public LogInVo getLoginVo() {
		return loginVo;
	}

	public void setLoginVo(LogInVo loginVo) {
		this.loginVo = loginVo;
	}

	
}
