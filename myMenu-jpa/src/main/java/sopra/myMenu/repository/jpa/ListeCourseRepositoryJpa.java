package sopra.myMenu.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.myMenu.Application;
import sopra.myMenu.model.ListeCourse;
import sopra.myMenu.repository.IListeCourseRepository;

public class ListeCourseRepositoryJpa implements IListeCourseRepository{

	@Override
	public List<ListeCourse> findAll() {
		List<ListeCourse> listeCourses = new ArrayList<ListeCourse>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<ListeCourse> query = em.createQuery("select e from ListeCourse e", ListeCourse.class);

			listeCourses = query.getResultList();

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

		return listeCourses;
	}

	@Override
	public ListeCourse findById(Long id) {
		ListeCourse listeCourses = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			listeCourses = em.find(ListeCourse.class, id);

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

		return listeCourses;
	}
}


