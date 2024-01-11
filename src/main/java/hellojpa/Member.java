package hellojpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
// Table Name은 기본적으로 Class Name으로 지정된다.
// 변경하고 싶다면 아래와 같이 지정할 수 있다.
// @Table(name = "Member")
//@Table(name = "MBR")
public class Member {
	
	@Id
	private Long id;
	
	@Column(name = "name")
	private String username;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	// 기본값 : EnumType.ORDINAL
	// 이걸 권장하지 않는 이유 : 만약 순서가 변경되면 기존 DB는 변경되지 않기때문에 문제가 발생한다.
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;
	
	// 이건 JPA에서 제공하는 어노테이션이다.
	// 해당 필드는 DB와 전혀 상관없이 메모리에서 사용하고 할때 사용한다.
	@Transient
	private int temp;
	
}
