//package sopra.myMenu.repository.jpa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.TypedQuery;
//
//import sopra.myMenu.Application;
//import sopra.myMenu.model.Planning;
//import sopra.myMenu.repository.IPlanningRepository;
//
//public class PlanningRepositoryJpa implements IPlanningRepository {
//
//	public List<Planning> findAll() {
//		
//		List<Planning> plannings = new ArrayList<Planning>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<Planning> query = em.createQuery("select p from Planning p", Planning.class);
//
//			plannings = query.getResultList();
//
//			tx.commit();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return plannings;
//	}
//
//	public Planning findById(Long id) {
//
//		Planning planning = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			planning = em.find(Planning.class, id);
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//		} finally {
//			if (em != null) {
//				em.close();
//			}
//		}
//
//		return planning;
//	}
//}
