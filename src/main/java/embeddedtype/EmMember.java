package embeddedtype;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	
}
