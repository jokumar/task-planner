
package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * 
 * @author jokumar
 * @since 2018-03-25
 *	Main Spring Boot Application
 */
@SpringBootApplication(scanBasePackages = "com.application")
public class TaskPlannerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TaskPlannerApplication.class, args);
	}
	
	
	//Using the App as a servlet 
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(TaskPlannerApplication.class);
	    }
}
