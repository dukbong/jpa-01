package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeamMainTwo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
			TeamMemberTwo member = new TeamMemberTwo();
			member.setName("member1");
			
			em.persist(member);
			
			TeamTwo team = new TeamTwo();
			team.setName("teamA");
			// 아래가 이상하다. DB의 외래키는 Member에 있기 때문에 Member테이블을 업데이트한다.
			// 쿼리가 N:1보다 update 쿼리 하나가 더 나가며 실무에서 보기 어려워진다.
			team.getMembers().add(member);
			
			em.persist(team);
			
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
