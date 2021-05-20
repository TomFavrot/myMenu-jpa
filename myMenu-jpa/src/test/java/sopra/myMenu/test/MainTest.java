package sopra.myMenu.test;

import org.junit.Test;

public class MainTest {
@Test
	public  void test() {

		TestIngredient t1 = new TestIngredient();
		t1.IngredientCreate();
		t1.IngredientUpdate();
		t1.IngredientFindAll();
		t1.IngredientDelete();
		
		TestPlat t2 = new TestPlat();
		t2.platCreate();
		t2.platCreate();
		t2.platFindAll();
		t2.platDelete();
		
		TestRecette t3 = new TestRecette();
		t3.RecetteCreate();
		t3.RecetteCreate();
		t3.RecetteFindAll();
		t3.RecetteCreate();
		
	}

}
