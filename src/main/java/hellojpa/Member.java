package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
// Table Name은 기본적으로 Class Name으로 지정된다.
// 변경하고 싶다면 아래와 같이 지정할 수 있다.
// @Table(name = "Member")
//@Table(name = "MBR")

// 시퀀스 만들기
@SequenceGenerator(name = "member_seq_generator",
				   sequenceName = "member_seq",
				   initialValue = 1,
				   allocationSize = 50)

//@TableGenerator(name = "member_seq_generator",
//				table = "MY_SEQUENCES",
//				pkColumnValue = "member_seq",
//				allocationSize = 1)
public class Member {
	
	@Id // 직접 할당
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
				    generator = "member_seq_generator") 
	
	/* @GeneratedValue // 자동생성
	 * IDENTITY : 기본키 생성을 데이터 베이스에 위임
	 * SEQUENCES : DB에서의 시퀀스 사용
	 * */
	
//	@GeneratedValue(strategy = GenerationType.TABLE,
//					generator = "member_seq_generator")
	
	private Long id;
	
	@Column(name = "name")
	private String username;

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
	
//	private int age;
//	
//	@Enumerated(EnumType.STRING)
//	// 기본값 : EnumType.ORDINAL
//	// 이걸 권장하지 않는 이유 : 만약 순서가 변경되면 기존 DB는 변경되지 않기때문에 문제가 발생한다.
//	private RoleType roleType;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createDate;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
//	
//	@Lob
//	private String description;
//	
//	// 이건 JPA에서 제공하는 어노테이션이다.
//	// 해당 필드는 DB와 전혀 상관없이 메모리에서 사용하고 할때 사용한다.
//	@Transient
//	private int temp;
	
	
	
}
