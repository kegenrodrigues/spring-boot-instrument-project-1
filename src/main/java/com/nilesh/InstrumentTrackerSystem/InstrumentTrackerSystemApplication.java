package com.nilesh.InstrumentTrackerSystem;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.gui.Login;


@SpringBootApplication
public class InstrumentTrackerSystemApplication implements CommandLineRunner{

    public static void main(String[] args) {
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class);

    	builder.headless(false);

    	ConfigurableApplicationContext context = builder.run(args);
    	Login theLogin = context.getBean(Login.class);
    	theLogin.makeLoginPage();

    }

	@Override
	public void run(String... args) throws Exception {

	}	
}

