package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.Adresse;
import sopra.myMenu.repository.IAdresseRepository;

public class AdresseRepositoryJpa implements IAdresseRepository {

	@Override
	public List<Adresse> findAll() {
		List<Adresse> adresses = new ArrayList<Adresse>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Adresse> query = em.createQuery("select a from Adresse a", Adresse.class);

			adresses = query.getResultList();

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

		return adresses;
	}

	@Override
	public Adresse findById(Long id) {
		Adresse adresse = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			adresse = em.find(Adresse.class, id);

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

		return adresse;
	}

}
