package mx.com.garnet.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    @Value("Hello Rigel")
    private String message = "Hello World";
    
    
    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}
