package com.kihwangkwon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MultiClassBoardApplication {

    public static final String APPLICATION_LOCATIONS = 
    		"spring.config.location="
    		+"classpath:application.yml,"
    		+"C:\\sts-4.5.1.RELEASE\\00dbtestyml\\application.yml";
       	  //+ "/home/ec2-user/app/config/boardtoyproject/db.yml";
	
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(MultiClassBoardApplication.class)
        .properties(APPLICATION_LOCATIONS)
        .run(args);
		
	}


}
