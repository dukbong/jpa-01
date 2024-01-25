package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// 가장 정규화된 상태로 만들어준다.
// 장점으로는 외래키 제약조건 무결성 활용 가능 및 저장 공간 효율화
// 단점으로는 조회시 조인이 많아지고 쿼리가 복잡하다. (하지만 성능에 저하 관련 내용은 없다.)
// JOINED 방식이 가장 좋다.

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략 테이블 하나에 올인 <성능에 좋다.>
// 단일 테이블 전략은 hibernate가 자동으로 Dtype을 만들어준다. @DiscriminatorColumn 생략 가능
// 장점은 성능이 빠르며 조회 쿼리가 단순하다.
// 단점은 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야한다.
// 그리고 테이블이 너무 커질 수 있다.

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 각각의 테이블로 만든다.
// 각각의 테이블로 만들때는 @DiscriminatorColumn 필요없어진다.
// 이럴땐 부모 클래스는 추상 클래스로 만들어야한다.
// 하지만 조회시 상당히 비효율적으로 조회된다.
// 이 전략은 절대 사용하지 않는 것이 좋다.

@DiscriminatorColumn 
// 기본적으로는 자식 (클래스)엔티티 명이 들어가는 컬럼을 만들어주고 insert시 해당 엔티티명을 자동으로 넣어준다.
// 기본적으로 DType이라는 컬럼이 생기며 이름 수정이 가능하다.
// 만약 엔티티명이 아닌 별도의 값을 넣어주고 싶다면 자식 (클래스) 엔티티에서 @DiscriminatorValue로 지정할 수 있다.
public class Citem {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private int price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
