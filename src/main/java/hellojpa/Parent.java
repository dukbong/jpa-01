package hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {

	@Id
	@GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "parent",
			   cascade = CascadeType.ALL, // 영속성 전이 (편리성)
			   orphanRemoval = true) // 참조가 제거된 엔티티는 고아객체가 되므로 해당 엔티티도 삭제된다. 
	private List<Child> childList = new ArrayList<>();
	
	
	
	public List<Child> getChildList() {
		return childList;
	}

	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}

	public void addChild(Child child) {
		childList.add(child);
		child.setParent(this);
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
