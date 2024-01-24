package embeddedtype;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class EmMember {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
//	private LocalDateTime startDate;
//	private LocalDateTime endDate;
	@Embedded
	private Period workPeriod;
	
//	private String city;
//	private String street;
//	private String zipcode;
	@Embedded
	private Address homeAddress;
	
	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();

//  수정시 전체 삭제 후 다시 하나하나 인서트 하는 문제가 발생한다.
//	이를 해결하기 위해 실무에서는 값타입 컬렉션 대신 일대 다 관계를 고려해본다고 한다.
//	실제로 많이 사용된다고 한다.
//	@ElementCollection
//	@CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_iD"))
//	private List<Address> addressHistory = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AddressEntity> addressHistory = new ArrayList<>();
	
	@Embedded
	// 한 엔티티에서 같은 값 타입을 사용할때 사용
	@AttributeOverrides({
		@AttributeOverride(name = "city",
						   column = @Column(name = "WORK_CITY")),
		@AttributeOverride(name ="street",
						   column = @Column(name = "WORK_STREET")),
		@AttributeOverride(name = "zipcode",
						   column = @Column(name = "WORK_ZIPCODE"))
	})
	private Address workAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}



	public List<AddressEntity> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<AddressEntity> addressHistory) {
		this.addressHistory = addressHistory;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
	
	
	
}
