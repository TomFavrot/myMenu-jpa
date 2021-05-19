package sopra.myMenu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MagasinIngredient")
public class MagasinIngredient implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "prix")
	private float prix;
	@Column(name = "marque")
	private String marque;
	@Column(name = "datePeremption")
	private Date datePeremption;
	@Column(name = "produitLocal")
	private Boolean produitLocal;
	@Column(name = "bio")
	private Boolean bio;
	@OneToMany(mappedBy = "magasinIngredients")
	private List<Magasin> magasins=new ArrayList<Magasin>();
	@OneToMany(mappedBy = "magasinIngredient")
	private List<Ingredient> ingredients=new ArrayList<Ingredient>();
	
	
	public MagasinIngredient() {
		super();
	}


	public MagasinIngredient(float prix, String marque, Date datePeremption, Boolean produitLocal, Boolean bio) {
		super();
		this.prix = prix;
		this.marque = marque;
		this.datePeremption = datePeremption;
		this.produitLocal = produitLocal;
		this.bio = bio;
	}


	public Long getId() {
		return id;
	}


	public float getPrix() {
		return prix;
	}


	public String getMarque() {
		return marque;
	}


	public Date getDatePeremption() {
		return datePeremption;
	}


	public Boolean getProduitLocal() {
		return produitLocal;
	}


	public Boolean getBio() {
		return bio;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}


	public void setProduitLocal(Boolean produitLocal) {
		this.produitLocal = produitLocal;
	}


	public void setBio(Boolean bio) {
		this.bio = bio;
	}
	
	
	
	

}
