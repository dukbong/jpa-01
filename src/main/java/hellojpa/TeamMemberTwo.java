package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// 1:N 관계

//@Entity
public class TeamMemberTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBERTWO_ID")
	private Long id;
	
	@Column(name = "USERNAMETWO")
	private String name;
	
	@ManyToOne
	// 1:N 관계를 만들었을때 억지로 양방향 관계를 만들면 아래와 같이 할 수 있다.
	// 연관관계 주인 같지만 insert와 update를 false로 하여 조회만 가능하도록 만든다.
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
	private TeamTwo team;
	
	
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
}
