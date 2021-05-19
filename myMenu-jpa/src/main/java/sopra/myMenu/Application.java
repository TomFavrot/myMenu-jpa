package sopra.myMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.myMenu.repository.IAdresseRepository;
import sopra.myMenu.repository.IAjustementQuantiteRepository;
import sopra.myMenu.repository.IIngredientRepository;
import sopra.myMenu.repository.IListeCourseRepository;
import sopra.myMenu.repository.IMagasinIngredientRepository;
import sopra.myMenu.repository.IMagasinRepository;
import sopra.myMenu.repository.IMenuRepository;
import sopra.myMenu.repository.IObjectifRepository;
import sopra.myMenu.repository.IPlanningRepository;
import sopra.myMenu.repository.IPlatRepository;
import sopra.myMenu.repository.IPreferenceAlimentaireRepository;
import sopra.myMenu.repository.IRecetteRepository;
import sopra.myMenu.repository.IRepasRepository;
import sopra.myMenu.repository.IUtilisateurRepository;
import sopra.myMenu.repository.jpa.AdresseRepositoryJpa;
import sopra.myMenu.repository.jpa.AjustementQuantiteRepositoryJpa;
import sopra.myMenu.repository.jpa.IngredientRepositoryJpa;
import sopra.myMenu.repository.jpa.ListeCourseRepositoryJpa;
import sopra.myMenu.repository.jpa.MagasinIngredientRepositoryJpa;
import sopra.myMenu.repository.jpa.MagasinRepositoryJpa;
import sopra.myMenu.repository.jpa.MenuRepositoryJpa;
import sopra.myMenu.repository.jpa.ObjectifRepositoryJpa;
import sopra.myMenu.repository.jpa.PlanningRepositoryJpa;
import sopra.myMenu.repository.jpa.PlatRepositoryJpa;
import sopra.myMenu.repository.jpa.PreferenceAlimentaireRepositoryJpa;
import sopra.myMenu.repository.jpa.RecetteRepositoryJpa;
import sopra.myMenu.repository.jpa.RepasRepositoryJpa;
import sopra.myMenu.repository.jpa.UtilisateurRepositoryJpa;

public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMenu-jpa");
	
	private final IAdresseRepository adresseRepo = new AdresseRepositoryJpa();
	private final IAjustementQuantiteRepository ajustquantitRepo= new AjustementQuantiteRepositoryJpa(); 
	private final IIngredientRepository ingredientRepo = new IngredientRepositoryJpa();
	private final IListeCourseRepository listecourseRepo = new ListeCourseRepositoryJpa();
	private final IMagasinIngredientRepository magasiningredRepo = new MagasinIngredientRepositoryJpa();
	private final IMagasinRepository magasinRepo = new MagasinRepositoryJpa();
	private final IPlatRepository platRepo = new PlatRepositoryJpa();
	private final IPreferenceAlimentaireRepository preferencealimRepo = new PreferenceAlimentaireRepositoryJpa() ;
	private final IRecetteRepository recetteRepo = new RecetteRepositoryJpa() ;
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final IPlanningRepository planningRepo = new PlanningRepositoryJpa();
	private final IObjectifRepository objectifRepo = new ObjectifRepositoryJpa() ;
	private final IMenuRepository menuRepo = new MenuRepositoryJpa();
	private final IRepasRepository repasRepo = new RepasRepositoryJpa();
	
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

	public IPlanningRepository getPlanningRepo() {
		return planningRepo;
	}

	public IObjectifRepository getObjectifRepo() {
		return objectifRepo;
	}

	public IMenuRepository getMenuRepo() {
		return menuRepo;
	}

	public IRepasRepository getRepasRepo() {
		return repasRepo;
	}
	
	
	
}
