package sopra.myMenu.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.myMenu.Application;
import sopra.myMenu.model.Plat;
import sopra.myMenu.repository.IPlatRepository;



public class TestPlat {
	@Test	
	public void platCreate() {
		
		IPlatRepository platRepo = Application.getInstance().getPlatRepo();
		
		Plat plat1 = new Plat(2);
		
		plat1 = platRepo.save(plat1);
		
		Plat platFind = platRepo.findById(plat1.getId());
		
		
		
		Assert.assertEquals(2, platFind.getNombrePersonne());
		
				
		platRepo.delete(plat1);
		
	}
	
	@Test	
	public void platUpdate() {
		
		IPlatRepository platRepo = Application.getInstance().getPlatRepo();
		
		Plat plat1 = new Plat(2);
		
		plat1 = platRepo.save(plat1);
				
		
		plat1.setNombrePersonne(4);
			
		plat1 = platRepo.save(plat1);
		Plat platFind = platRepo.findById(plat1.getId());
		
		Assert.assertEquals(4, platFind.getNombrePersonne());;
		
				
		platRepo.delete(plat1);
	}
	
	@Test
	public void platFindAll() {
		
		IPlatRepository platRepo = Application.getInstance().getPlatRepo();
		
		Plat plat1 = new Plat(3);
						
		Plat plat2 = new Plat(3);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);
			
		
		List<Plat> plats = platRepo.findAll();
		
		Assert.assertEquals(2, plats.size());
		
		platRepo.delete(plat1);
		platRepo.delete(plat2);
			
		
	}
	

	@Test
	public void platDelete() {
		
		IPlatRepository platRepo = Application.getInstance().getPlatRepo();
		
		Plat plat1 = new Plat(2);
						
		Plat plat2 = new Plat(2);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);
			
		
		List<Plat> plats = platRepo.findAll();
		
		Assert.assertEquals(2, plats.size());
		
		platRepo.delete(plat1);
		platRepo.delete(plat2);
		
		
		plats = platRepo.findAll();
		
		Assert.assertEquals(0, plats.size());
	}
}


