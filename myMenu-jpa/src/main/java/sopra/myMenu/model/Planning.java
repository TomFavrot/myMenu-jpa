package sopra.myMenu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planning")
public class Planning {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "jour")
	private Date jour;
	@OneToMany(mappedBy = "planning")
	private List<Menu> menus = new ArrayList<Menu>(); 
	@OneToOne(mappedBy = "objectif_id")
	private Objectif objectif;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Planning() {
		super();
	}
	
	public Planning(Date jour) {
		super();
		this.jour = jour;
	}
	
	public Planning(Long id, Date jour) {
		super();
		this.id = id;
		this.jour = jour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}
	
}
