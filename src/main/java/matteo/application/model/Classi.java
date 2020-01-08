package matteo.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classi")
public class Classi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;

	public Classi() {
	}

	public Classi(int numeroStudenti, String name) {
		this.name = name;
	}

	public Classi(Classi c) {
		this.setClassi(c);
	}

	public Classi setClassi(Classi c) {
		this.name = c.name;

		return this;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s']", id, name);
	}
}
