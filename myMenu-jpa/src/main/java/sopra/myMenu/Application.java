package sopra.myMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.myMenu.repository.IAdresseRepository;
import sopra.myMenu.repository.IAjustementQuantiteRepository;
import sopra.myMenu.repository.IIngredientRepository;
import sopra.myMenu.repository.IListeCourseRepository;
import sopra.myMenu.repository.IMagasinIngredientRepository;
import sopra.myMenu.repository.IMagasinRepository;
import sopra.myMenu.repository.IPlatRepository;
import sopra.myMenu.repository.IPreferenceAlimentaireRepository;
import sopra.myMenu.repository.IRecetteRepository;
import sopra.myMenu.repository.IUtilisateurRepository;

public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
	
	private final IAdresseRepository adresseRepo;
	private final IAjustementQuantiteRepository ajustquantitRepo;
	private final IIngredientRepository ingredientRepo;
	private final IListeCourseRepository listecourseRepo;
	private final IMagasinIngredientRepository magasiningredRepo;
	private final IMagasinRepository magasinRepo;
	private final IPlatRepository platRepo;
	private final IPreferenceAlimentaireRepository preferencealimRepo;
	private final IRecetteRepository recetteRepo;
	private final IUtilisateurRepository utilisateurRepo;
	
	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IAdresseRepository getAdresseRepo() {
		return adresseRepo;
	}

	public IAjustementQuantiteRepository getAjustquantitRepo() {
		return ajustquantitRepo;
	}

	public IIngredientRepository getIngredientRepo() {
		return ingredientRepo;
	}

	public IListeCourseRepository getListecourseRepo() {
		return listecourseRepo;
	}

	public IMagasinIngredientRepository getMagasiningredRepo() {
		return magasiningredRepo;
	}

	public IMagasinRepository getMagasinRepo() {
		return magasinRepo;
	}

	public IPlatRepository getPlatRepo() {
		return platRepo;
	}

	public IPreferenceAlimentaireRepository getPreferencealimRepo() {
		return preferencealimRepo;
	}

	public IRecetteRepository getRecetteRepo() {
		return recetteRepo;
	}

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}
	
	
}
