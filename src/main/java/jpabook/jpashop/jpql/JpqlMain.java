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
			Team team = new Team();
			team.setName("Team1");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			member.setAge(18);
			member.setTeam(team);
			em.persist(member);
			
			em.flush();
			em.clear();
			// 엔티티 프로젝션
//			TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//			// 엔티티 프로젝션
//			TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//			// 스칼라 타입 프로젝션
//			Query query3 = em.createQuery("select m.username, m.age from Member m");
//			List<Member> query4 = query1.getResultList();
//			// 값이 없다면 null이 아니라 빈 리스트를 반환한다.
//			for (Member mem : query4) {
//				System.out.println(mem.getUsername());
//			}
//			// 결과 값이 하나일 경우 (꼭! 하나여야 한다.)
//			TypedQuery<Member> query5 = em.createQuery("select m from Member m where m.age = 10", Member.class);
//			Member findMember = query5.getSingleResult();
//			// 결과 값이 없다면 NoResultException 발생
//			// 결과 값이 둘 이상이면 NonUniqueResultException 발생
//			System.out.println(findMember.getUsername());
//
//			TypedQuery<Member> query6 = em.createQuery("select m from Member m where m.username = :username",
//					Member.class);
//			query6.setParameter("username", "member1");
//			Member singleResult = query6.getSingleResult();
//			System.out.println(singleResult.getUsername());
//
//			// 6번을 메소드 체이닝으로 깔끔하게 사용하는 방법
//			Member query7 = em.createQuery("select m from Member m where m.username = :username", Member.class)
//					.setParameter("username", "member1").getSingleResult();
//			System.out.println(query7.getUsername());
//
//			// 엔티티 프로젝션일 경우 결과 값이 영속성 컨텍스트에 의해 관리된다.
//			List<Member> query8 = em.createQuery("select m from Member m", Member.class).getResultList();
//			query8.get(0).setAge(20); // update 쿼리 날아감
//
//			// 임베디드 프로젝션
//			List<Address> query9 = em.createQuery("select o.address from Order o", Address.class).getResultList();
//
//			// 스칼라 타입 프로젝션
//			List<Object[]> query10 = em.createQuery("select m.username, m.age from Member m").getResultList();
//
//			// 1. 스칼라 타입 프로젝션을 매핑하는 방법
//			Object[] resultO = query10.get(0);
//			System.out.println("username = " + resultO[0]);
//			System.out.println("age      = " + resultO[1]);
//
//			// 2. 스칼라 타입 프로젝션을 매핑하는 방법 (권장)
//			// 단점 : 패키지 명을 풀로 적어줘야한다.
//			List<MemberDTO> query11 = em
//					.createQuery("select new jpabook.jpashop.jpql.MemberDTO(m.username, m.age) from Member m",
//							MemberDTO.class)
//					.getResultList();
//			MemberDTO memberDto = query11.get(0);
//			System.out.println("username = " + memberDto.getUsername());
//			System.out.println("age      = " + memberDto.getAge());
//
//			// 페이징 처리
//			List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//					.setFirstResult(1) // 0번부터 데이터가 있는거다.
//					.setMaxResults(10).getResultList();
//			for (Member m : result) {
//				System.out.println("member = " + m.getUsername());
//			}

			// inner Join
			String joinQuery = "select m from Member m inner join m.team t";
			List<Member> joinResult = em.createQuery(joinQuery, Member.class).getResultList();

			// outer join
			String joinQuery2 = "select m from Member m left join m.team t";
			List<Member> joinResult2 = em.createQuery(joinQuery2, Member.class).getResultList();
			
			// 세타 조인
			String joinQuery3 = "select m from Member m, Team t where m.username = t.name";
			List<Member> joinResult3 = em.createQuery(joinQuery3, Member.class).getResultList();
			
			// 조인 대상 필터링
			String joinQuery4 = "select m from Member m left join m.team t on t.name = :teamName";
			List<Member> joinResult4 = em.createQuery(joinQuery4, Member.class)
										 .setParameter("teamName", "team1")
										 .getResultList();
			// 연관 관계 없는 엔티티 외부 조인
			String joinQuery5 = "select m from Member m left join Team t on m.username = t.name";
			List<Member> joinResult5 = em.createQuery(joinQuery5, Member.class)
										 .getResultList();
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
