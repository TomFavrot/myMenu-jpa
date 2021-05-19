package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.PreferenceAlimentaire;
import sopra.myMenu.repository.IPreferenceAlimentaireRepository;

public class PreferenceAlimentaireRepositoryJpa implements IPreferenceAlimentaireRepository {

	@Override
	public List<PreferenceAlimentaire> findAll() {
		List<PreferenceAlimentaire> preferencesalimentaires = new ArrayList<PreferenceAlimentaire>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<PreferenceAlimentaire> query = em.createQuery("select p from PreferenceAlimentaire p", PreferenceAlimentaire.class);

			preferencesalimentaires = query.getResultList();

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

		return preferencesalimentaires;
	}

	@Override
	public PreferenceAlimentaire findById(Long id) {
		PreferenceAlimentaire preferencealimentaire = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			preferencealimentaire = em.find(PreferenceAlimentaire.class, id);

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

		return preferencealimentaire;
	}

}
