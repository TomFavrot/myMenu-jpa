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
//import sopra.myMenu.model.Magasin;
//import sopra.myMenu.repository.IMagasinRepository;
//
//public class MagasinRepositoryJpa implements IMagasinRepository {
//
//	@Override
//	public List<Magasin> findAll() {
//		List<Magasin> magasins = new ArrayList<Magasin>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<Magasin> query = em.createQuery("select e from Magasin e", Magasin.class);
//
//			magasins = query.getResultList();
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
//		return magasins;
//	}
//
//	@Override
//	public Magasin findById(Long id) {
//		Magasin magasin = null;
//		
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			magasin = em.find(Magasin.class, id);
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
//		return magasin;
//	}
//
//}
