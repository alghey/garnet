package mx.com.garnet.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "app.properties.config")
@Configuration("config")
public class AppConfigProperties {

	
	private String servicesPath;
	private String loginEndPoint;
	private String logoutEndPoint;
	private String validateTokenAccountEndPoint;
	
	
	public String getServicesPath() {
		return servicesPath;
	}

	public void setServicesPath(String servicesPath) {
		this.servicesPath = servicesPath;
	}

	public String getLoginEndPoint() {
		return loginEndPoint;
	}

	public void setLoginEndPoint(String loginEndPoint) {
		this.loginEndPoint = loginEndPoint;
	}
	
	public String getLogoutEndPoint() {
		return logoutEndPoint;
	}

	public void setLogoutEndPoint(String logoutEndPoint) {
		this.logoutEndPoint = logoutEndPoint;
	}

	public String getValidateTokenAccountEndPoint() {
		return validateTokenAccountEndPoint;
	}

	public void setValidateTokenAccountEndPoint(String validateTokenAccountEndPoint) {
		this.validateTokenAccountEndPoint = validateTokenAccountEndPoint;
	}

	
	
	
	
}
