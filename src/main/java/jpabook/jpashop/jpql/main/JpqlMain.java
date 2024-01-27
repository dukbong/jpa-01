package jpabook.jpashop.jpql.main;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.jpql.Member;
import jpabook.jpashop.jpql.Team;

public class JpqlMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
//			Team team = new Team();
//			team.setName("Team1");
//			em.persist(team);
//			
//			Member member = new Member();
//			member.setUsername("member1");
//			member.setAge(18);
//			member.setType(MemberType.ADMIN);
//			member.setTeam(team);
//			em.persist(member);
//			
//			Member member2 = new Member();
//			member2.setUsername("member2");
//			em.persist(member2);
//			
//			em.flush();
//			em.clear();
			// 엔티티 프로젝션
//			TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
////			// 엔티티 프로젝션
//			TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
////			// 스칼라 타입 프로젝션
//			Query query3 = em.createQuery("select m.username, m.age from Member m");
//			List<Member> query4 = query1.getResultList();
////			// 값이 없다면 null이 아니라 빈 리스트를 반환한다.
//			for (Member mem : query4) {
//				System.out.println(mem.getUsername());
//			}
////			// 결과 값이 하나일 경우 (꼭! 하나여야 한다.)
//			TypedQuery<Member> query5 = em.createQuery("select m from Member m where m.age = 10", Member.class);
//			Member findMember = query5.getSingleResult();
////			// 결과 값이 없다면 NoResultException 발생
////			// 결과 값이 둘 이상이면 NonUniqueResultException 발생
//			System.out.println(findMember.getUsername());
//
//			TypedQuery<Member> query6 = em.createQuery("select m from Member m where m.username = :username",
//					Member.class);
//			query6.setParameter("username", "member1");
//			Member singleResult = query6.getSingleResult();
//			System.out.println(singleResult.getUsername());
////
////			// 6번을 메소드 체이닝으로 깔끔하게 사용하는 방법
//			Member query7 = em.createQuery("select m from Member m where m.username = :username", Member.class)
//					.setParameter("username", "member1").getSingleResult();
//			System.out.println(query7.getUsername());
////
////			// 엔티티 프로젝션일 경우 결과 값이 영속성 컨텍스트에 의해 관리된다.
//			List<Member> query8 = em.createQuery("select m from Member m", Member.class).getResultList();
//			query8.get(0).setAge(20); // update 쿼리 날아감
////
////			// 임베디드 프로젝션
//			List<Address> query9 = em.createQuery("select o.address from Order o", Address.class).getResultList();
////
////			// 스칼라 타입 프로젝션
//			List<Object[]> query10 = em.createQuery("select m.username, m.age from Member m").getResultList();
////
////			// 1. 스칼라 타입 프로젝션을 매핑하는 방법
//			Object[] resultO = query10.get(0);
//			System.out.println("username = " + resultO[0]);
//			System.out.println("age      = " + resultO[1]);
////
////			// 2. 스칼라 타입 프로젝션을 매핑하는 방법 (권장)
////			// 단점 : 패키지 명을 풀로 적어줘야한다.
//			List<MemberDTO> query11 = em
//					.createQuery("select new jpabook.jpashop.jpql.MemberDTO(m.username, m.age) from Member m",
//							MemberDTO.class)
//					.getResultList();
//			MemberDTO memberDto = query11.get(0);
//			System.out.println("username = " + memberDto.getUsername());
//			System.out.println("age      = " + memberDto.getAge());
////
////			// 페이징 처리
//			List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//					.setFirstResult(1) // 0번부터 데이터가 있는거다.
//					.setMaxResults(10).getResultList();
//			for (Member m : result) {
//				System.out.println("member = " + m.getUsername());
//			}
//
//			// inner Join
//			String joinQuery = "select m from Member m inner join m.team t";
//			List<Member> joinResult = em.createQuery(joinQuery, Member.class).getResultList();
//
//			// outer join
//			String joinQuery2 = "select m from Member m left join m.team t";
//			List<Member> joinResult2 = em.createQuery(joinQuery2, Member.class).getResultList();
//			
//			// 세타 조인
//			String joinQuery3 = "select m from Member m, Team t where m.username = t.name";
//			List<Member> joinResult3 = em.createQuery(joinQuery3, Member.class).getResultList();
//			
//			// 조인 대상 필터링
//			String joinQuery4 = "select m from Member m left join m.team t on t.name = :teamName";
//			List<Member> joinResult4 = em.createQuery(joinQuery4, Member.class)
//										 .setParameter("teamName", "team1")
//										 .getResultList();
//			// 연관 관계 없는 엔티티 외부 조인
//			String joinQuery5 = "select m from Member m left join Team t on m.username = t.name";
//			List<Member> joinResult5 = em.createQuery(joinQuery5, Member.class)
//										 .getResultList();
//			
//			// 서브쿼리
//			// jpql에서는 from절에 서브쿼리가 되지 않는다.
//			String subQuery = "select (select avg(m1.age) from Member m1) as avgAge from Member m";
//			List<Member> subResult = em.createQuery(subQuery, Member.class).getResultList();
//			
			// JPQL 타입 표현과 기타식
//			String typeQuery = "select m.usernamem, 'HELLO', TRUE from Member m where m.type = :userType";
//			List<Object[]> typeResult = em.createQuery(typeQuery, Object[].class)
//										  .setParameter("userType", MemberType.ADMIN)
//										  .getResultList();
//			
//			for(Object[] ob : typeResult) {
//				System.out.println(ob[0]);
//				System.out.println(ob[1]);
//				System.out.println(ob[2]);
//			}
			
			// 기본 CASE 식
//			String caseQuery = "select "
//								+ "case "
//								+ "	when m.age <= 10 then '학생 요금'"
//								+ "	when m.age >= 60 then '경로 요금'"
//								+ "	else '일반 요금' "
//								+ "end"
//							+ " from Member m";
//			List<String> caseResult = em.createQuery(caseQuery, String.class).getResultList();
//			for(String s : caseResult) {
//				System.out.println("s = " + s);
//			}
			
			// COALESCE : 하나씩 조회해서 null이 아니면 반환
//			String coalesceQuery = "select coalesce(m.username, '이름없는 회원') from Member m";
//			// 멤버 이름이 있으면 이름을 없으면 이름없는 회원을 반환한다.
//			List<String> coalesceResult = em.createQuery(coalesceQuery, String.class).getResultList();
//			for(String s : coalesceResult) {
//				System.out.println("s = " + s);
//			}
			
			// NULLIF : 두값이 같으면 null을 반환하고 다르면 첫번째 값 반환
//			String nullifQuery = "select NULLIF(m.username, '관리자') from Member m";
//			// m.username은 member1이기 떄문에 member1을 반환
//			List<String> nullifResult = em.createQuery(nullifQuery, String.class).getResultList();
//			for(String s : nullifResult) {
//				System.out.println(s);
//			}
			
			// CONCAT
//			String concat1 = "select 'a' || 'b' from Member m";
//			String concat2 = "select concat('a','b') from Member m";
//			List<String> concat1Result = em.createQuery(concat1, String.class).getResultList();
//			System.out.println("concat1 = " + concat1Result.get(0));
//			List<String> concat2Result = em.createQuery(concat2, String.class).getResultList();
//			System.out.println("concat2 = " + concat2Result.get(0));
					
			// SUBSTRING
//			String subString = "select substring(m.username, 2, 3) from Member m";
			// m.username = member1 >> 2번째부터 3개
//			List<String> subStringResult = em.createQuery(subString, String.class).getResultList();
//			System.out.println("subStringResult = " + subStringResult.get(0));
			
			// LOCATE
//			String locate = "select locate('de', 'abcdefg') from Member m";
//			List<Integer> locateResult = em.createQuery(locate, Integer.class).getResultList();
//			System.out.println("locateResult = " + locateResult.get(0));
			
			// SIZE (JPA 용도)
//			String size = "select size(t.members) from Team t";
//			List<Integer> sizeResult = em.createQuery(size, Integer.class).getResultList();
//			System.out.println("sizeResult = " + sizeResult.get(0));
			
			// 사용자 정의함수
//			String funQuery = "select function('function_name', m.username) from Member m";
//			List<String> funResult = em.createQuery(funQuery, String.class).getResultList();
//			System.out.println(funResult.get(0));
			
			// 상속 관계인 거만 보고 싶을때
//			em.createQuery("select i from Item i where type(i) = Book", Item.class).getResultList();	
			
			// 경로 탐색 : 상태 필드
			// 경로 탐색의 끝
//			String stateQuery = "select m.username from Member m";
//			List<String> stateResult = em.createQuery(stateQuery, String.class).getResultList();
//			System.out.println(stateResult.get(0));
			// 단일 값 연관 경로 (묵시적 내부 조인 발생)
			// 실무에서는 묵시적 내부 조인이 발생하는걸 막아야 한다... sql 튜닝이 어렵다.
			// 탐색이 가능하다. m.team.name 이런식으로
//			String stateQuery2 = "select m.team from Member m";
//			String stateQuery2_1 = "select m.team.name from Member m";
			// 이런식으로도 가능하다.
//			List<Team> stateResult2 = em.createQuery(stateQuery2, Team.class).getResultList();
//			System.out.println("stateResult2 " + stateResult2.get(0));
//			List<Team> stateResult2_1 = em.createQuery(stateQuery2_1, Team.class).getResultList();
//			System.out.println("stateResult2_1 " + stateResult2_1.get(0));
			
			// 컬렉션 값 연관 경로 (묵시적 내부 조인 발생)
			// 컬렉션 값은 탐색이 불가능하다.
//			String stateQuery3 = "select t.members from Team t";
//			String stateQuery3_1 = "select m.username from Team t join t.members m";
//			Collection stateResult3 = em.createQuery(stateQuery3, Collection.class).getResultList();
//			System.out.println("stateResult3 " + stateResult3);
//			List<String> stateResult3_1 = em.createQuery(stateQuery3_1, String.class).getResultList();
//			System.out.println("stateResult3_1 " + stateResult3_1);
			
			// 실무에서는 절대 묵시적 조인 쓰지 마라!!!! 명시적 조인을 사용해라!!!
			
			// 중요!! 패치 조인
			Team team1 = new Team();
			Team team2 = new Team();
			Team team3 = new Team();
			team1.setName("team1");
			team2.setName("team2");
			team3.setName("team3");
			em.persist(team1);
			em.persist(team2);
			em.persist(team3);
			
			Member member1 = new Member();
			Member member2 = new Member();
			Member member3 = new Member();
			Member member4 = new Member();
			member1.setUsername("member1");
			member1.changeTeam(team1);
			member2.setUsername("member2");
			member2.changeTeam(team1);
			member3.setUsername("member3");
			member3.changeTeam(team2);
			member4.setUsername("member4");
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);
			em.persist(member4);
			
//			String query = "select m from Member m";
//			List<Member> members = em.createQuery(query, Member.class).getResultList();
//			for(Member m : members) {
//				System.out.println("member = " + m.getUsername() + ", team = " + m.getTeam().getName());
//			}
			
//			String query2 = "select m from Member m join fetch m.team";
//			List<Member> members2 = em.createQuery(query2, Member.class).getResultList();
//			for(Member m : members2) {
//				System.out.println("member2 = " + m.getUsername() + ", team = " + m.getTeam().getName());
//			}
			
//			String query3 = "select distinct t from Team t join fetch t.members";
//			List<Team> team = em.createQuery(query3, Team.class).getResultList();
//			for(Team t : team) {
//				System.out.println("team = " + t.getName() + " | " + t.getMembers().size());
//				for(Member m : t.getMembers()) {
//					System.out.println("member = " + m.getUsername());
//				}
//			}
			
			// 1:N의 관계에서는 페이징 처리를 할 수 없다.
			// 객체 그래프는 컬렉션을 선택해서 가져오는게 아닌 모두 가져온다는 전제가 깔려있다.
			// 1:N을 페이징처리하면 하이버네이트에서 경고 로그를 남기고 메모리에서 페이징처리를 하기 때문에 매우 위험하다.
			// 결론 : 1:N을 페이징 처리하고 싶다면 N:1로 순서를 바꿔서 페이징 처리해야한다.
//			String query4 = "select t from Team t join fetch t.members";
//			List<Team> teamResult = em.createQuery(query4, Team.class)
//									  .setFirstResult(0)
//									  .setMaxResults(1)
//									  .getResultList();
			// 1:N 관계를 N:1로 바꿔서 페이징 처리한 것.
//			String query4_1 = "select m from Member m join fetch m.team t";
//			List<Member> teamResult2 = em.createQuery(query4_1, Member.class)
//					.setFirstResult(0)
//					.setMaxResults(1)
//					.getResultList();
//			for(Member t : teamResult2) {
//				System.out.println("team = " + t.getTeam().getName() + " | " + t.getTeam().getMembers().size());
//			}
			
//			String query5 = "select t from Team t";
//			List<Team> q5Result = em.createQuery(query5, Team.class)
//									.setFirstResult(0)
//									.setMaxResults(2)
//									.getResultList();
//			System.out.println("q5Result = " + q5Result.size());
//			for(Team t : q5Result) {
//				System.out.println("team = " + t.getName() + " | members = " + t.getMembers().size());
//				for(Member m : t.getMembers()) {
//					System.out.println("-> member = " + m.getUsername());
//				}
//			}
			
			// 엔티티 직접 사용 (PK)
			// 엔티티를 전달하거나 넣으면 기본적으로 식별할 수 있는 Id 값이 들어간다.
//			String query6 = "select m from Member m where m = :member";
//			List<Member> q6 = em.createQuery(query6, Member.class)
//								.setParameter("member", member1)
//								.getResultList();
//			for(Member m : q6) {
//				System.out.println("member = " + m.getUsername());
//			}
			
			// 엔티티 직접 사용 (FK)
//			String query7 = "select m from Member m where m.team = :team";
//			List<Member> q7 = em.createQuery(query7, Member.class)
//					.setParameter("team", team1)
//					.getResultList();
//			for(Member m : q7) {
//				System.out.println("member = " + m.getUsername());
//			}
			
			// Named쿼리
//			List<Member> namedQuery = em.createNamedQuery("Member.findByUserName", Member.class)
//										.setParameter("username", "member1")
//										.getResultList();
//			for(Member m : namedQuery) {
//				System.out.println(m.getUsername());
//			}
				
			// 벌크 연산 (이거도 강제 flush가 된다.(
			// flush가 나가는 경우 : commit, flush, 쿼리 날릴때
			int result = em.createQuery("update Member m set m.age = 20").executeUpdate();
			System.out.println(result);
			
			// ========== 벌크 연산한건 영속성 컨텍스트에 저장되어 있지 않고 DB에 직접 쿼리를 날리기 때문에
			// ========== 현재 가져오게 되는건 영속성 컨텍스트에 1차 캐시에 있는 0이 출력된다.
			// 벌크 연산 한 결과를 가져오기 위해서는 영속성 컨텍스트를 초기화 한 후 다시 조회해와야한다.
			System.out.println("member1.age = " + member1.getAge());
			System.out.println("member2.age = " + member2.getAge());
			System.out.println("member3.age = " + member3.getAge());
			System.out.println("member4.age = " + member4.getAge());
			Member findMemberTest = em.find(Member.class, member1.getId());
			// 이렇게 다시 조회해도 1차 캐시에 식별자로 저장되어 있기 때문에 DB에 접근하지 않고 1차 캐시에 있는 값을 가져온다.
			System.out.println(findMemberTest.getAge());
			
			em.clear();
			
			Member findMember = em.find(Member.class, member1.getId());
			System.out.println("member1.age = " + findMember.getAge());
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
