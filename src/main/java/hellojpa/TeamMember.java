package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String name;
	
	@ManyToOne 
	// TEAMMEMBER는 N , TEAM은 1의 관계
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Long getTeamId() {
//		return teamId;
//	}
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}
	public Team getTeam() {
		return team;
	}
	
	// 연관 관계 편의 메소드
//	public void setTeam(Team team) {
	public void changeTeam(Team team) {
		this.team = team;
		// 순수 객체 상태를 고려하여 양쪽에서 값을 설정할 수 있어야 한다.
		team.getMembers().add(this);
	}
	
	
}
