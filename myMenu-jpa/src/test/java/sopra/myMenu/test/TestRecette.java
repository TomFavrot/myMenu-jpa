package sopra.myMenu.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;

import sopra.myMenu.model.Recette;
import sopra.myMenu.model.TypeAlimentation;

import sopra.myMenu.repository.IRecetteRepository;


public class TestRecette {
	@Test	
	public void RecetteCreate() {
		
		IRecetteRepository recRepo = Application.getInstance().getRecetteRepo();
	
		
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
			
			
		rec1 = recRepo.save(rec1);
		
		Recette recFind = recRepo.findById(rec1.getId());
		
		Assert.assertEquals("couscous", recFind.getNom());
		Assert.assertEquals( "mettre les legumes et le poulet", recFind.getEtapes());
		Assert.assertEquals( 5, recFind.getNombrePers());
		Assert.assertEquals(800, recFind.getTotalCalories());
		Assert.assertEquals(TypeAlimentation.HALAL, recFind.getTypeRecette());
		
		
						
		recRepo.delete(rec1);
		
		
	}
	
	@Test	
	public void RecetteUpdate() {
		
		IRecetteRepository recRepo = Application.getInstance().getRecetteRepo();
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
		
		rec1 = recRepo.save(rec1);
		
							
		rec1.setNom("tartiflette");
		rec1.setEtapes("patate et reblochon");
		rec1.setNombrePers(8);
		rec1.setTotalCalories(500);
		rec1.setTypeRecette(TypeAlimentation.NONE);
		
			
		rec1 = recRepo.save(rec1);
		Recette recFind = recRepo.findById(rec1.getId());
		
		Assert.assertEquals("tartiflette", recFind.getNom());
		Assert.assertEquals( "patate et reblochon", recFind.getEtapes());
		Assert.assertEquals( 8, recFind.getNombrePers());
		Assert.assertEquals(500, recFind.getTotalCalories());
		Assert.assertEquals(TypeAlimentation.NONE, recFind.getTypeRecette());
		
				
		recRepo.delete(rec1);
	}
	
	@Test
	public void RecetteFindAll() {
		
		IRecetteRepository recRepo = Application.getInstance().getRecetteRepo();
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		
		Assert.assertEquals(3, recettes.size());
		
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
			
		
	}
	

	@Test
	public void RecetteDelete() {
		
IRecetteRepository recRepo = Application.getInstance().getRecetteRepo();
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		
		Assert.assertEquals(3, recettes.size());
		
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
		
		recettes = recRepo.findAll();
		
		Assert.assertEquals(0, recettes.size());
	}
}




