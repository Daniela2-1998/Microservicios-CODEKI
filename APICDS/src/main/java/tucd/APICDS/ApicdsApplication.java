package tucd.APICDS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApicdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicdsApplication.class, args);
	}

}
