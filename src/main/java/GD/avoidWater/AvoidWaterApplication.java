package GD.avoidWater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AvoidWaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvoidWaterApplication.class, args);
	}

}
