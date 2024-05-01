package Thierno.tuto.contentcalaendar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		//System.out.println(restTemplate);
		//restTemplate.getForObject("http://localhost:8080", String.class);
		Message message = (Message) context.getBean("message");
		System.out.println(message.getMessage());
	}

}
