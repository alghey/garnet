package mx.com.garnet.web.controllers;

import mx.com.garnet.web.services.catalogos.CatalogosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	 private static Logger log = LogManager.getLogger(HomeController.class);

	 
	 @Autowired
     CatalogosService catalogosService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
   /* @GetMapping("/activarCuenta")
    public ModelAndView activarCuenta(){
    	log.info("ENTRANDO AL CONTROLLER HOME - activarCuenta");
        ModelAndView mv = new ModelAndView("activar/activarCuenta");
        return mv;
    }
    
    
    @GetMapping("/activandoCuenta")
    public ModelAndView activandoCuenta(@RequestParam(value = "token") String token){
    	log.info("ENTRANDO AL CONTROLLER HOME - activandoCuenta");
        ModelAndView mv = new ModelAndView("activar/activandoCuenta");
        mv.addObject("token", token);
        
        log.info("TOKEN ----> " + token);
        TokenValidationRequest tokenRequest = new TokenValidationRequest();
        tokenRequest.setToken(token);
        
        GeneralResponse tokenPasswordResponse = thService.tokenValidationAccount(tokenRequest);
        if(tokenPasswordResponse == null || !tokenPasswordResponse.getCode().equals(ResponseCode.OK.code)){
        	log.info("TOKEN INVALIDO");
        	mv = new ModelAndView("/error/token_invalido");
        	return mv;
        }else {
        	log.info("TOKEN VALIDO");
        }

        return mv;
    }*/
    

    

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/access-denied";
    }
    
    
   /* @GetMapping("/recuperarPassword")
    public ModelAndView recuperarPassword(){
        ModelAndView mv = new ModelAndView("recuperarPassword");
        return mv;
    }
    
    @GetMapping("/reestablecerPassword")
    public ModelAndView reestablecerPassword(@RequestParam(value = "token") String token){
        ModelAndView mv = new ModelAndView("reestablecerPassword");
        mv.addObject("token", token);
        TokenPasswordResponse tokenPasswordResponse = thService.getTokenPassword(token);
        if(tokenPasswordResponse == null || !tokenPasswordResponse.getCode().equals(ResponseCode.OK.code)){
            mv = new ModelAndView("/error/500");
            return mv;
        }

        CatPreguntaSecretaResponse cat = catalogosService.getPreguntasSecretas();
        List<CatPreguntaSecretaVo> preguntasSecretas;
        if(cat.getCode().equals(ResponseCode.OK.code)) {
            mv.addObject("preguntasSecretas", cat.getPreguntasSecretas());
            //preguntasSecretas = cat.getPreguntasSecretas();
            int i = 1;
            for (int idPregunta : tokenPasswordResponse.getPreguntasSecretas()){
                mv.addObject("pregunta0" + String.valueOf(i), idPregunta);
                i++;
            }
        }



        return mv;
    }*/


}
