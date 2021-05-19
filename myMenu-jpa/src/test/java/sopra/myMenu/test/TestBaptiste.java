package sopra.myMenu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.Adresse;
import sopra.myMenu.model.Coordonnees;
import sopra.myMenu.model.Genre;
import sopra.myMenu.model.PhysicalActivity;
import sopra.myMenu.model.PreferenceAlimentaire;
import sopra.myMenu.model.TypeAlimentation;
import sopra.myMenu.model.Utilisateur;
import sopra.myMenu.repository.IAdresseRepository;
import sopra.myMenu.repository.IPreferenceAlimentaireRepository;
import sopra.myMenu.repository.IUtilisateurRepository;

public class TestBaptiste {

	@Test
	public void utilisateurAdressePreferenceAlimentaireCreate() {

		// CREATION UTILISATEUR
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		Utilisateur tom = new Utilisateur();
		try {
			tom.setDateNaissance(sdf.parse("10/05/1994"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tom.setGenre(Genre.NON_BINAIRE);
		tom.setImc(18.0F);
		tom.setNom("Favrot");
		tom.setPrenom("Tom");
		tom.setPhysicalActivity(PhysicalActivity.PANTOUFLARD);
		tom.setPoids(77.5F);
		tom.setTaille(177.5F);

		// CREATION PREF ALIM
		IPreferenceAlimentaireRepository prefAlimRepo = Application.getInstance().getPreferencealimRepo();
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

		//tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		//adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));

		//tom.addAdresse(adr);

		try {

			tom = utilisateurRepo.save(tom);
			prefAlim = prefAlimRepo.save(prefAlim);
			adr = adresseRepo.save(adr);

			// Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch (PersistenceException e) {
		}
		Utilisateur tomFind = utilisateurRepo.findById(tom.getId());

		// TEST UTILISATEUR
		Assert.assertEquals(Genre.NON_BINAIRE, tomFind.getGenre());
		Assert.assertEquals(PhysicalActivity.PANTOUFLARD, tomFind.getPhysicalActivity());
		try {
			Assert.assertEquals(sdf.parse("10/05/1994"), tomFind.getDateNaissance());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(18.0F, tomFind.getImc(), 0.0F);
		Assert.assertEquals(77.5F, tomFind.getPoids(), 0.0F);
		Assert.assertEquals(177.5F, tomFind.getTaille(), 0.0F);

		Assert.assertEquals("Favrot", tomFind.getNom());
		Assert.assertEquals("Tom", tomFind.getPrenom());

		// TEST PREF ALIM
		PreferenceAlimentaire prefFind = prefAlimRepo.findById(prefAlim.getId());
		Assert.assertEquals(TypeAlimentation.NONE, prefFind.getTypeAlimentation());

		// TEST ADRESSE
		Adresse adrFind = adresseRepo.findById(adr.getId());
		
		System.out.println(adrFind.toString());
		
		Assert.assertEquals("33000", adrFind.getCodePostal());
		Assert.assertEquals("Residence plikepluck", adrFind.getComplement());
		Assert.assertEquals("33 rue IKEA", adrFind.getRue());
		Assert.assertEquals("France", adrFind.getPays());
		Assert.assertEquals("Bordeaux", adrFind.getVille());
		Assert.assertEquals(4.0, adrFind.getCoordonnees().getLongitude(), 0.0);
		Assert.assertEquals(88.0, adrFind.getCoordonnees().getLatitude(), 0.0);

		utilisateurRepo.delete(tomFind);
		utilisateurRepo.delete(tom);
		adresseRepo.delete(adrFind);
		adresseRepo.delete(adr);
		prefAlimRepo.delete(prefFind);
		prefAlimRepo.delete(prefAlim);
	}

	@Test
	public void utilisateurAdressePreferenceAlimentaireUpdate() {
		// CREATION UTILISATEUR
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		Utilisateur tom = new Utilisateur();
		try {
			tom.setDateNaissance(sdf.parse("10/05/1994"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tom.setGenre(Genre.NON_BINAIRE);
		tom.setImc(18.0F);
		tom.setNom("Favrot");
		tom.setPrenom("Tom");
		tom.setPhysicalActivity(PhysicalActivity.PANTOUFLARD);
		tom.setPoids(77.5F);
		tom.setTaille(177.5F);

		// CREATION PREF ALIM
		IPreferenceAlimentaireRepository prefAlimRepo = Application.getInstance().getPreferencealimRepo();
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

		//tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		//adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));

		//tom.addAdresse(adr);
		
		// AFFICHAGE adr console java
		System.out.println(adr.toString());
		
		// TEST UTILISATEUR
		tom = utilisateurRepo.save(tom);
		tom = utilisateurRepo.findById(tom.getId());

		tom.setGenre(Genre.HOMME);
		try {
			tom.setDateNaissance(sdf.parse("14/01/1874"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tom.setImc(77.0F);
		tom.setNom("Favori");
		tom.setPhysicalActivity(PhysicalActivity.INTENSIF);
		tom.setPoids(67.5F);
		tom.setPrenom("Thomas");
		tom.setTaille(167.5F);

		tom = utilisateurRepo.save(tom);

		tom = utilisateurRepo.findById(tom.getId());

		Assert.assertEquals(Genre.HOMME, tom.getGenre());
		Assert.assertEquals(PhysicalActivity.INTENSIF, tom.getPhysicalActivity());
		try {
			Assert.assertEquals(sdf.parse("14/01/1874"), tom.getDateNaissance());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(77.0F, tom.getImc(), 0.0F);
		Assert.assertEquals(67.5F, tom.getPoids(), 0.0F);
		Assert.assertEquals(167.5F, tom.getTaille(), 0.0F);

		Assert.assertEquals("Favori", tom.getNom());
		Assert.assertEquals("Thomas", tom.getPrenom());
		
		
		// TEST ADRESSE
		adr = adresseRepo.save(adr);
		adr = adresseRepo.findById(adr.getId());

		adr.setCodePostal("33555");
		adr.setComplement("Residence Brook OEP Langedek");
		adr.setRue("33 rue HEMA");
		adr.setPays("Espagne");
		adr.setVille("SantaMariaPutaCruz");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(99.0, 35.0));

		adr = adresseRepo.save(adr);
		adr = adresseRepo.findById(adr.getId());

		Assert.assertEquals("33555", adr.getCodePostal());
		Assert.assertEquals("Residence Brook OEP Langedek", adr.getComplement());
		Assert.assertEquals("33 rue HEMA", adr.getRue());
		Assert.assertEquals("Espagne", adr.getPays());
		Assert.assertEquals("SantaMariaPutaCruz", adr.getVille());
		Assert.assertEquals(99.0, adr.getCoordonnees().getLongitude(), 0.0);
		Assert.assertEquals(35.0, adr.getCoordonnees().getLatitude(), 0.0);
		
		
		// TEST PREF ALIM
		prefAlim = prefAlimRepo.save(prefAlim);
		prefAlim = prefAlimRepo.findById(prefAlim.getId());

		prefAlim.setTypeAlimentation(TypeAlimentation.VEGAN);

		prefAlim = prefAlimRepo.save(prefAlim);
		prefAlim = prefAlimRepo.findById(prefAlim.getId());

		Assert.assertEquals(TypeAlimentation.VEGAN, prefAlim.getTypeAlimentation());

		utilisateurRepo.delete(tom);
		prefAlimRepo.delete(prefAlim);
		adresseRepo.delete(adr);
	}

}
