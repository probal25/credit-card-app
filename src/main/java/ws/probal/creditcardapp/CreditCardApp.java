package ws.probal.creditcardapp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class CreditCardApp {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApp.class, args);
	}

}
