package br.com.alexandre.Desafio.Back.end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DesafioBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackEndApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
