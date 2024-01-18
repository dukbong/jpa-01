package hellojpa;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
// 상속 관계 매핑이 아닌 해당 클래스의 속성만 사용하고 싶을때 사용한다.
// 사용 예시는 공통되는 컬럼을 이런식으로 사용한다.
// 이것은 엔티티가 아니다!
// 직접 생성해서 사용할 일이 없으므로 추상 클래스를 권장한다.
// @Entity 클래스는 엔티티나 @MappedSuperclass로 지정된 클래스만 상속 가능하다.
public abstract class BaseEntity {

	private String lastModifiedby;
	private LocalDateTime lastModifiedDate;
	
	public String getLastModifiedby() {
		return lastModifiedby;
	}
	public void setLastModifiedby(String lastModifiedby) {
		this.lastModifiedby = lastModifiedby;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
}
