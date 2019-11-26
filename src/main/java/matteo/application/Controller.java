package matteo.application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import matteo.application.model.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller  {
	@Autowired
	private ClassiRepository classiRepository; 

	@GetMapping("/classi")                     //set end point
    public ResponseEntity<List<Classi>> classiG() {          //return a ResponseEntity because in a error case it returns the error code
		return ResponseEntity.ok(classiRepository.findAll());            //call the method of the ClassiRepository
	}
	
	@GetMapping("/studenti")
	public ResponseEntity<List<Studenti>> studentiG(){
		return ResponseEntity.ok(classiRepository.findAllStudenti());
	}
	
	@GetMapping("/studenti/{idClasse}")
	public ResponseEntity<List<Studenti>> findStudentiByClasse(@PathVariable("idClasse") int idClasse){
		return ResponseEntity.ok(classiRepository.findStudentiByClasse(idClasse));
	}
	
	@GetMapping("/studenti/nameClasse/{nameClasse}")
	public ResponseEntity<List<Studenti>> findStudentiByClasseName(@PathVariable("nameClasse") String nameClasse){
		return ResponseEntity.ok(classiRepository.findStudentiByClasseName(nameClasse));
	}
	
	
	@GetMapping("/classi/{id}")
    public ResponseEntity<Classi> findClassById(@PathVariable("id") int id) {
        return ResponseEntity.ok(classiRepository.findById(id));
    }
	
	
	
	@PostMapping("/classi")
    public ResponseEntity<List<Classi>> saveClassi(@RequestBody List<Classi> c){
		for(Classi elements:c) {
			ResponseEntity.ok(classiRepository.save(elements));
		}
    	return ResponseEntity.ok(c);
    }
    
    @GetMapping("/classi/{name}")
	public ResponseEntity<Classi> classiGet(@PathVariable("name") String name){
		return ResponseEntity.ok(classiRepository.findByName(name));
	}
    
    @DeleteMapping("/classi/{id}")
    public ResponseEntity<Integer> deleteClassi(@PathVariable("id") int id){            
    	return ResponseEntity.ok(classiRepository.delete(id));
    }
    
    @PutMapping("/classi/{id}")
    public ResponseEntity<Classi> updateClassi(@RequestBody Classi c,@PathVariable("id") int id){
    	
    	return ResponseEntity.ok(classiRepository.save(classiRepository.findById(id).setClassi(c)));
    }    
}