package matteo.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matteo.application.model.Classi;

@Repository
public interface ClassiRepository extends JpaRepository<Classi, Integer>{
	
}
