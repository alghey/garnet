package mx.com.garnet.common.dictionary;

public class Endpoints {

    /************************************************************
     * 					     TARJETAHABIENTES
     ************************************************************/

    //BACKEND
    public static final String TARJETAHABIENTE_WS = "/th";
    public static final String TARJETA_WS = "/tarjeta";
    public static final String SEND_TOKEN_PASSWORD_WS = "/sendToken/{email}";
	public static final String ACTUALIZAR_PASSWORD_WS = "/actualizarPassword";
    public static final String GET_TOKEN_PASSWORD_WS = "/getToken";

    
    //FRONTEND
    public static final String TARJETAHABIENTE = "/th";
    public static final String SEND_TOKEN_PASSWORD = "/sendToken/{email}";
	public static final String ACTUALIZAR_PASSWORD = "/actualizarPassword";
	public static final String SALDOS = "/saldos";
	public static final String CONSULTA_SALDOS = "/consultaSaldos";
	public static final String VALIDAR_CUENTA = "/validarCuenta";
	public static final String VALIDANDO_CUENTA = "/validandoCuenta";

    /************************************************************
     * 					     HISTORIAL MOVIMIENTOS
     ************************************************************/
	//BACKEND
    public static final String HISTORIAL_MOVIMIENTOS_WS = "/historialMovimientos";
    public static final String LIST_MOVIMIENTOS_CONSULTA_WS = "/consultaMovimientos";
    public static final String LIST_AUTORIZACIONES_TRANSITO_WS = "/consultaAutorizacionesTransito";

    public static final String CONSULTA_SALDO_WS = "/consultaSaldo/{idTarjeta}";

	//FRONTEND
    public static final String HISTORIAL_MOVIMIENTOS = "/historialMovimientos";
    public static final String HISTORIAL_MOVIMIENTOS_CONSULTA = "/ver/{idTarjeta}";
    public static final String LIST_MOVIMIENTOS_CONSULTA = "/consultaMovimientos";
    public static final String LIST_AUTORIZACIONES_TRANSITO = "/consultaAutorizacionesTransito";

    public static final String CONSULTA_SALDO = "/consultaSaldo/{idTarjeta}";

    /************************************************************
     * 					     TARJETAS
     ************************************************************/
    //BACKEND
    public static final String TARJETA_REQUEST 		= "/tarjeta";
    public static final String BLOQUEAR_TARJETA 	= "/bloquear";
    public static final String DESBLOQUEAR_TARJETA 	= "/desbloquear";
    public static final String CAMBIAR_NIP_TARJETA  = "/cambiar-nip";
    public static final String GET_TARJETA_POR_ID   = "/{idTarjeta}";
    
    //FRONTEND
    public static final String BLOQUEAR_TARJETA_FRONT = "/bloquear";
    public static final String DESBLOQUEAR_TARJETA_FRONT = "/desbloquear";
    public static final String CAMBIAR_NIP_TARJETA_FRONT = "/cambiar-nip";
    public static final String GET_TARJETA_POR_ID_FRONT   = "/{idTarjeta}";
    
    //VIEWS
    public static final String CAMBIAR_NIP_VIEW = "/cambiarNip/{idTarjeta}";
    
    /************************************************************
     * 					     CATALOGOS
     ************************************************************/

    //BACKEND
    public static final String CATALOGOS_WS = "/cat";
    public static final String PREGUNTAS_SECRETAS_WS = "/preguntasSecretas";

    
    //FRONTEND
    public static final String CATALOGOS = "/cat";
    public static final String PREGUNTAS_SECRETAS = "/preguntasSecretas";


    /************************************************************
     * 					     FAVORITOS
     ************************************************************/

    public static final String FAVORITO_REQUEST = "/favorito";
    public static final String AGREGAR_FAVORITO = "/agregar";
    public static final String EDITAR_FAVORITO = "/editar";
    public static final String ELIMINAR_FAVORITO = "/eliminar";
    public static final String OBTENER_FAVORITOS = "/lista";
    public static final String OBTENER_FAVORITO ="/{idFavorito}";

}
