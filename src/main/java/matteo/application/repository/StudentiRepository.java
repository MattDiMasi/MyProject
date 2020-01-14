package matteo.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matteo.application.model.Studenti;

@Repository
public interface StudentiRepository extends JpaRepository<Studenti, Integer> {
	List<Studenti> findByIdClasse(int idClasse);
}
