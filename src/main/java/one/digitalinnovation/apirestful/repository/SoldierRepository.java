package one.digitalinnovation.apirestful.repository;

import one.digitalinnovation.apirestful.entity.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
