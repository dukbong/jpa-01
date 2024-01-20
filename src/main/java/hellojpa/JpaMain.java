package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		// META-INF/persistence.xml
		// persistence-unit의 name 값을 넣어준다.
		
		// Persistence 객체는 persistence.xml파일을 읽어서 EntityManagerFactory 객체를 만든다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
//			Insert code
//			Member member = new Member();
//			
//			member.setId(2L);
//			member.setName("HelloB");
//			em.persist(member);
			
//			Select code
//			Member findMember = em.find(Member.class, 1L);
			
//			Delete code
//			Member findMember = em.find(Member.class, 1L);
//			em.remove(findMember);
			
//			Update code
//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("helloJPA");
			
//			JPQL 맛보기
//			List<Member> result = em.createQuery("select m from Member as m", Member.class)
//									.setFirstResult(1) // 1번부터
//									.setMaxResults(8) // 8개 를 반환하는 페이징 처리를 쉽게 할 수 있다.
//									.getResultList();
//			for(Member m : result) {
//				System.out.println(m.getName());
//			}
			
//			영속성 컨테이너 : EntityManager 1개당 1개의 영속성 컨테이너가 존재 한다.
			
//			------------ 비영속 상태 ------------ 
//			현재 JPA와는 아무런 관련이 없는 상태
//			Member member = new Member();
//			member.setId(101L);
//			member.setName("JAPGOOD");
//			------------ 비영속 상태 ------------
			
//			------------ 영속 상태 ------------
//			영속성 컨테이너에서 member 객체를 관리하는 것이다.
//			이때 DB에 저장되지 않는다.
//			영속성 컨테이너 안에 있는 1차 캐시에 저장된다.
//			이때 key값은 PirmaryKey value값은 member 객체가 된다.
//			em.persist(member);
			
//			이건 준영속 상태를 만들어주는 것이다.
//			영속성 컨테이너에서 관리하는 member 객체를 지우겠다는 의미이다.
//			em.detach(member);
//			------------ 영속 상태 ------------
			
//			영속성 컨테이너는 1차 캐시가 있는데 
//			JPA는 조회 시 1차적으로 1차캐시에 있는지 없는지 확인한다.
//			있다면 DB에 접근하지 않고 영속성 컨테이너에서 가져온다.
//			Member findMember = em.find(Member.class, 101L);
//			System.out.println(findMember.getId());
//			System.out.println(findMember.getName());
			
//			영속성 컨테이너에 값이 없다면 DB에 접근해서 값을 가져오고
//			해당 값을 영속성 컨테이너 1차 캐쉬에 저장한다.
//			Member findMember1 = em.find(Member.class, 101L);
//			Member findMember2 = em.find(Member.class, 101L);
//			이렇게 작성 시 select 쿼리는 한번만 실행하게 된다.
//			findMember1은 DB에서 가져오지만 findMember2는 1차 캐시에서 가져오게 된다.
			
//			Member member1 = new Member();
//			Member member2 = new Member();
			
//			member1.setId(200L);
//			member2.setId(201L);
//			member1.setName("200LJAP");
//			member2.setName("201LJAP");
			
//			persist하게 되면
//			1차 캐시에 저장됨과 동시에 영속성 컨테이너 안에 있는 쓰기 지연 SQL 저장소에 쌓이게 된다.
//			그 후 commit()을 하게 되면 쓰기 지연 SQL 저장소에 쌓였던 것을 flush하면서 commit하게 된다.
//			em.persist(member1);
//			em.persist(member2);
//			System.out.println("-------------------------");
			
//			Member findMember = em.find(Member.class, 200L);
//			findMember.setName("UpdateJPA");
			
			Memberd member1 = new Memberd();
			member1.setUsername("A");
			Memberd member2 = new Memberd();
			member2.setUsername("B");
			Memberd member3 = new Memberd();
			member3.setUsername("C");
			
			System.out.println("================");
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			System.out.println("member1 = " + member1.getId());
			System.out.println("member2 = " + member2.getId());
			System.out.println("member3 = " + member3.getId());
			System.out.println("================");
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
	}
}

