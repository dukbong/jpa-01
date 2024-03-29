package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// 영속성 전이 : CASCADE
public class PcMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
			Child child1 = new Child();
			Child child2 = new Child();
			
			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);
			
			em.persist(parent);
			
			em.flush();
			em.clear();
			
			Parent findParent = em.find(Parent.class, parent.getId());
			findParent.getChildList().remove(0);
			
			em.remove(findParent);
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
