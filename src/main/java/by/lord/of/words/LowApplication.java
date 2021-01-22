package by.lord.of.words;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@ConfigurationPropertiesScan("by.lord.of.words.config")
public class LowApplication {

	public static void main(String[] args) {
		SpringApplication.run(LowApplication.class, args);
	}
}
