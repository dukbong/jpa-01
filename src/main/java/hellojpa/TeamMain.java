package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
			Team team = new Team();
			team.setName("team1");
//			team.getMembers().add(member);
			em.persist(team);
			
			TeamMember member = new TeamMember();
			member.setName("member1");
			member.changeTeam(team);
			em.persist(member);
			
//			TeamMember에 setTeam에 아래 코드를 넣어 주었다.
//			team.getMembers().add(member);
			
//			em.flush();
//			em.clear();
			
			Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
			List<TeamMember> members = findTeam.getMembers();
			
			System.out.println("===================");
			for(TeamMember m : members) {
				System.out.println("m = " + m.getName());
			}
			System.out.println("===================");
			
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
