package mx.com.garnet.web.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



@Configuration
public class RestTemplateConfig {


	/**
	* Seteo de configuración personalizada para RestTemplate
	* @return  El RestTemplate con configuraciones personalizadas
	*/
	   @Bean
	    public RestTemplate restTemplate() {
		    RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		    restTemplate.setInterceptors(Collections.singletonList(new CustomClientHttpRequestInterceptor()));
		    return  restTemplate;		   
	    }
}
