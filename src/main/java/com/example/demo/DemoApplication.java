package com.example.demo;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    
    
        private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
  
	public static void main(String[] args) {
                LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(DemoApplication.class, args);
                LOG.info("APPLICATION FINISHED");
	}
        
    @Autowired
    ApplicationContext applicationContext;
        
    @Override
    public void run(String... args)
    {
        System.out.println("------------------------------------------");
        System.out.println("check beans loaded  by springboot:");
    	System.out.println("------------------------------------------");
        LOG.info("APPLICATION SHOWING BEANS");

	String[] beanNames = applicationContext.getBeanDefinitionNames();
	Arrays.sort(beanNames);
	for (String beanName : beanNames) {
            System.out.println(beanName);	} 
    }
}
