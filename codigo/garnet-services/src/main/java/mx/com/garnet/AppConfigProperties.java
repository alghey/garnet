package mx.com.garnet;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app.properties.config")
@Configuration("config")
public class AppConfigProperties {

	
	private String servicesPath;
	private String validCuenta;
	
	
	public String getServicesPath() {
		return servicesPath;
	}

	public void setServicesPath(String servicesPath) {
		this.servicesPath = servicesPath;
	}

	public String getValidCuenta() {
		return validCuenta;
	}

	public void setValidCuenta(String validCuenta) {
		this.validCuenta = validCuenta;
	}

	
	
}
