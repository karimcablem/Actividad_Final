package mx.tecmilenio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Evicencia2ApiApplication extends SpringBootServletInitializer {


	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(Evicencia2ApiApplication.class);
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(Evicencia2ApiApplication.class, args);
	}

}
