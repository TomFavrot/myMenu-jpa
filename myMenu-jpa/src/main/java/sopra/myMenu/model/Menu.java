package sopra.myMenu.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "planning")
public class Menu {
		@Id
		@GeneratedValue
		private Long id;
		@Column(name = "periode")
		private Duration periode;
		@OneToMany(mappedBy = "repas")
		private List<Repas> repas = new ArrayList<Repas>();
		@ManyToOne
		@JoinColumn(name = "planning")
		private Planning planning;
		
		//private final Duration = Duration.of(1, WEEKS);
		
		public Menu() {
			super();
		}
		
		public Menu(Duration periode) {
			super();
			this.periode = periode;
		}
		
		public Menu(Long id, Duration periode) {
			super();
			this.id = id;
			this.periode = periode;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Duration getPeriode() {
			return periode;
		}

		public void setPeriode(Duration periode) {
			this.periode = periode;
		}	
		
}
