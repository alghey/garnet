package mx.com.garnet.services.security;



import mx.com.garnet.common.login.LoginRequest;
import mx.com.garnet.common.login.LoginResponse;
import mx.com.garnet.common.logout.LogoutRequest;
import mx.com.garnet.common.response.GeneralResponse;

import javax.servlet.http.HttpServletRequest;

/*
* Rafael Cortes  / Emmanuel Torres / Armando Jacobo
* Fecha: 21/12/18
* Desarrollado por SERTI 
*
*/

public interface SecurityService {
    public LoginResponse login(LoginRequest request, HttpServletRequest req);
    public GeneralResponse logout(LogoutRequest request, HttpServletRequest req);

	
}
