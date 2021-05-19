package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.Recette;
import sopra.myMenu.repository.IRecetteRepository;

public class RecetteRepositoryJpa implements IRecetteRepository{

	@Override
	public List<Recette> findAll() {
		List<Recette> recettes = new ArrayList<Recette>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Recette> query = em.createQuery("select r from Recette r", Recette.class);

			recettes = query.getResultList();

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

		return recettes;
	}


	@Override
	public Recette findById(Long id) {
		Recette recette = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			recette = em.find(Recette.class, id);

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

		return recette;
	}
}

