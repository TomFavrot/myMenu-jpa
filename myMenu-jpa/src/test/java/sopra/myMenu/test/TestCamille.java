package sopra.myMenu.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.AjustementQuantite;
import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.Magasin;
import sopra.myMenu.model.MagasinIngredient;
import sopra.myMenu.repository.IAjustementQuantiteRepository;
import sopra.myMenu.repository.IIngredientRepository;
import sopra.myMenu.repository.IMagasinIngredientRepository;
import sopra.myMenu.repository.IMagasinRepository;

public class TestCamille {
	
	@Test
	public void ajustementCreateUpdate() {
		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
		AjustementQuantite ajustement = new AjustementQuantite();
		
		IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();
		Ingredient ingredient = new Ingredient();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		ingredient.setNom("tomate");
		ingredient.setQuantite(3F);		
		ingredient = ingredientRepo.save(ingredient);
		ajustement.setQuantiteModifiee(2F);	
		
		ajustement = ajustementRepo.save(ajustement);
		
		Ingredient ingredFind = ingredientRepo.findById(ingredient.getId());
		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId());
		
		Assert.assertEquals((Float)2.0F, ajustementFind.getQuantiteModifiee());
		ajustementRepo.delete(ajustement);
		ingredientRepo.delete(ingredient);		
	}	
	
	
//	public void listeCourseCreate() {
//		//test de récupération d'un ingrédient dans la liste de course avec ajustement quantité
//		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
//		AjustementQuantite ajustement = new AjustementQuantite();
//		
//		IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();
//		Ingredient ingredient = new Ingredient();
//		List<Ingredient> ingredients = new ArrayList<Ingredient>();
//		
//		ingredient.setNom("tomate");
//		ingredient.setQuantite(3F);		
//		ingredient = ingredientRepo.save(ingredient);
//		ajustement.setQuantiteModifiee(2F);	
//		
//		ajustement = ajustementRepo.save(ajustement);
//		
//		Ingredient ingredFind = ingredientRepo.findById(ingredient.getId());
//		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId());
//		
//		Assert.assertEquals((Float)2.0F, ajustementFind.getQuantiteModifiee());
//		ajustementRepo.delete(ajustement);
//		ingredientRepo.delete(ingredient);	
//	}
	
	//////////////////////////////////////// TEST MAGASIN INGREDIENTS/////////////////////////////////////////////
	@Test
	public void magasinIngredientCreate() {
		IMagasinIngredientRepository magasinIngredientRepo = Application.getInstance().getMagasiningredRepo();
		MagasinIngredient magasinIngred = new MagasinIngredient();
		magasinIngred.setBio(true);
		Date date1 = new Date();
		magasinIngred.setDatePeremption(date1);
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");
		
		try {
			magasinIngred = magasinIngredientRepo.save(magasinIngred);
		} catch(PersistenceException e) {
		}
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId());
		Assert.assertEquals(true, magasinIngredFind.getBio());
		Assert.assertEquals(date1, magasinIngredFind.getDatePeremption());
		Assert.assertEquals((Float)3.5F, magasinIngredFind.getPrix());
		Assert.assertEquals(false, magasinIngredFind.getProduitLocal());
		Assert.assertEquals("marque repère", magasinIngredFind.getMarque());	
		
		magasinIngredientRepo.delete(magasinIngred);
	}
	
	@Test
	public void magasinIngredientUpdate() {
		IMagasinIngredientRepository magasinIngredientRepo = Application.getInstance().getMagasiningredRepo();
		MagasinIngredient magasinIngred = new MagasinIngredient();
		magasinIngred.setBio(true);
		Date date1 = new Date();
		magasinIngred.setDatePeremption(date1);
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");		
		
		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId());
		
		magasinIngred.setBio(false);
		Date date2 = new Date();
		magasinIngred.setDatePeremption(date2);
		magasinIngred.setPrix(6F);
		magasinIngred.setProduitLocal(true); 
		magasinIngred.setMarque("Marie");		
		
		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId());
		
		Assert.assertEquals(false, magasinIngredFind.getBio());
		Assert.assertEquals(date2, magasinIngredFind.getDatePeremption());
		Assert.assertEquals((Float)6F, magasinIngredFind.getPrix());
		Assert.assertEquals(true, magasinIngredFind.getProduitLocal());
		Assert.assertEquals("Marie", magasinIngredFind.getMarque());
		
		magasinIngredientRepo.delete(magasinIngred);
		
	}
	
	@Test
	public void magasinIngredientFindAll() {
		
		IMagasinIngredientRepository magasinIngredRepo = Application.getInstance().getMagasiningredRepo();		
		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		
		magasinIngred1.setBio(true);
		Date date1 = new Date();
		magasinIngred1.setDatePeremption(date1);
		magasinIngred1.setPrix(3.5F);
		magasinIngred1.setProduitLocal(false);
		magasinIngred1.setMarque("marque repère");
		
		magasinIngred1 = magasinIngredRepo.save(magasinIngred1);		
		
		MagasinIngredient magasinIngred2 = new MagasinIngredient();
		
		magasinIngred2.setBio(false);
		Date date2= new Date();
		magasinIngred2.setDatePeremption(date2);
		magasinIngred2.setPrix(5F);
		magasinIngred2.setProduitLocal(true);
		magasinIngred2.setMarque("Marie");
		
		magasinIngred2 = magasinIngredRepo.save(magasinIngred2);			
		
		List<MagasinIngredient> magasinIngredients = magasinIngredRepo.findAll();
		
		Assert.assertEquals(2, magasinIngredients.size());
		
		magasinIngredRepo.delete(magasinIngred1);
		magasinIngredRepo.delete(magasinIngred2);		
		
	}
	
	@Test
	public void magasinIngredientDelete() {
		
		IMagasinIngredientRepository magasinIngredRepo = Application.getInstance().getMagasiningredRepo();		
		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
		MagasinIngredient magasinIngred2 = new MagasinIngredient(); 
						
		magasinIngred1 = magasinIngredRepo.save(magasinIngred1);
		magasinIngred2 = magasinIngredRepo.save(magasinIngred2);	
		
		List<MagasinIngredient> magasinIngredients = magasinIngredRepo.findAll();
		
		Assert.assertEquals(2, magasinIngredients.size());
		
		magasinIngredRepo.delete(magasinIngred1);
		magasinIngredRepo.delete(magasinIngred2);		
		
		magasinIngredients = magasinIngredRepo.findAll();
		
		Assert.assertEquals(0, magasinIngredients.size());
	
}
	
////////////////////////////////////////TEST MAGASIN /////////////////////////////////////////////
	@Test
	public void magasinCreate() {
		IMagasinRepository magasinRepo = Application.getInstance().getMagasinRepo();
		Magasin magasin = new Magasin();
		
		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");
		
		try {
			magasin = magasinRepo.save(magasin);
		} catch(PersistenceException e) {
		}
		Magasin magasinFind = magasinRepo.findById(magasin.getId());

		Assert.assertEquals("Carrefour", magasinFind.getNom());	
		Assert.assertEquals("123456789", magasinFind.getSiret());	
		
		magasinRepo.delete(magasin);
	}
	
	@Test
	public void magasinUpdate() {
		IMagasinRepository magasinRepo = Application.getInstance().getMagasinRepo();
		Magasin magasin = new Magasin();
		
		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");		
		
		magasin = magasinRepo.save(magasin);		
		Magasin magasinFind = magasinRepo.findById(magasin.getId());
		
		magasin.setNom("Leclerc"); 
		magasin.setSiret("987654321");	 
		
		magasin = magasinRepo.save(magasin);		
		magasinFind = magasinRepo.findById(magasin.getId());
		
		Assert.assertEquals("Leclerc", magasinFind.getNom());	
		Assert.assertEquals("987654321", magasinFind.getSiret());	
		
		magasinRepo.delete(magasin);
	}
}
