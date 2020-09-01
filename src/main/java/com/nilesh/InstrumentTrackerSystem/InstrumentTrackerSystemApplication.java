package com.nilesh.InstrumentTrackerSystem;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.gui.Login;


@SpringBootApplication
public class InstrumentTrackerSystemApplication implements CommandLineRunner{


//	public static void main(String[] args) {
//
//	    
//		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
//		@SuppressWarnings("unused")
//		InstrumentTrackerSystemApplication theInstrumentTrackerSystemApplication = ctx.getBean(InstrumentTrackerSystemApplication.class); 
////		theInstrumentTrackerSystemApplication.startLogin();
////	    ApplicationContext contexto = new SpringApplicationBuilder(Main.class)
////                .web(WebApplicationType.NONE)
////                .headless(false)
////                .bannerMode(Banner.Mode.OFF)
////                .run(args);
//	}	
    public static void main(String[] args) {
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class);

    	builder.headless(false);

    	ConfigurableApplicationContext context = builder.run(args);
    	Login theLogin = context.getBean(Login.class);
    	theLogin.makeLoginPage();
//        @SuppressWarnings("unused")
//		ApplicationContext contexto = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class)
//                .web(WebApplicationType.NONE)
//                .headless(false)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
    }



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		theLogin.makeLoginPage();
	}	
}

