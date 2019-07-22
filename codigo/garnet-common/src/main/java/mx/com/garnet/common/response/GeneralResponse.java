package mx.com.garnet.common.response;

public class GeneralResponse {
	   
	private String code;
	private String message;

	public GeneralResponse(String code, String message){
		this.code = code;
		this.message = message;
	}
	public GeneralResponse(){

	}

	public String getCode() {
	    return code;
	}

	public void setCode(String code) {
	    this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

	@Override
	public String toString() {
		return "{code=" + code + ", message=" + message + "}";
	}
	
	
	
}
