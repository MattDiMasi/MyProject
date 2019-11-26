package matteo.application.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Studenti")
public class Studenti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int idClasse;
	private String name;
	private String surname;
	private String comuneDiNascita;
	private Instant dataDiNascita;
	
	public Studenti() {}
	
	public Studenti(String name, String surname,String comuneDiNascita,Instant dataDiNascita,int idClasse) {
        this.surname= surname;
        this.name = name;
        this.comuneDiNascita = comuneDiNascita;
        this.dataDiNascita = dataDiNascita;
        this.idClasse=idClasse;
        
    }
	
	public Studenti (Studenti s) {
		this.setStudenti(s);
	}
    
    public Studenti setStudenti(Studenti s) {
    	this.surname= s.surname;
        this.name = s.name;
        this.comuneDiNascita = s.comuneDiNascita;
        this.dataDiNascita = s.dataDiNascita;
        this.idClasse= s.idClasse;
    	
    	return this;
    }
    
    public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getComuneDiNascita() {
		return comuneDiNascita;
	}

	public void setComuneDiNascita(String comuneDiNascita) {
		this.comuneDiNascita = comuneDiNascita;
	}

	public Instant getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Instant dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

}
