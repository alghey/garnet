package mx.com.garnet.config.seguridad;


import javax.validation.Valid;

import mx.com.garnet.config.jwt.JwtProvider;
import mx.com.garnet.services.security.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.garnet.config.UserPrinciple;

import mx.com.garnet.services.security.dto.LoginForm;
/*
* Rafael Cortes  / Emmanuel Torres 
* Fecha: 21/12/18
* Desarrollado por SERTI 
*
*/


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;


    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

    	
    	Authentication authentication = null;
    	
    	//DatTarjetahabiente datUsuario = tarjetahabienteRepository.findByCorreo(loginRequest.getUsername());
		if(true)
           throw new UsernameNotFoundException("Tarjetahabiente no valido : " + loginRequest.getUsername());
		UserPrinciple userPrinciple = userPrinciple=UserPrinciple.build();
    	
    	authentication= new UsernamePasswordAuthenticationToken(userPrinciple, loginRequest.getPassword());
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

}