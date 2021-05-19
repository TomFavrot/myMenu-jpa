package sopra.myMenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AjustementQuantite")
public class AjustementQuantite {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "quantiteModifiee")
	private float quantiteModifiee;
	@OneToMany(mappedBy = "ajustementQuantite")
	private List<ListeCourses> listeCourses=new ArrayList<ListeCourses>();
	@OneToMany(mappedBy = "AjustementQuantite")
	private List<Ingredient> ingredients=new ArrayList<Ingredient>();
	
	
	public AjustementQuantite() {
		super();
	}
	
	public AjustementQuantite(Float quantiteModifiee) {
		super();
		this.quantiteModifiee = quantiteModifiee;
	}
	public Long getId() {
		return id;
	}
	public Float getQuantiteModifiee() {
		return quantiteModifiee;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuantiteModifiee(Float quantiteModifiee) {
		this.quantiteModifiee = quantiteModifiee;
	}
	
	

}
