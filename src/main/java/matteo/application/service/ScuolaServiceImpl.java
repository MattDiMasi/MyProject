package matteo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matteo.application.ClassiRepository;
import matteo.application.StudentiRepository;
import matteo.application.model.Classi;
import matteo.application.model.Studenti;

@Service
public class ScuolaServiceImpl implements ScuolaService {

	@Autowired
	private ClassiRepository classiRepository;
	
	@Autowired
	private StudentiRepository studentiRepository;
	
	@Override
	public List<Classi> findAllClassi(){
		return classiRepository.findAll();
	}
	
	@Override
	public List<Classi> saveClassi(List<Classi> entities) {
		for(Classi c: entities) {
			for(Classi c1: this.findAllClassi()) {
				if(c1.getName().equalsIgnoreCase(c.getName())) {
					return null;
				}
			}
		}
		
		return classiRepository.saveAll(entities);
	}
	
	@Override
	public void deleteClassi(int id) {
		for(Studenti s: studentiRepository.findByIdClasse(id)){
			studentiRepository.deleteById(s.getId());
		}
		
		classiRepository.deleteById(id);;
	}

	@Override
	public List<Studenti> getStudentiByClasse(int idClasse) {
		return studentiRepository.findByIdClasse(idClasse);
	}

	@Override
	public List<Studenti> findAllStudenti() {
		return studentiRepository.findAll();
	}

	@Override
	public List<Studenti> saveStudenti(List<Studenti> entities) {
		return studentiRepository.saveAll(entities);
	}
	
	@Override
	public void deleteStudenti(int id) {
		studentiRepository.deleteById(id);
	}

	@Override
	public Studenti updateStudenti(Studenti s) {
		return studentiRepository.save(s);
	}

	@Override
	public Classi updateClassi(Classi c) {
		return classiRepository.save(c);
	}
}
