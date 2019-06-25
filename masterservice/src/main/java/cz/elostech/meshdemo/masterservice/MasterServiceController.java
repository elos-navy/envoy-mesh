package cz.elostech.meshdemo.masterservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MasterServiceController {
    
    @Value("${servicea.uri:http://localhost:8080/greeting}")
    private String serviceaURI;
 
    @Value("${servicea.enabled:true}")
    private Boolean serviceaEnabled;

    @Value("${serviceb.uri:http://localhost:8080/greeting}")
    private String servicebURI;
   
    @Value("${serviceb.enabled:false}")
    private Boolean servicebEnabled;

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @GetMapping("/invoke")
    public String invoke(RestTemplate restTemplate,
        @RequestParam(value = "name1", defaultValue = "World1") String name1,
        @RequestParam(value = "timeout1", defaultValue = "0") long timeout1,
        @RequestParam(value = "name2", defaultValue = "World2") String name2,
        @RequestParam(value = "timeout2", defaultValue = "0") long timeout2) {

        String respA = null;
        String respB = null;
        
        if(this.serviceaEnabled)
            respA = callService(restTemplate, serviceaURI+"?name="+name1+"&timeout="+timeout1);

        if(this.servicebEnabled)
            respB = callService(restTemplate, servicebURI+"?name="+name2+"&timeout="+timeout2);
       

        return respA + " \n" + respB;
    }

    private String callService(RestTemplate restTemplate, String serviceURI) {
        Message m = restTemplate.getForObject(serviceURI, Message.class);
        System.out.println("Test service call from web: " + m.toString());
        return m.toString();
    }
}