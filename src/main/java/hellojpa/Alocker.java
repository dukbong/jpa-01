package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
// 1:1 관계
//@Entity
public class Alocker {

	@Id
	@GeneratedValue
	@Column(name = "LOCKER_ID")
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy = "aLocker")
	private Amember member;
	
	

	public Amember getMember() {
		return member;
	}

	public void setMember(Amember member) {
		this.member = member;
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
