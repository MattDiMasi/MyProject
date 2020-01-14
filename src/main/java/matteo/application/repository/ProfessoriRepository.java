package matteo.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matteo.application.model.Professori;

@Repository
public interface ProfessoriRepository extends JpaRepository<Professori, Integer> {
	Professori findByEmailAndPassword(String email,String password);
}
