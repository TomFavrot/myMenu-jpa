package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.MagasinIngredient;
import sopra.myMenu.repository.IMagasinIngredientRepository;

public class MagasinIngredientRepositoryJpa implements IMagasinIngredientRepository {

	@Override
	public List<MagasinIngredient> findAll() {
		List<MagasinIngredient> magasinIngredient = new ArrayList<MagasinIngredient>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<MagasinIngredient> query = em.createQuery("select e from MagasinIngredient e", MagasinIngredient.class);

			magasinIngredient = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return magasinIngredient;
	}

	@Override
	public MagasinIngredient findById(Long id) {
		MagasinIngredient magasinIngredient = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			magasinIngredient = em.find(MagasinIngredient.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return magasinIngredient;
	}

}
