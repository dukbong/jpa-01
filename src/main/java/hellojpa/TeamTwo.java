package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

// 1:N 관계

//@Entity
public class TeamTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAMTWO_ID")
	private Long id;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "TEAMTWO_ID")
	private List<TeamMemberTwo> members = new ArrayList<>();
	
	
	public List<TeamMemberTwo> getMembers() {
		return members;
	}
	public void setMembers(List<TeamMemberTwo> members) {
		this.members = members;
	}
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
