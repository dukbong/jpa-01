package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Amain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
//			1. JPQL은 동적 쿼리를 만들기 힘들다...
//			List<Memberd> result = em.createQuery(
//					"select m from Memberd m where m.username like '%kim%'",
//					Memberd.class
//					).getResultList();
			
//			2. Criteria 사용  (표준 스펙, 유지보수에 좀 어렵다...)
//			장점 : 동적 쿼리를 작성하기 좋고 java 코드로 쿼리를 짤 수 있다.
//			단점 : SQL과 너무 달라서 너무 복잡하다.
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<Memberd> query = cb.createQuery(Memberd.class);
//			
//			Root<Memberd> m = query.from(Memberd.class);
//			
//			CriteriaQuery<Memberd> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//			
//			em.createQuery(cq).getResultList();
			
//			3. QueryDSL >> 가장 좋지만 지금은 배우지 않았음
			
//			4. NativeQuery
			List<Memberd> result = em.createNativeQuery("select member_id, team_id, username from Memberd", Memberd.class).getResultList();
			
//			5. JDBC 사용
//			주의 : JDBC를 이용한 JdbcTemplate, Mybatis는 JPA와 상관없는 작업이기 때문에
//			            영속성 컨텍스트를 적절한 시점에서 강제 flush를 해줘야 한다.
//			Memberd member = new Memberd();
//			member.setUsername("kim");
//			em.persist(member);
			
//			만약 여기서 jdbcTemplate, mybatis를 사용한다면?
//			select * from member; >> 현재 jpa에서 작성한 쿼리는 쓰기 지연 SQL 저장소에 있는 상황이기 때문에 내가 원하는 결과가 아니다.
//			위에 insert 쿼리가 아직 날아가지 않았기 때문에 해당 쿼리의 값이 내가 원하는 값이 아니다.
			
//			for(Memberd me : result) {
//				System.out.println("me = " + me.getUsername());
//			}
			
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
