package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByEmail(String email);


}
