package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ingredient")
public class Ingredient {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "quantite")
	private Float quantite;
	@Column(name = "type_produit")
	private TypeProduit typeProduit;
	@Column(name = "produit_saison")
	private ProduitSaison produitSaison;
	@Column(name = "nombre_calories_100g")
	private Float nombreCalories100g;
	@ManyToMany 
	@JoinTable(name = "recette", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "recette_id"))
	private List<Recette> recettes = new ArrayList<Recette>();
	@ManyToOne
	@JoinColumn(name = "AjustementQuantite_id")
	private AjustementQuantite ajustementQuantite;
	@ManyToOne
	@JoinColumn(name = "magasinIngredient_id")
	private MagasinIngredient magasinIngredient;
	public Ingredient() {
		super();
	}


	public Ingredient(String nom, float quantite, TypeProduit typeProduit, ProduitSaison produitSaison,
			float nombreCalories100g) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.typeProduit = typeProduit;
		this.produitSaison = produitSaison;
		this.nombreCalories100g = nombreCalories100g;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getQuantite() {
		return quantite;
	}


	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}


	public TypeProduit getTypeProduit() {
		return typeProduit;
	}


	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}


	public ProduitSaison getProduitSaison() {
		return produitSaison;
	}


	public void setProduitSaison(ProduitSaison produitSaison) {
		this.produitSaison = produitSaison;
	}


	public float getNombreCalories100g() {
		return nombreCalories100g;
	}


	public void setNombreCalories100g(float nombreCalories100g) {
		this.nombreCalories100g = nombreCalories100g;
	}
	
	
	

}
