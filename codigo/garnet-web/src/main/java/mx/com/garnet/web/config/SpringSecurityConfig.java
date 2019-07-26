package mx.com.garnet.web.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  /*  @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    CustomAuthenticationSuccessHandler successHandler;
    
    @Autowired
    CustomLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    CustomAuthenticationFailureHandler failureHandler;

    @Autowired
    private CustomAuthenticationProvider authProvider;*/


    @Override
    protected void configure(HttpSecurity http) {

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
    	//Inidca que el inicio de sesión se llevara a cabo a traves de 'CustomAuthenticationProvider'
    	//auth.authenticationProvider(authProvider);
    }
    
}
