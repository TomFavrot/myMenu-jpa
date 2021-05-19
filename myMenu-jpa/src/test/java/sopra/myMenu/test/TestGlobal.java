package sopra.myMenu.test;

public class TestGlobal {

	public static void main(String[] args) {
		TestBaptiste tb = new TestBaptiste();
		tb.utilisateurAdressePreferenceAlimentaireCreate();
		tb.utilisateurAdressePreferenceAlimentaireUpdate();
		
		TestCamille tc = new TestCamille();
		tc.ajustementCreateUpdate();
		tc.magasinCreate();
		tc.magasinIngredientCreate();
		tc.magasinIngredientDelete();
		tc.magasinIngredientFindAll();
		tc.magasinIngredientFindAll();
		tc.magasinIngredientUpdate();
		tc.magasinUpdate();
		
		TestPlat tp = new TestPlat();
		tp.platCreate();
		tp.platDelete();
		tp.platFindAll();
		tp.platUpdate();
		
		TestMenu tm = new TestMenu();
		
		tm.menuCreate();
		tm.menuDelete();
		tm.menuFindAll();
		tm.menuUpdate();

	}

}
