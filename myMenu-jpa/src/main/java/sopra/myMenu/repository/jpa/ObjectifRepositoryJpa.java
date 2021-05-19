package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.Objectif;

public class ObjectifRepositoryJpa {

public List<Objectif> findAll() {
		
		List<Objectif> objectifs = new ArrayList<Objectif>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Objectif> query = em.createQuery("select o from Objectif o", Objectif.class);

			objectifs = query.getResultList();

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

		return objectifs;
	}

	public Objectif findById(Long id) {

		Objectif menu = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			menu = em.find(Objectif.class, id);

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

		return menu;
	}
}
