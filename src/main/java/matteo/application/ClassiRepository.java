package matteo.application;
import matteo.application.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClassiRepository extends JpaRepository<Classi, Integer>{

	@Query("SELECT c FROM Classi c ")
	List<Classi> findAll();
	
	@Query("SELECT s FROM Studenti s ")
	List<Studenti> findAllStudenti();
	
	@Query("SELECT s FROM Studenti s WHERE s.idClasse=:idClasse")
	List<Studenti> findStudentiByClasse(int idClasse);
	
	@Query("SELECT s FROM Studenti s WHERE s.idClasse= (SELECT d FROM Classi d WHERE d.name=:nameClasse)")
	List<Studenti> findStudentiByClasseName(String nameClasse);
	
	@SuppressWarnings("unchecked")
	@Override
	Classi save(Classi entity);
	
	Classi findByName(String name);      //Define only the name becouse jpa know how to do
	
	@Transactional										//if we want to modify the db
	@Modifying											//""    ""   ""   ""     ""
	@Query("DELETE FROM Classi c WHERE c.id=:id")         //The language is similar to SQL but not is the same
	Integer delete(int id);
		
	@Transactional	
	@Modifying
	@Query("UPDATE Classi c SET c=:classe WHERE c.id=:id ")
	Integer update(Classi classe,int id);
	
	Classi findById(int id);
}
