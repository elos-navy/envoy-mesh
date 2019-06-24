package cz.elostech.meshdemo.masterservice;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MasterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterServiceApplication.class, args);
	}

	@Bean
	public RestTemplate clirestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	/* @Bean
    public CommandLineRunner commandLineRunner(RestTemplate clirestTemplate) throws Exception {
        return args -> {
			
			Message m = clirestTemplate.getForObject(
					"http://localhost:8080/greeting", Message.class);
			
			System.out.println("Test service call from boot: " + m.toString());
        };
    } */

}
