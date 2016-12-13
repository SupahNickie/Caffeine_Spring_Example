package main.java.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import supahnickie.caffeine.CaffeineConnection;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		CaffeineConnection.addDatabaseConnection("primary", System.getenv("CAFFEINE_DRIVER"), System.getenv("PORTFOLIO_DB_URL"), System.getenv("CAFFEINE_USERNAME"), System.getenv("CAFFEINE_PASSWORD"));
		CaffeineConnection.useDatabase("primary");
		SpringApplication.run(Application.class, args);
	}
}