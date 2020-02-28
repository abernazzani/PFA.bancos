package io.progii.springboot;

import java.util.Collections;

import org.apache.logging.log4j.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PFABancosApiApp  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");
		logger.info("Application Start");
		
		SpringApplication app = new SpringApplication(PFABancosApiApp.class);
		
		app.setDefaultProperties(Collections
		          .singletonMap("server.port", "80"));
		        app.run(args);
	}
	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");
		logger.info("Application Start");
        return application.sources(PFABancosApiApp.class);
     }

}
