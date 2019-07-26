package mx.com.garnet.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;



@org.springframework.context.annotation.Configuration
public class Configuration {
    private static Logger logger = LogManager.getLogger(Configuration.class);
	
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

   	
	@Bean
	public ViewResolver htmlViewResolver() {
	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	    resolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
	    resolver.setContentType("text/html; charset=UTF-8");
	    resolver.setCharacterEncoding("UTF-8");
	    resolver.setViewNames(new String[] {"*.html"});
	    return resolver;
	}
	 
	private ITemplateResolver htmlTemplateResolver() {
	    SpringResourceTemplateResolver resolver
	      = new SpringResourceTemplateResolver();
	    //resolver.setApplicationContext(applicationContext);
	    resolver.setCharacterEncoding("UTF-8");
	    resolver.setPrefix("/templates/");
	    resolver.setCacheable(false);
	    resolver.setTemplateMode(TemplateMode.HTML);
	    return resolver;
	}
	 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**", "/css/**", "/js/**","/icons/**","/webfonts/**","/img/**")
	      .addResourceLocations("/resources/", "/css/","/js/","/icons/","/webfonts/","/img/");
	}
	
    private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect(new GroupingStrategy()));
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        engine.setTemplateEngineMessageSource(messageSource());
        return engine;
}
    
    @Bean
    @Description("Spring Message Resolver")
    public ReloadableResourceBundleMessageSource messageSource() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
}
    
    
    @Bean
    public IDialect conditionalCommentDialect() {
        return new Java8TimeDialect();
    }
     
}
