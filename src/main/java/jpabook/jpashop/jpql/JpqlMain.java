package jpabook.jpashop.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpqlMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			
			Member member = new Member();
			member.setUsername("member1");
			member.setAge(10);
			em.persist(member);
			
			TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
			TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
			Query query3 = em.createQuery("select m.username, m.age from Member m");
			List<Member> query4 = query1.getResultList();
			// 값이 없다면 null이 아니라 빈 리스트를 반환한다.
			for(Member mem : query4) {
				System.out.println(mem.getUsername());
			}
			// 결과 값이 하나일 경우 (꼭! 하나여야 한다.)
			TypedQuery<Member> query5 = em.createQuery("select m from Member m where m.age = 10", Member.class);
			Member findMember = query5.getSingleResult();
			// 결과 값이 없다면 NoResultException 발생
			// 결과 값이 둘 이상이면 NonUniqueResultException 발생
			System.out.println(findMember.getUsername());
			
			TypedQuery<Member> query6 = em.createQuery("select m from Member m where m.username = :username", Member.class);
			query6.setParameter("username", "member1");
			Member singleResult = query6.getSingleResult();
			System.out.println(singleResult.getUsername());
			
			// 6번을 메소드 체이닝으로 깔끔하게 사용하는 방법
			Member query7 = em.createQuery("select m from Member m where m.username = :username", Member.class)
							  .setParameter("username", "member1")
							  .getSingleResult();
			System.out.println(query7.getUsername());
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
