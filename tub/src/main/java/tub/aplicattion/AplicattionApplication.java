package tub.aplicattion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicattionApplication {

    public static void main(String[] args) {
  
        // Inicializar o banco de dados
        // DatabaseInitializer.initialize();

        // Executar a aplicação Spring Boot
        SpringApplication.run(AplicattionApplication.class, args); 
    }
}

