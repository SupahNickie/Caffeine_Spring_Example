package main.java.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import supahnickie.caffeine.CaffeineConnection;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		CaffeineConnection.setConfiguration(System.getenv("CAFFEINE_DRIVER"), System.getenv("PORTFOLIO_DB_URL"), System.getenv("CAFFEINE_USERNAME"), System.getenv("CAFFEINE_PASSWORD"));
		SpringApplication.run(Application.class, args);
	}
}