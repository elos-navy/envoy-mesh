package cz.elostech.meshdemo.greetservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ConfigurableApplicationContext;

@RestController
public class GreetingController implements ApplicationContextAware {

    private ApplicationContext context;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${serviceid:ServiceA}")
    private String serviceid;
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;    
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "timeout", defaultValue = "0") long timeout) {
        if (timeout < 0)
        ((ConfigurableApplicationContext) context).close();
            
        
        if (timeout > 0)
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return new Greeting(counter.incrementAndGet(), this.serviceid, String.format(template, name));
    }
}