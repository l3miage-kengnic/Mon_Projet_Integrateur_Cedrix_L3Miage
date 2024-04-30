package fr.uga.l3miage.integrator;

import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * Correspond au main de l'application et donc ce qui va la lancer
 * Les Annotations :
 * <ul>
 *     <li>{@link SpringBootApplication} permet de dire à spring que cette classe est le run de l'application</li>
 * </ul>
 */
@SpringBootApplication
public class IntegratorProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegratorProjectSpringApplication.class,args);
    }

/*
    @Bean CommandLineRunner commandLineRunner(EmployeRepository employeRepository)
    { return args -> {
        employeRepository.save(EmployeEntity.builder().email(UUID.randomUUID().toString()).nom("isma").prenom("eee").telephone("3232").build());
        employeRepository.save(EmployeEntity.builder().email(UUID.randomUUID().toString()).nom("ismail").prenom("eeeii").telephone("32").build());
        employeRepository.save(EmployeEntity.builder().email(UUID.randomUUID().toString()).nom("isma9").prenom("eee88").telephone("302").build());
        employeRepository.save(EmployeEntity.builder().email(UUID.randomUUID().toString()).nom("isma6").prenom("eee00").telephone("322").build());
    };}*/
}
