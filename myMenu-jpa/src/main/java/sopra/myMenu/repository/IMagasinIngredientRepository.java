package sopra.myMenu.repository;

import java.util.List;

import sopra.myMenu.model.MagasinIngredient;

public interface IMagasinIngredientRepository extends IRepository<MagasinIngredient, Long>{

//	List<MagasinIngredient> findByBrand(String marque);

	List<MagasinIngredient> findByRisingPrice();

	List<MagasinIngredient> findByCriteria(String criteria, String marque);

}
