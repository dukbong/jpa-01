package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

//N:N관계 (실무에서 사용하지 않는다. N:1 관계로 풀어사용하는게 좋다.)

//@Entity
public class Bproduct {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;
	private String name;
	
//	N:N
//	@ManyToMany(mappedBy = "products")
//	private List<Bmember> members = new ArrayList<>();
	
//	N:N 관계를 N:1로 바꿔서 사용
	@OneToMany(mappedBy = "product")
	private List<BmemberProduct> memberProducts = new ArrayList<>();
	
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
