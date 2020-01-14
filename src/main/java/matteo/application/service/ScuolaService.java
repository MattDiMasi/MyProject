package matteo.application.service;

import java.util.List;

import matteo.application.model.Classi;
import matteo.application.model.Studenti;

public interface ScuolaService  {
	List<Classi> findAllClassi();
	
	List<Classi> saveClassi(List<Classi> entities);
	
	List<Studenti> findAllStudenti();
	
	List<Studenti> getStudentiByClasse(int idClase);
	
	List<Studenti> saveStudenti(List<Studenti> entities);
	
	void deleteStudenti(int id);
	
	void deleteClassi(int id);
	
	Studenti updateStudenti(Studenti s);
	
	Classi updateClassi(Classi c);
	
	int login(String email,String password);
}
