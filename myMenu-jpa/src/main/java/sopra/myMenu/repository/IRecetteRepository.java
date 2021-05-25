package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Recette;

public interface IRecetteRepository extends JpaRepository<Recette, Long>{

}
