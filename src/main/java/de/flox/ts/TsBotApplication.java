package de.flox.ts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import de.flox.ts.api.TeamSpeakInstaller;

@SpringBootApplication
@ComponentScan
public class TsBotApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TsBotApplication.class, args);	
		try {
			TeamSpeakInstaller.createStartFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(TsBotApplication.class);
	}

}
