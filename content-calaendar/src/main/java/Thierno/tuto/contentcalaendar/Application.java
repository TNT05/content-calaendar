package Thierno.tuto.contentcalaendar;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import Thierno.tuto.contentcalaendar.model.content.ContentSpringData;
import Thierno.tuto.contentcalaendar.model.content.ContentStatus;
import Thierno.tuto.contentcalaendar.model.content.ContentType;
import Thierno.tuto.contentcalaendar.repository.content.ContentSpringDataRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// List all the beans available
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		// List all operation available by this bean
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		//System.out.println(restTemplate);
		//restTemplate.getForObject("http://localhost:8080", String.class);

		// usage of the Message bean created
		Message message = (Message) context.getBean("message");
		System.out.println(message.getMessage());

	}

		//Usage of a bean directly in the application, the commandLineRunner bean allows to run some code programatically after the application initialization (For exemple insert a row in a DB)
		@Bean
		public CommandLineRunner commandLineRunner(ContentSpringDataRepository repository){
			return args -> {

				ContentSpringData contentSpringData = new ContentSpringData(null, "In Sha Allah I get a job", "I need a job", ContentStatus.IN_PROGRESS, ContentType.CONFERENCE_TALK, LocalDateTime.now(), null, "");

				repository.save(contentSpringData);

			};  
		}
	

}
