package mx.com.garnet.common;

public enum ResponseCode {
	
	//Inicio de sesión
	OK("OK","Correcto"),
	BAD_CREDENTIALS("BAD_CREDENTIALS","Usuario o contraseña incorrectos"),
	BLOCKED_USER("BLOCKED_USER","Usuario bloqueado"),
	EMPTY_CREDENTIALS("EMPTY_CREDENTIALS","Usuario y password no puedene estar vacios"),
	INTERNAL_ERROR("INTERNAL_ERROR","Error interno"),
	SESSION_ACTIVE("SESSION_ACTIVE","Sesión activa en otro dispositivo"),
	BAD_REQUEST("BAD_REQUEST","Requerimiento no válido"),
	
	///// USUARIO //////
	USER_ACTIVED("USER_ACTIVED","Tu usuario ya se encuentra activado."),
	USER_VALIDATION_IN_PROCESS("USER_VALIDATION_IN_PROCESS","Tu usuario se encuentra en proceso de validación"),
	USER_BLOCKED("USER_BLOCKED","Tu usuario se encuentra bloqueado."),
	USER_FIRST_LOGIN("USER_FIRST_LOGIN", "El usuario aún no se ha logueado por primera vez."),
	USER_NOT_EXITS("USER_NOT_EXISTS","El usuario a validar no existe"),
	USER_NOT_ACTIVE("USER_NOT_ACTIVE", "El usuario no se encuentra activo."),
	INVALID_RESPONSES("INVALID_RESPONSES", "Las respuestas son invalidas"),

	
	//Catalogs
	CATALOG_EMPTY("CATALOG_EMPTY","El catalogo esta vacio"),
	
	
	// TOKEN
	TOKEN_NOT_VALID("TOKEN_NOT_VALID","El token no es valido"),
	TOKEN_EXPIRED("TOKEN_EXPIRED","El token expirado"),
	
	//Movimientos
	CARD_NOT_VALID("CARD_NOT_VALID","La tarjeta no es valida"),
	
	// SESSION
	SESSION_NOT_EXIST("SESSION_NOT_EXIST","La sesión no existe del TH"),
	SESSION_ABOUT_EXPIRED("SESSION_ABOUT_EXPIRED","La sesión a punto de expirar"),
	SESSION_OK("SESSION_OK","La sesión es valida"),
	SESSION_CLOSE("SESSION_CLOSE","La sesión esta cerrada"),
	
	
	// TARJETAS
	TARJETAS_EMPTY("TARJETAS_EMPTY","No se encontraron tarjetas"),
	TARJETA_NOT_FOUND("TARJETA_NOT_FOUND", "No se encontró la tarjeta"),
	TARJETA_ALREADY_BLOCKED("TARJETA_ALREADY_BLOCKED","La tarjeta ya está bloqueada"),
	TARJETA_BLOCKED_OK("TARJETA_BLOCKED_OK","Se ha bloqueado la tarjeta correctamente"),
	TARJETA_ALREADY_UNBLOCKED("TARJETA_ALREADY_UNBLOCKED","La tarjeta ya está desbloqueada"),
	TARJETA_UNBLOCKED_OK("TARJETA_UNBLOCKED_OK","Se ha desbloqueado la tarjeta correctamente"),
	TARJETA_NOT_ACTIVE("TARJETA_NOT_ACTIVE","La tarjata no está activa"),
	TARJETA_NOT_ASSIGNED_TH("TARJETA_NOT_ASSIGNED_TH","La tarjeta no pertenece al Tarjetahabiente seleccionado"),
	TARJETA_PIN_ASSIGNED_OK("TARJETA_PIN_ASSIGNED_OK","NIP asignado correctamente"),
	
	//TARHETAHABIENTES	
	TH_NIP_WRONG("TH_NIP_WRONG","Su NIP de usuario es incorrecto"),
	SMS_CODE_VALID_OK("SMS_CODE_VALID_OK", "El código SMS es correcto"),
	SMS_CODE_WRONG("SMS_CODE_WRONG","El código SMS no coincide"),
	SMS_EXPIRED("SMS_EXPIRED","Código Sms expirado"),
	SMS_NOT_SEND("SMS_NOT_SEND","El código SMS no se puedo enviar"),

	RESPUESTAS_SAVED_OK("RESPUESTAS_SAVED_OK","Respuetas Guardads Correctamente"),
	RESPUESTAS_NO_VALID("RESPUESTAS_NO_VALID","Las respuetsas no son las necesarias"),

	NIP_SAVED_OK("NIP_SAVED_OK","Nip asignado correctamente"),
	NIP_WRONG("NIP_WRONG","Los NIPS no coinciden"),

	PASSWORD_SAVED_OK("PASSWORD_SAVED_OK","Contraseña guardadda correctamente"),
	PASSWORD_WRONG("PASSWORD_WRONG","Las contraseñas no coinciden"),

	FAV_NOT_DELETE("FAV_NOT_DELETE", "No se pudo borrar el favorito"),

	
	JWT_INVALIDO("403","Token no valido");
	
	
	
	private ResponseCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String code;
	public String desc;
	
	
	
}
