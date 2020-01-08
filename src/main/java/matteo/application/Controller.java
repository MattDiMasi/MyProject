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

import matteo.application.model.Classi;
import matteo.application.model.Studenti;
import matteo.application.service.ScuolaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller  {
	
	@Autowired
	private ScuolaService scuolaService;

	@GetMapping("/classi")                     //set end point
    public ResponseEntity<List<Classi>> classiG() {          //return a ResponseEntity because in a error case it returns the error code
		return ResponseEntity.ok(scuolaService.findAllClassi());            //call the method of the ClassiRepository
	}
	
	@GetMapping("/studenti")
	public ResponseEntity<List<Studenti>> studentiG(){
		return ResponseEntity.ok(scuolaService.findAllStudenti());
	}
	
	@GetMapping("/studenti/{idClasse}")
	public ResponseEntity<List<Studenti>> findStudentiByClasse(@PathVariable("idClasse") int idClasse){
		return ResponseEntity.ok(scuolaService.getStudentiByClasse(idClasse));
	}
	
	@PostMapping("/studenti")
    public ResponseEntity<List<Studenti>> saveStudenti(@RequestBody List<Studenti> s){	
    	return ResponseEntity.ok(scuolaService.saveStudenti(s));
    }	
	
	@PostMapping("/classi")
    public ResponseEntity<List<Classi>> saveClassi(@RequestBody List<Classi> c){
    	return ResponseEntity.ok(scuolaService.saveClassi(c));
    }
    
    @DeleteMapping("/classi/{id}")
    public void deleteClassi(@PathVariable("id") int id){            
    	scuolaService.deleteClassi(id);
    }
    
    @DeleteMapping("/studenti/{id}")
    public void deleteStudenti(@PathVariable("id") int id){            
    	scuolaService.deleteStudenti(id);
    }
    
    @PutMapping("/classi/{id}")
    public ResponseEntity<Classi> updateClassi(@RequestBody Classi c,@PathVariable("id") int id){
    	
    	return ResponseEntity.ok(scuolaService.updateClassi(c));
    }    
    
    @PutMapping("/studenti/{id}")
    public ResponseEntity<Studenti> updateStudenti(@RequestBody Studenti s,@PathVariable("id") int id){
    	
    	return ResponseEntity.ok(scuolaService.updateStudenti(s));
    }
}