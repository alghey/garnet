package mx.com.garnet.services.security.impl;

import mx.com.garnet.common.ResponseCode;
import mx.com.garnet.common.login.LogInVo;
import mx.com.garnet.common.login.LoginRequest;
import mx.com.garnet.common.login.LoginResponse;
import mx.com.garnet.common.logout.LogoutRequest;
import mx.com.garnet.common.response.GeneralResponse;
import mx.com.garnet.config.jwt.JwtProvider;
import mx.com.garnet.services.security.SecurityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/*
* Armando Jacobo
* Fecha: 09/01/19
* Desarrollado por SERTI 
*
*/

@EnableScheduling
@Service("SecurityServiceImpl")
public class SecurityServiceImpl implements SecurityService {

    private ModelMapper mapper = new ModelMapper();
    
    private static Logger log = LogManager.getLogger();

    @Autowired
    JwtProvider jwtProvider;


    @Override
    @Transactional
    public LoginResponse login(LoginRequest request, HttpServletRequest req) {
    	LoginResponse response =  new LoginResponse();
    	log.info(":::::: SERVICIO LOGIN TH :::::::::");
    	try{

   	    	//Valido usuario y password no vacios
	    	if(request.getUsername()!=null && request.getUsername()!="" && request.getPassword()!="" && request.getPassword()!=null){
		    	LogInVo loginVo= new LogInVo();
		    	Authentication authentication = null;



						//LLena objeto de respuesta

				    	//Genera authentication
				    	authentication= new UsernamePasswordAuthenticationToken("", request.getPassword());
				    	SecurityContextHolder.getContext().setAuthentication(authentication);
				        loginVo.setJwt(jwtProvider.generateJwtToken(authentication));

				    	response.setLoginVo(loginVo);
	    	}else {
	    		log.info("CREDENCIALES VACIAS");
				response.setResponseCode(ResponseCode.EMPTY_CREDENTIALS.desc);
	    	}
    	}catch(Exception ex) {
    		ex.printStackTrace();
			response.setResponseCode(ResponseCode.INTERNAL_ERROR.desc);
    	}
    	
    	return response;
    }


	@Override
	@Transactional
	public GeneralResponse logout(LogoutRequest request, HttpServletRequest req) {
		
		GeneralResponse response =  new GeneralResponse();
    	log.info(":::::: SERVICIO LOGOUT TH :::::::::");
		return response;
	}

}
