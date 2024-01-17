package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

// N:N관계 (실무에서 사용하지 않는다. N:1 관계로 풀어사용하는게 좋다.)
//@Entity
public class Bmember {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String userName;
	
//	N:N 관계
//	@ManyToMany
//	@JoinTable(name = "MEMBER_PRODUCT")
//	private List<Bproduct> products = new ArrayList<>();

//	N:N 관계를 N:1 관계로 변경
	@OneToMany(mappedBy = "member")
	private List<BmemberProduct> memberProducts = new ArrayList<>(); 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
