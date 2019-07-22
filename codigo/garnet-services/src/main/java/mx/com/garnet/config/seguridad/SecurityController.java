package mx.com.garnet.config.seguridad;

import mx.com.garnet.common.login.LoginRequest;
import mx.com.garnet.common.login.LoginResponse;
import mx.com.garnet.common.logout.LogoutRequest;
import mx.com.garnet.common.response.GeneralResponse;

import mx.com.garnet.services.security.SecurityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/*
* Rafael Cortes  / Emmanuel Torres 
* Fecha: 21/12/18
* Desarrollado por SERTI 
*
*/

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/security")
public class SecurityController {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    SecurityService securityService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request,  HttpServletRequest req){
        logger.info("Entrando a login [Usuario: " + request.getUsername() + "]");
        LoginResponse response = securityService.login(request, req);
        logger.info("Saliendo de login [Usuario: " + request.getUsername() + "]");
        return response;
    }
    
    @PostMapping("/logout")
    public GeneralResponse logout(@Valid @RequestBody LogoutRequest request, HttpServletRequest req){
        logger.info("Entrando a logout [Usuario: " + request.getUsername() + "]");
        GeneralResponse response = securityService.logout(request, req);
        logger.info("Saliendo de logout [Usuario: " + request.getUsername() + "]");
        return response;
    }


}
