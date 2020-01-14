package matteo.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matteo.application.model.ProfessoriClassi;

@Repository
public interface ProfClassRepository extends JpaRepository<ProfessoriClassi, Integer>{

}
