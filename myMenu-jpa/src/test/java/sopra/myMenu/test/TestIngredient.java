package sopra.myMenu.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.Ingredient;

import sopra.myMenu.repository.IIngredientRepository;


//public class TestIngredient {

//	@Test	
//	public void IngredientCreate() {
//		
//		IIngredientRepository ingRepo = Application.getInstance().getIngredientRepo();
//		
//		
//		Ingredient  ing1 = new Ingredient ();
//				
//			
//		ing1 = ingRepo.save(ing1);
//		
//		Ingredient  ingcFind = ingRepo.findById(ing1.getId());
		
//		Assert.assertEquals("couscous", recFind.getNom());
//		Assert.assertEquals( "mettre les legumes et le poulet", recFind.getEtapes());
//		Assert.assertEquals( 5, recFind.getNombrePers());
//		Assert.assertEquals(800, recFind.getTotalCalories());
//		Assert.assertEquals(TypeAlimentation.HALAL, recFind.getTypeRecette());
		
		
				
		//ingRepo.delete(ing1);
		
		
	//}
	
//	@Test	
//	public void RecetteUpdate() {
//		
//		IIngredientRepository ingRepo = Application.getInstance().getIngredientRepo();
//		
		//Ingredient  ing1 = new Ingredient();
		
		//ing1 = ingRepo.save(ing1);
		
							
//		ing1.setNom("tartiflette");
//		ing1.setEtapes("patate et reblochon");
//		ing1.setNombrePers(8);
//		ing1.setTotalCalories(500);
//		ing1.setTypeRecette(TypeAlimentation.NONE);
//			
//		ing1 = ingRepo.save(ing1);
//		Recette ingFind = recRepo.findById(ing1.getId());
//		
//		Assert.assertEquals("tartiflette", ingFind.getNom());
//		Assert.assertEquals( "patate et reblochon", ingFind.getEtapes());
//		Assert.assertEquals( 8, ingFind.getNombrePers());
//		Assert.assertEquals(500, ingFind.getTotalCalories());
//		Assert.assertEquals(TypeAlimentation.NONE, ingFind.getTypeRecette());
//		
//				
//		recRepo.delete(ing1);
//	}
//	
//	@Test
//	public void IngredientFindAll() {
//		
//		IIngredient Repository ingRepo = Application.getInstance().getIngredient Repo();
//		
//		Ingredient  ing1 = new Ingredient ("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
//						
//		Ingredient  ing2 = new Ingredient ("tartiflette", "patate et reblochon", 5, 800, TypeAlimentation.NONE);
//		
//		Ingredient  ing3 = new Ingredient ("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
//
//		ing1 = recRepo.save(ing1);
//		ing2 = recRepo.save(ing2);
//		ing3 = recRepo.save(ing3);
//			
//		
//		List<Ingredient> ingredients  = ingRepo.findAll();
//		
//		Assert.assertEquals(3, ingredients.size());
//		
//		ingRepo.delete(ing1);
//		ingRepo.delete(ing2);
//		ingRepo.delete(ing3);
//			
//		
//	}
//	
//
//	@Test
//	public void IngredientDelete() {
//		
//IRecetteRepository recRepo = Application.getInstance().getRecetteRepo();
//		
//		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
//						
//		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800, TypeAlimentation.NONE);
//		
//		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
//
//		rec1 = recRepo.save(rec1);
//		rec2 = recRepo.save(rec2);
//		rec3 = recRepo.save(rec3);
//			
//		
//		List<Ingredient > ingredients  = recRepo.findAll();
//		
//		Assert.assertEquals(3, recettes.size());
//		
//		recRepo.delete(rec1);
//		recRepo.delete(rec2);
//		recRepo.delete(rec3);
//		
//		ingredients = recRepo.findAll();
//		
//		Assert.assertEquals(0, ingredients.size());
//	}
//}
//
//
//
//
//
//
