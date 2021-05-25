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
//import sopra.myMenu.model.AjustementQuantite;
//import sopra.myMenu.repository.IAjustementQuantiteRepository;
//
//public class AjustementQuantiteRepositoryJpa implements IAjustementQuantiteRepository {
//
//	@Override
//	public List<AjustementQuantite> findAll() {
//		List<AjustementQuantite> ajustementQuantites = new ArrayList<AjustementQuantite>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<AjustementQuantite> query = em.createQuery("select e from AjustementQuantite e", AjustementQuantite.class);
//
//			ajustementQuantites = query.getResultList();
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
//		return ajustementQuantites;
//	}
//
//	@Override
//	public AjustementQuantite findById(Long id) {
//		AjustementQuantite ajustementQuantite = null;
//		
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			ajustementQuantite = em.find(AjustementQuantite.class, id);
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
//		return ajustementQuantite;
//	}
//
//}
