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
//import sopra.myMenu.model.Plat;
//import sopra.myMenu.repository.IPlatRepository;
//
//
//
//public class PlatRepositoryJpa implements IPlatRepository {
//
//	@Override
//	public List<Plat> findAll() {
//		List<Plat> plats = new ArrayList<Plat>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<Plat> query = em.createQuery("select p from Plat p", Plat.class);
//
//			plats = query.getResultList();
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
//		return plats;
//	}
//
//	@Override
//	public Plat findById(Long id) {
//		Plat plat = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			plat = em.find(Plat.class, id);
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
//		return plat;
//	}
//}
//
