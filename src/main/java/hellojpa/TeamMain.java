package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class TeamMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
//			연관관계가 없는 상황			
//			Team team = new Team();
//			team.setName("TeamA");
//			em.persist(team);
//			
//			TeamMember member = new TeamMember();
//			member.setName("Member1");
//			member.setTeamId(team.getId());
//			em.persist(member);
//			
//			TeamMember findMember = em.find(TeamMember.class, member.getId());
//			Long findTeamId = findMember.getTeamId();
//			
//			Team findteam = em.find(Team.class, findTeamId);
			
//			연관 관계가 있는 상황
//			Team team = new Team();
//			team.setName("TeamA");
//			em.persist(team);
//			
//			TeamMember member = new TeamMember();
//			member.setName("member1");
//			member.setTeam(team);
//			em.persist(member);
//			
//			em.flush();
//			em.clear();
//			
//			TeamMember findMember = em.find(TeamMember.class, member.getId());
//			
//			List<TeamMember> members = findMember.getTeam().getMembers();
//			
//			for(TeamMember m : members) {
//				System.out.println("m = " + m.getName());
//			}
			
//			양방향 매핑 시 많이 하는 실수
//			Team team = new Team();
//			team.setName("team1");
//			team.getMembers().add(member);
//			em.persist(team);
//			
//			TeamMember member = new TeamMember();
//			member.setName("member1");
//			member.changeTeam(team);
//			em.persist(member);
			
//			TeamMember에 setTeam에 아래 코드를 넣어 주었다.
//			team.getMembers().add(member);
			
//			em.flush();
//			em.clear();
			
//			Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//			List<TeamMember> members = findTeam.getMembers();
//			
//			System.out.println("===================");
//			for(TeamMember m : members) {
//				System.out.println("m = " + m.getName());
//			}
//			System.out.println("===================");
			
			Team team = new Team();
			team.setName("team1");
			em.persist(team);
			Team team2 = new Team();
			team2.setName("team2");
			em.persist(team2);
			
			Memberd member1 = new Memberd();
			member1.setUsername("member1");
			member1.setTeam(team);
			em.persist(member1);
			
			Memberd member2 = new Memberd();
			member2.setUsername("member2");
			member2.setTeam(team2);
			em.persist(member2);
			
			
			em.flush();
			em.clear();
			
			//
//			Member findMember = em.find(Member.class, member.getId());
//			Member findMember = em.getReference(Member.class, member.getId());
			// getReference : 지연 로딩
			// 쿼리를 날리지 않고 findMember를 사용할때 쿼리를 날린다.
			// 이때 findMember는 프록시이다.
//			System.out.println("findMember.id = " + findMember.getId());
//			System.out.println("findMember.userName = " + findMember.getUsername());
			
//			Member m1 = em.find(Member.class, member1.getId());
//			Member m2 = em.find(Member.class, member2.getId());
//			Member m3 = em.getReference(Member.class, member2.getId());
//			System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass()));
//			System.out.println("m1 == m3 " + (m1.getClass() == m3.getClass()));
			// 객체를 비교할때는 지금 비교하고자 하는게 프록시인지 아닌지 알 수 없기 떄문에 instanceof로 비교해야한다.
			// 이유는 프록시는 결국 실제 엔티티를 상속하고 있기 때문이다.
//			System.out.println("m1 == m3 " + (m1 instanceof Member));
//			System.out.println("m1 == m3 " + (m3 instanceof Member));

			
//			Member refMember = em.getReference(Member.class, member1.getId());
//			System.out.println(refMember.getClass());
			
//			em.detach(refMember); // 영속성 컨텍스트에서 refMember를 관리 하지 않겠다.
//			em.close();
//			em.clear();
			// 위 세가지 경우 모두 아래에서 오류가 발생한다.
			
			// 영속성 컨텍스트의 도움을 받지 못하고 그러므로 DB에 접근할 수 없기때문에 오류 발생
			// LazyInitializationException 예외 발생
//			refMember.getUsername();
			
			// Proxy 인스턴스의 초기화 여부를 확인하는 메소드 (getPersistenceUnitUtil().isLoaded())
//			System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//			refMember.getUsername();
			// Proxy 강제 초기화
//			Hibernate.initialize(refMember);
//			System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
			
//			Member findMember = em.find(Member.class, member1.getId());
//			System.out.println("findmember = " + findMember.getUsername());
//			System.out.println("findTeam = " + findMember.getTeam().getClass());
//			System.out.println("============================");
//			System.out.println(findMember.getTeam().getName()); // 초기화
//			System.out.println("============================");
			
			
			// 즉시 로딩을 적용했을때 JPQL에서 일어날 수 있는 N+1의 예시
			List<Memberd> members = em.createQuery("select m from Memberd m join fetch m.team", Memberd.class)
									 .getResultList();
			// 문제점
			// jpql은 바로 쿼리를 db에 날린다.
			// 이떄는 select * from member;
			// 하지만 Memberd의 객체에는 Team이라는 필드가 있다.
			// 이를 찾기 위해 다시 한번 select * from team where team_id = xxx;
			// 라는 쿼리를 다시 한번 날리게 된다.
			// 이를 N + 1현상이라고 한다.
			// 좀더 구체적으로 말하면
			// 1은 최초의 쿼리 select * from member를 의미한다.
			// N은 1에서 조회된 행의 개수를 의미한다.
			// 해결법
			// 1. 지연로딩 (LAZY)를 이용하면 프록시이기 때문에 Team 관련 쿼리가 날아가지 않는다.
			// >>> 하지만 team을 조회하면 어쩔 수 없이 쿼리가 날아간다.
			// 2. join fetch 사용
			// 그 외 몇가지 방법이 있지만 추후에 공부해보자.
		
			
			
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
