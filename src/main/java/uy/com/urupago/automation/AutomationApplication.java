package uy.com.urupago.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uy.com.urupago.automation.config.AutomationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AutomationProperties.class)
public class AutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationApplication.class, args);
	}

}
