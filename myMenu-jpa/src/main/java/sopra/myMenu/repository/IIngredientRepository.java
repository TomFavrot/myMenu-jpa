package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

}
