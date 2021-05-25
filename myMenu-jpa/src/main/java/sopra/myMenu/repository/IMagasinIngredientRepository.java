package sopra.myMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.MagasinIngredient;

public interface IMagasinIngredientRepository extends JpaRepository<MagasinIngredient, Long>{

//	List<MagasinIngredient> findByRisingPrice();
//
//	List<MagasinIngredient> findByCriteria(String criteria, String marque);

}
