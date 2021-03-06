package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

@Entity
@Table(name="MagasinIngredient")
public class MagasinIngredient {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "prix")
	private Float prix;
	@Column(name = "marque")
	private String marque;
	@Column(name = "datePeremption")
	private Date datePeremption;
	@Column(name = "produitLocal")
	private Boolean produitLocal;
	@Column(name = "bio")
	private Boolean bio;
	@OneToMany(mappedBy = "magasinIngredient")
	private List<Magasin> magasins=new ArrayList<Magasin>();
	@OneToMany(mappedBy = "magasinIngredient")
	private List<Ingredient> ingredients=new ArrayList<Ingredient>();
	
	
	public MagasinIngredient() {
		super();
	}


	public MagasinIngredient(Float prix, String marque, Date datePeremption, Boolean produitLocal, Boolean bio) {
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


	public Float getPrix() {
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


	public void setPrix(Float prix) {
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


	public List<Magasin> getMagasins() {
		return magasins;
	}


	public void setMagasins(List<Magasin> magasins) {
		this.magasins = magasins;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	

}
