package sopra.myMenu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Magasin")
public class Magasin implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "siret")
	private String siret;	
	@ManyToOne
	@JoinColumn(name = "MagasinIngredient_id") 
	private MagasinIngredient magasinIngredients;
	@OneToMany(mappedBy="magasin")
	private List<Adresse> adresses=new ArrayList<Adresse>();
	
	public Magasin() {
		super();
	}
	
	public Magasin(String nom, String siret) {
		super();
		this.nom = nom;
		this.siret = siret;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getSiret() {
		return siret;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	

}
