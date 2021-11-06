
package C3Reto3.Reto3v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"C3Reto3.Reto3v2.Models"}) 
@SpringBootApplication
public class Reto3v2Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3v2Application.class, args);
	}

}
