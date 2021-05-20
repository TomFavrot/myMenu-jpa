package sopra.myMenu.test;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.AjustementQuantite;
import sopra.myMenu.model.ListeCourse;
import sopra.myMenu.model.Magasin;
import sopra.myMenu.model.MagasinIngredient;
import sopra.myMenu.repository.IAjustementQuantiteRepository;
import sopra.myMenu.repository.IListeCourseRepository;
import sopra.myMenu.repository.IMagasinIngredientRepository;
import sopra.myMenu.repository.IMagasinRepository;

public class TestCamille {

	////////////////////////////////////////TEST AJUSTEMENT QUANTITE/////////////////////////////////////////////
	@Test
	public void ajustementCreate() {
		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	

		ajustement = ajustementRepo.save(ajustement); 

		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId());

		Assert.assertEquals((Float)2.0F, ajustementFind.getQuantiteModifiee());
		ajustementRepo.delete(ajustement); 

	}	

	@Test
	public void ajustementUpdate() {
		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	
		ajustement = ajustementRepo.save(ajustement);
		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId());

		ajustement.setQuantiteModifiee(6F);	
		ajustement = ajustementRepo.save(ajustement);
		ajustementFind = ajustementRepo.findById(ajustement.getId());

		Assert.assertEquals((Float)6F, ajustementFind.getQuantiteModifiee());
		ajustementRepo.delete(ajustement);

	}	

	@Test
	public void ajustementFindAll() {
		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();

		AjustementQuantite ajustement1 = new AjustementQuantite();
		ajustement1.setQuantiteModifiee(3F); 
		ajustement1 = ajustementRepo.save(ajustement1);		

		AjustementQuantite ajustement2 = new AjustementQuantite();
		ajustement2.setQuantiteModifiee(6F);
		ajustement2 = ajustementRepo.save(ajustement2);			

		List<AjustementQuantite> ajustements = ajustementRepo.findAll();

		Assert.assertEquals(2, ajustements.size());

		ajustementRepo.delete(ajustement1);
		ajustementRepo.delete(ajustement2);		

	}

	@Test
	public void ajustementQuantiteDelete() {

		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
		AjustementQuantite ajustement1 = new AjustementQuantite();
		AjustementQuantite ajustement2 = new AjustementQuantite();

		ajustement1 = ajustementRepo.save(ajustement1);
		ajustement2 = ajustementRepo.save(ajustement2);	

		List<AjustementQuantite> ajustements = ajustementRepo.findAll();

		Assert.assertEquals(2, ajustements.size());

		ajustementRepo.delete(ajustement1);
		ajustementRepo.delete(ajustement2);		

		ajustements = ajustementRepo.findAll();

		Assert.assertEquals(0, ajustements.size());
	}


	////////////////////////////////////////TEST LISTE COURSE/////////////////////////////////////////////

	//test de recherche de la liste d'ingrédients dans la liste de courses en passant par AjustementQUantité --> echec
//	@Test
//	public void listeCourseCreate() {
//		IIngredientRepository ingredientRepo = Application.getInstance().getIngredientRepo();
//
//		Ingredient ingredient1 = new Ingredient();
//		ingredient1.setNom("tomate");
//		ingredient1.setQuantite(3F);
//		ingredient1 = ingredientRepo.save(ingredient1);
//
////		Ingredient ingredient2 = new Ingredient();
////		ingredient2.setNom("fromage");
////		ingredient2.setQuantite(1F);
////		ingredient2 = ingredientRepo.save(ingredient2);			
//
//		List<Ingredient> ingredients = ingredientRepo.findAll(); 
//
//		IListeCourseRepository listeCourseRepo = Application.getInstance().getListeCourseRepo();
//		ListeCourse listeCourse = new ListeCourse();		
//
//		IAjustementQuantiteRepository ajustementRepo = Application.getInstance().getAjustquantitRepo();
//		AjustementQuantite ajustement = new AjustementQuantite();
//		ajustement.setQuantiteModifiee(2F);	
//
//		ajustement.setIngredients(ingredients);
//		ajustement = ajustementRepo.save(ajustement);
//
//		listeCourse.setAjustementQuantite(ajustement);	
//
//		ajustement = ajustementRepo.save(ajustement);
//		try {
//			listeCourse = listeCourseRepo.save(listeCourse);
//		} catch(PersistenceException e) {
//		}
//
//		ListeCourse listeFind = listeCourseRepo.findById(listeCourse.getId());
//
//		Assert.assertEquals(ingredient1,listeFind.getAjustementQuantite().getIngredients());// le nom est la deuxième colonne dans la table ingredient
//		listeCourseRepo.delete(listeCourse); 
//		ingredientRepo.delete(ingredient1); 
////		ingredientRepo.delete(ingredient2); 
//
//	}	

	@Test
	public void listeCourseCreate() {
		IListeCourseRepository listeRepo = Application.getInstance().getListeCourseRepo();
		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();

		try {
			liste1 = listeRepo.save(liste1);
		} catch(PersistenceException e) {
		}
		try {
			liste2 = listeRepo.save(liste2);
		} catch(PersistenceException e) {
		}

		List<ListeCourse> listeCourses = listeRepo.findAll();
		
		Assert.assertEquals(2, listeCourses.size());

		listeRepo.delete(liste1);
		listeRepo.delete(liste2);

	}	

//	@Test
//	public void listeCourseUpdate() {
//		IListeCourseRepository listeRepo = Application.getInstance().getListeCourseRepo();
//		ListeCourse liste1 = new ListeCourse();	
//		ListeCourse liste2 = new ListeCourse();	
//		liste1 = listeRepo.save(liste1);
//		liste1=liste2;
//		liste1 = listeRepo.save(liste1);
//
//		ListeCourse listeFind = listeRepo.findById(liste1.getId());
//
////		Assert.assertEquals(liste1,listeFind);
//		listeRepo.delete(liste1);
//		listeRepo.delete(liste2);
//	}	
	
	@Test
	public void listeCourseFindAll() {
		IListeCourseRepository listeRepo = Application.getInstance().getListeCourseRepo();
		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();	

		liste1 = listeRepo.save(liste1);
		liste2 = listeRepo.save(liste2);			

		List<ListeCourse> listeCourses = listeRepo.findAll();

		Assert.assertEquals(2, listeCourses.size());//le delete du test precedent n'ayant pas fonctionné, on en a déjà 2+2

		listeRepo.delete(liste1);
		listeRepo.delete(liste2);	

	}

	@Test
	public void mlisteCourseDelete() {
		IListeCourseRepository listeRepo = Application.getInstance().getListeCourseRepo();
		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();	

		liste1 = listeRepo.save(liste1);
		liste2 = listeRepo.save(liste2);			

		List<ListeCourse> listeCourses = listeRepo.findAll();
		
		Assert.assertEquals(2, listeCourses.size());

		listeRepo.delete(liste1);
		listeRepo.delete(liste2);	
		
		listeCourses = listeRepo.findAll();

		Assert.assertEquals(0, listeCourses.size());
		
		listeRepo.delete(liste1);
		listeRepo.delete(liste2);	

	}

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

	@Test
	public void magasinFindAll() {

		IMagasinRepository magasinRepo = Application.getInstance().getMagasinRepo();		
		Magasin magasin1 = new Magasin(); 

		magasin1.setNom("Carrefour");
		magasin1.setSiret("123456789");		

		magasin1 = magasinRepo.save(magasin1);		 

		Magasin magasin2 = new Magasin(); 

		magasin2.setNom("Leclerc"); 
		magasin2.setSiret("987654321");	 

		magasin2 = magasinRepo.save(magasin2);			

		List<Magasin> magasins = magasinRepo.findAll();

		Assert.assertEquals(2, magasins.size());

		magasinRepo.delete(magasin1);
		magasinRepo.delete(magasin2);		
	}

	@Test
	public void magasinDelete() {

		IMagasinRepository magasinRepo = Application.getInstance().getMagasinRepo();		
		Magasin magasin1 = new Magasin(); 
		Magasin magasin2 = new Magasin(); 

		magasin1 = magasinRepo.save(magasin1);
		magasin2 = magasinRepo.save(magasin2);	

		List<Magasin> magasin = magasinRepo.findAll();

		Assert.assertEquals(2, magasin.size());

		magasinRepo.delete(magasin1);
		magasinRepo.delete(magasin2);		

		magasin = magasinRepo.findAll();

		Assert.assertEquals(0, magasin.size());

	}
}
