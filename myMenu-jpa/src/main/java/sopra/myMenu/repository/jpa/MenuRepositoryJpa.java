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
//import sopra.myMenu.model.Menu;
//import sopra.myMenu.repository.IMenuRepository;
//
//
//public class MenuRepositoryJpa implements IMenuRepository {
//
//public List<Menu> findAll() {
//		
//		List<Menu> menus = new ArrayList<Menu>();
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			TypedQuery<Menu> query = em.createQuery("select m from Menu m", Menu.class);
//
//			menus = query.getResultList();
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
//		return menus;
//	}
//
//	public Menu findById(Long id) {
//
//		Menu menu = null;
//
//		EntityManager em = null;
//		EntityTransaction tx = null;
//
//		try {
//			em = Application.getInstance().getEmf().createEntityManager();
//			tx = em.getTransaction();
//			tx.begin();
//
//			menu = em.find(Menu.class, id);
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
//		return menu;
//	}
//}
