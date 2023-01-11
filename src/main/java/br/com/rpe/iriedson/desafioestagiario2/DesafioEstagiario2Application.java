package br.com.rpe.iriedson.desafioestagiario2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Desafio Estagiario 2", description = "Esta aplicação visa gerenciar CRUD das lojas fisícas ou digitais dos clientes."))
public class DesafioEstagiario2Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioEstagiario2Application.class, args);
	}

}
