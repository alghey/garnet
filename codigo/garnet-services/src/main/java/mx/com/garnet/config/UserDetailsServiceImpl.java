package mx.com.garnet.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* Armando Jacobo
* Fecha: 09/01/2019
* Desarrollado por SERTI 
*
*/


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserPrinciple userPrinciple = null;
    	try{
    	     /*  throw new UsernameNotFoundException("Tarjetabiente no valido : " + username);
    		 userPrinciple=UserPrinciple.build(datUsuario);*/
    	}catch(Exception ex) {
    	}
    	return userPrinciple;
    }
}