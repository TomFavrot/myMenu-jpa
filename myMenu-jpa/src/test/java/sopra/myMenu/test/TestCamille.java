package sopra.myMenu.test;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.myMenu.model.AjustementQuantite;
import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.ListeCourse;
import sopra.myMenu.model.Magasin;
import sopra.myMenu.model.MagasinIngredient;
import sopra.myMenu.repository.IAjustementQuantiteRepository;
import sopra.myMenu.repository.IIngredientRepository;
import sopra.myMenu.repository.IListeCourseRepository;
import sopra.myMenu.repository.IMagasinIngredientRepository;
import sopra.myMenu.repository.IMagasinRepository;

public class TestCamille {

	////////////////////////////////////////TEST AJUSTEMENT QUANTITE/////////////////////////////////////////////
	@Test
	public void ajustementCreateSimple() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	

		ajustement = ajustementRepo.save(ajustement); 

		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId()).get();

		Assert.assertEquals((Float)2.0F, ajustementFind.getQuantiteModifiee());
		ajustementRepo.delete(ajustement); 

	}	

	@Test
	public void ajustementCreateAvecLiens() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IIngredientRepository ingredientRepo = context.getBean(IIngredientRepository.class);

		Ingredient ingredient1 = new Ingredient();
		ingredient1.setNom("tomate");
		ingredient1.setQuantite(3F);
		ingredient1 = ingredientRepo.save(ingredient1);

		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
		AjustementQuantite ajustement1 = new AjustementQuantite();			
		ajustement1.setQuantiteModifiee(2F);
		
		ingredient1.setAjustementQuantite(ajustement1);
		
		ajustement1 = ajustementRepo.save(ajustement1);
		
		ingredient1 = ingredientRepo.save(ingredient1);

		List<AjustementQuantite> ajustementFind = ajustementRepo.findAll();

		Assert.assertEquals((Float)2F,ajustementFind.get(0).getQuantiteModifiee());		
		
		ingredientRepo.delete(ingredient1); 
		ajustementRepo.delete(ajustement1);

	}	

	@Test
	public void ajustementUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);	
		ajustement = ajustementRepo.save(ajustement);
		AjustementQuantite ajustementFind = ajustementRepo.findById(ajustement.getId()).get();

		ajustement.setQuantiteModifiee(6F);	
		ajustement = ajustementRepo.save(ajustement);
		ajustementFind = ajustementRepo.findById(ajustement.getId()).get();

		Assert.assertEquals((Float)6F, ajustementFind.getQuantiteModifiee());
		ajustementRepo.delete(ajustement);

	}	

	@Test
	public void ajustementFindAll() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);

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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
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
		ajustementRepo.delete(ajustement1);
		ajustementRepo.delete(ajustement2);	
		
	}


	////////////////////////////////////////TEST LISTE COURSE/////////////////////////////////////////////

	@Test
	public void listeCourseCreateAvecLien() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IIngredientRepository ingredientRepo = context.getBean(IIngredientRepository.class);
		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setNom("tomate");
		ingredient1.setQuantite(3F);			
		ingredient1 = ingredientRepo.save(ingredient1);

		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
		
		AjustementQuantite ajustement1 = new AjustementQuantite();
		ajustement1.setQuantiteModifiee(2F);
		
		ingredient1.setAjustementQuantite(ajustement1);
		
		ingredient1 = ingredientRepo.save(ingredient1);

		ajustement1 = ajustementRepo.save(ajustement1);	

		IListeCourseRepository listeCourseRepo = context.getBean(IListeCourseRepository.class);
		ListeCourse listeCourse1 = new ListeCourse();

		listeCourse1.setAjustementQuantite(ajustement1);
		listeCourse1 = listeCourseRepo.save(listeCourse1);
		
		List<Ingredient> ingredients = ingredientRepo.findAll();
		
		ajustement1.setIngredients(ingredients);
		
		ajustementRepo.save(ajustement1);
		ListeCourse listeFind = listeCourseRepo.findById(listeCourse1.getId()).get();
		
		Assert.assertEquals((Float)2F,listeFind.getAjustementQuantite().getQuantiteModifiee());			

		listeCourseRepo.delete(listeCourse1);
		ajustementRepo.delete(ajustement1);
		ingredientRepo.delete(ingredient1);
	}

	@Test
	public void listeCourseCreateSimple() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IListeCourseRepository listeRepo = context.getBean(IListeCourseRepository.class);
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

	@Test
	public void listeCourseUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IIngredientRepository ingredientRepo = context.getBean(IIngredientRepository.class);
		Ingredient ingredient = new Ingredient();
		ingredient.setNom("tomate");
		ingredient.setQuantite(3F);		
		
		ingredient = ingredientRepo.save(ingredient);

		IAjustementQuantiteRepository ajustementRepo = context.getBean(IAjustementQuantiteRepository.class);
		AjustementQuantite ajustement = new AjustementQuantite();

		ajustement.setQuantiteModifiee(2F);
		ingredient.setAjustementQuantite(ajustement);
			
		ajustement = ajustementRepo.save(ajustement);
		ingredient = ingredientRepo.save(ingredient);				
	
		IListeCourseRepository listeCourseRepo = context.getBean(IListeCourseRepository.class);
		ListeCourse listeCourse = new ListeCourse();
		
		listeCourse.setAjustementQuantite(ajustement);	
		listeCourse = listeCourseRepo.save(listeCourse);
		
		ajustement.setQuantiteModifiee(6F);
		ingredient.setAjustementQuantite(ajustement);
			
		ajustement = ajustementRepo.save(ajustement);
		ingredient = ingredientRepo.save(ingredient);		
		
		listeCourse.setAjustementQuantite(ajustement);
		listeCourse = listeCourseRepo.save(listeCourse);
		
		ListeCourse listeFind = listeCourseRepo.findById(listeCourse.getId()).get();

		Assert.assertEquals(listeCourse.getAjustementQuantite().getQuantiteModifiee(),listeFind.getAjustementQuantite().getQuantiteModifiee());
		listeCourseRepo.delete(listeCourse);
		ingredientRepo.delete(ingredient);		
		ajustementRepo.delete(ajustement);

	}	

	@Test
	public void listeCourseFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IListeCourseRepository listeRepo = context.getBean(IListeCourseRepository.class);
		ListeCourse liste1 = new ListeCourse();	
		ListeCourse liste2 = new ListeCourse();	

		liste1 = listeRepo.save(liste1);
		liste2 = listeRepo.save(liste2);			

		List<ListeCourse> listeCourses = listeRepo.findAll();

		Assert.assertEquals(2, listeCourses.size());

		listeRepo.delete(liste1);
		listeRepo.delete(liste2);	

	}

	@Test
	public void listeCourseDelete() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IListeCourseRepository listeRepo = context.getBean(IListeCourseRepository.class);
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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IMagasinIngredientRepository magasinIngredientRepo = context.getBean(IMagasinIngredientRepository.class);
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
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();
		Assert.assertEquals(true, magasinIngredFind.getBio());
		Assert.assertEquals(date1, magasinIngredFind.getDatePeremption());
		Assert.assertEquals((Float)3.5F, magasinIngredFind.getPrix());
		Assert.assertEquals(false, magasinIngredFind.getProduitLocal());
		Assert.assertEquals("marque repère", magasinIngredFind.getMarque());	

		magasinIngredientRepo.delete(magasinIngred);
	} 

	@Test
	public void magasinIngredientUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IMagasinIngredientRepository magasinIngredientRepo = context.getBean(IMagasinIngredientRepository.class);
		MagasinIngredient magasinIngred = new MagasinIngredient();
		magasinIngred.setBio(true);
		Date date1 = new Date();
		magasinIngred.setDatePeremption(date1);
		magasinIngred.setPrix(3.5F);
		magasinIngred.setProduitLocal(false);
		magasinIngred.setMarque("marque repère");		

		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		MagasinIngredient magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();

		magasinIngred.setBio(false);
		Date date2 = new Date();
		magasinIngred.setDatePeremption(date2);
		magasinIngred.setPrix(6F);
		magasinIngred.setProduitLocal(true); 
		magasinIngred.setMarque("Marie");		

		magasinIngred = magasinIngredientRepo.save(magasinIngred);
		magasinIngredFind = magasinIngredientRepo.findById(magasinIngred.getId()).get();

		Assert.assertEquals(false, magasinIngredFind.getBio());
		Assert.assertEquals(date2, magasinIngredFind.getDatePeremption());
		Assert.assertEquals((Float)6F, magasinIngredFind.getPrix());
		Assert.assertEquals(true, magasinIngredFind.getProduitLocal());
		Assert.assertEquals("Marie", magasinIngredFind.getMarque());

		magasinIngredientRepo.delete(magasinIngred); 

	}

	@Test
	public void magasinIngredientFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IMagasinIngredientRepository magasinIngredRepo = context.getBean(IMagasinIngredientRepository.class);		
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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IMagasinIngredientRepository magasinIngredRepo = context.getBean(IMagasinIngredientRepository.class);		
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
		
		magasinIngredRepo.delete(magasinIngred1);
		magasinIngredRepo.delete(magasinIngred2);	

	}
	
//	@Test
//	public void magasinIngredientFindByBrand() {
//		IMagasinIngredientRepository magasinIngredRepo = Application.getInstance().getMagasiningredRepo();		
//		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
//		MagasinIngredient magasinIngred2 = new MagasinIngredient();
//		
//		magasinIngred1.setBio(true);
//		Date date1 = new Date();
//		magasinIngred1.setDatePeremption(date1);
//		magasinIngred1.setPrix(3.5F);
//		magasinIngred1.setProduitLocal(false);
//		magasinIngred1.setMarque("marque repère");
//		
//		magasinIngred1 = magasinIngredRepo.save(magasinIngred1);
//		
//		magasinIngred2.setBio(false);
//		Date date2= new Date();
//		magasinIngred2.setDatePeremption(date2);
//		magasinIngred2.setPrix(5F);
//		magasinIngred2.setProduitLocal(true);
//		magasinIngred2.setMarque("Marie");
//		
//		magasinIngred2 = magasinIngredRepo.save(magasinIngred2);			
//
//		List<MagasinIngredient> marqueMarie = magasinIngredRepo.findByBrand("Marie");
//		Assert.assertEquals(magasinIngred2.getId(), marqueMarie.get(0).getId());
//		magasinIngredRepo.delete(magasinIngred1);
//		magasinIngredRepo.delete(magasinIngred2);
//	
//	}
	
//	@Test
//	public void magasinIngredientFindByCriteria() {
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//		IMagasinIngredientRepository magasinIngredRepo = context.getBean(IMagasinIngredientRepository.class);		
//		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
//		MagasinIngredient magasinIngred2 = new MagasinIngredient();
//		
//		magasinIngred1.setBio(true);
//		Date date1 = new Date();
//		magasinIngred1.setDatePeremption(date1);
//		magasinIngred1.setPrix(3.5F);
//		magasinIngred1.setProduitLocal(false);
//		magasinIngred1.setMarque("marque repère");
//		
//		magasinIngred1 = magasinIngredRepo.save(magasinIngred1);
//		
//		magasinIngred2.setBio(false);
//		Date date2= new Date();
//		magasinIngred2.setDatePeremption(date2);
//		magasinIngred2.setPrix(5F);
//		magasinIngred2.setProduitLocal(true);
//		magasinIngred2.setMarque("Marie");
//		
//		magasinIngred2 = magasinIngredRepo.save(magasinIngred2);			
//		// criteria : "marque", "bio" ou "produitLocal"
//		List<MagasinIngredient> marqueMarie = magasinIngredRepo.findByCriteria("marque", "Marie");
//		Assert.assertEquals(magasinIngred2.getId(), marqueMarie.get(0).getId());
//		
//		List<MagasinIngredient> marqueBio = magasinIngredRepo.findByCriteria("bio", null);
//		Assert.assertEquals(magasinIngred1.getId(), marqueBio.get(0).getId());
//		
//		List<MagasinIngredient> marqueLocale = magasinIngredRepo.findByCriteria("produitLocal", null);
//		Assert.assertEquals(magasinIngred2.getId(), marqueLocale.get(0).getId());
//		
//		magasinIngredRepo.delete(magasinIngred1);
//		magasinIngredRepo.delete(magasinIngred2);
//	
//	}
	
//	@Test
//	public void magasinIngredientFindByRisingPrice() {
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:application-context.xml");
//		IMagasinIngredientRepository magasinIngredRepo = context.getBean(IMagasinIngredientRepository.class);		
//		MagasinIngredient magasinIngred1 = new MagasinIngredient(); 
//		MagasinIngredient magasinIngred2 = new MagasinIngredient();
//		
//		magasinIngred1.setBio(true);
//		Date date1 = new Date();
//		magasinIngred1.setDatePeremption(date1);
//		magasinIngred1.setPrix(3.5F);
//		magasinIngred1.setProduitLocal(false);
//		magasinIngred1.setMarque("marque repère");
//		
//		magasinIngred1 = magasinIngredRepo.save(magasinIngred1);
//		
//		magasinIngred2.setBio(false);
//		Date date2= new Date();
//		magasinIngred2.setDatePeremption(date2);
//		magasinIngred2.setPrix(5F);
//		magasinIngred2.setProduitLocal(true);
//		magasinIngred2.setMarque("Marie");
//		
//		magasinIngred2 = magasinIngredRepo.save(magasinIngred2);			
//
//		List<MagasinIngredient> magasinsParPrix = magasinIngredRepo.findByRisingPrice();
//		Assert.assertEquals(magasinIngred1.getId(), magasinsParPrix.get(0).getId());
//		Assert.assertEquals(magasinIngred2.getId(), magasinsParPrix.get(1).getId());
//		magasinIngredRepo.delete(magasinIngred1);
//		magasinIngredRepo.delete(magasinIngred2);
//	
//	}
	
	

	////////////////////////////////////////TEST MAGASIN /////////////////////////////////////////////
	@Test
	public void magasinCreate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IMagasinRepository magasinRepo = context.getBean(IMagasinRepository.class);
		Magasin magasin = new Magasin();

		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");

		try {
			magasin = magasinRepo.save(magasin);
		} catch(PersistenceException e) {
		}
		Magasin magasinFind = magasinRepo.findById(magasin.getId()).get();

		Assert.assertEquals("Carrefour", magasinFind.getNom());	
		Assert.assertEquals("123456789", magasinFind.getSiret());	

		magasinRepo.delete(magasin); 
	}

	@Test
	public void magasinUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		IMagasinRepository magasinRepo = context.getBean(IMagasinRepository.class);
		Magasin magasin = new Magasin();

		magasin.setNom("Carrefour");
		magasin.setSiret("123456789");		

		magasin = magasinRepo.save(magasin);		
		Magasin magasinFind = magasinRepo.findById(magasin.getId()).get();

		magasin.setNom("Leclerc"); 
		magasin.setSiret("987654321");	 

		magasin = magasinRepo.save(magasin);		
		magasinFind = magasinRepo.findById(magasin.getId()).get();

		Assert.assertEquals("Leclerc", magasinFind.getNom());	
		Assert.assertEquals("987654321", magasinFind.getSiret());	

		magasinRepo.delete(magasin);
	}

	@Test
	public void magasinFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IMagasinRepository magasinRepo = context.getBean(IMagasinRepository.class);		
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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IMagasinRepository magasinRepo = context.getBean(IMagasinRepository.class);		
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
