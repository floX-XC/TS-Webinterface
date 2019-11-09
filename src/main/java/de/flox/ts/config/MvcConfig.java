package de.flox.ts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };
	
	public void addViewController(ViewControllerRegistry regist) {
		regist.addViewController("/home").setViewName("home");
		regist.addViewController("/").setViewName("home");
		regist.addViewController("/welcome").setViewName("welcome");
		regist.addViewController("/login").setViewName("login");
		regist.addViewController("/ts3dash").setViewName("ts3dash");
		regist.addViewController("/addBot").setViewName("addBot");
		regist.addViewController("/tsinstall").setViewName("tsinstall");
		
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/**")
        .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	 }

	
}
