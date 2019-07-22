package mx.com.garnet.common.logout;

/*
* Armando Jacobo 
* Fecha: 16/01/19
* Desarrollado por SERTI 
*
*/

public class LogoutRequest {

	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "{username=" + username + "}";
	}
	
	
	
	
	
}
