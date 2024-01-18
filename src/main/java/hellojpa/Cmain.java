package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Cmain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
			Cmovie movie = new Cmovie();
			movie.setDirector("aaaa");
			movie.setActor("bbbb");
			movie.setName("바람");
			movie.setPrice(10000);
			em.persist(movie);
			em.flush();
			em.clear();
			Cmovie findMovie = em.find(Cmovie.class, movie.getId());
			System.out.println("findMovie = " + findMovie);
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
