package sopra.myMenu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plat")
public class Plat {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nombre_personne")
	private int nombrePersonne;
	@ManyToOne
	@JoinColumn(name = "repas_id")
	private Repas repas;
	@OneToOne
	@JoinColumn(name= "recette_id")
	private Recette recette;
	
	public Plat() {
		super();
	}


	public Plat(int nombrePersonne) {
		super();
		this.nombrePersonne = nombrePersonne;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNombrePersonne() {
		return nombrePersonne;
	}


	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}


	public Repas getRepas() {
		return repas;
	}


	public void setRepas(Repas repas) {
		this.repas = repas;
	}


	public Recette getRecette() {
		return recette;
	}


	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	
	

}
