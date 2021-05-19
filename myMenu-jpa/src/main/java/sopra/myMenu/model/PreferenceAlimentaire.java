package sopra.myMenu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preference_alimentaire")
public class PreferenceAlimentaire {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "Type_Alimentation")
	private TypeAlimentation typeAlimentation;
	@ManyToOne
	@JoinColumn(name = "Utilisateur_Id")
	private Utilisateur utilisateur;
	
	public PreferenceAlimentaire() {
		super();
	}

	public PreferenceAlimentaire(TypeAlimentation typeAlimentation, Utilisateur utilisateur) {
		super();
		this.typeAlimentation = typeAlimentation;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TypeAlimentation getTypeAlimentation() {
		return typeAlimentation;
	}


	public void setTypeAlimentation(TypeAlimentation typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
