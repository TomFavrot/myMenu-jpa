package sopra.myMenu.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.Objectif;
import sopra.myMenu.model.TypeObjectif;
import sopra.myMenu.repository.IObjectifRepository;

public class TestObjectif {

	@Test
	public void objectifCreate() {

		IObjectifRepository objectifRepo = Application.getInstance().getObjectifRepo();

		Objectif objectif1 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		try {
			Objectif objectifFind = objectifRepo.findById(objectif1.getId());

			Assert.assertEquals(TypeObjectif.BIEN_ETRE, objectifFind.getTypeObjectif());
			Assert.assertEquals("commentaire1", objectifFind.getCommentaire());
			Assert.assertEquals(2400, objectifFind.getNombreCaloriesParSemaine());
			Assert.assertEquals(3, objectifFind.getNombreRepasParJour());
		}

		finally {
			objectifRepo.delete(objectif1);
		}
	}

	@Test
	public void objectifUpdate() {

		IObjectifRepository objectifRepo = Application.getInstance().getObjectifRepo();

		Objectif objectif1 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif1.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif1.setCommentaire("commentaire2");
		objectif1.setNombreCaloriesParSemaine(1800);
		objectif1.setNombreRepasParJour(2);
		objectif1 = objectifRepo.save(objectif1);

		try {
			Objectif objectifFind = objectifRepo.findById(objectif1.getId());

			Assert.assertEquals(TypeObjectif.PRISE_MASSE, objectifFind.getTypeObjectif());
			Assert.assertEquals("commentaire2", objectifFind.getCommentaire());
			Assert.assertEquals(1800, objectifFind.getNombreCaloriesParSemaine());
			Assert.assertEquals(2, objectifFind.getNombreRepasParJour());
		}

		finally {
			objectifRepo.delete(objectif1);
		}
	}

	@Test
	public void objectifFindAll() {

		IObjectifRepository objectifRepo = Application.getInstance().getObjectifRepo();

		Objectif objectif1 = new Objectif();
		Objectif objectif2 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif2.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif2.setCommentaire("commentaire2");
		objectif2.setNombreCaloriesParSemaine(1800);
		objectif2.setNombreRepasParJour(2);
		objectif2 = objectifRepo.save(objectif2);

		List<Objectif> objectifs = objectifRepo.findAll();
				
		try {
			Assert.assertEquals(2, objectifs.size());
		}

		finally {
			objectifRepo.delete(objectif1);
			objectifRepo.delete(objectif2);
		}
	}
	
	@Test
	public void objectifDelete() {

		IObjectifRepository objectifRepo = Application.getInstance().getObjectifRepo();

		Objectif objectif1 = new Objectif();
		Objectif objectif2 = new Objectif();

		objectif1.setTypeObjectif(TypeObjectif.BIEN_ETRE);
		objectif1.setCommentaire("commentaire1");
		objectif1.setNombreCaloriesParSemaine(2400);
		objectif1.setNombreRepasParJour(3);
		objectif1 = objectifRepo.save(objectif1);

		objectif2.setTypeObjectif(TypeObjectif.PRISE_MASSE);
		objectif2.setCommentaire("commentaire2");
		objectif2.setNombreCaloriesParSemaine(1800);
		objectif2.setNombreRepasParJour(2);
		objectif2 = objectifRepo.save(objectif2);

		List<Objectif> objectifs = objectifRepo.findAll();
				
		try {
			Assert.assertEquals(2, objectifs.size());
		}

		finally {
			objectifRepo.delete(objectif1);
			objectifRepo.delete(objectif2);
			
			objectifs = objectifRepo.findAll();
			
			Assert.assertEquals(0, objectifs.size());
		}
	}
	
}
