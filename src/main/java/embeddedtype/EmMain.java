package embeddedtype;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			Address address = new Address("city", "street", "10000");
			
			EmMember member1 = new EmMember();
			member1.setUsername("HELLO");
			member1.setHomeAddress(address);
//			member1.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));
			em.persist(member1);

			Address newAddress = new Address("Newcity", address.getStreet(), address.getZipcode());
			member1.setHomeAddress(newAddress);
			
			// 아래의 부작용을 없애기 위해서는
//			Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
			// 이런 방법 혹은 setter를 없애버리거나 private으로 만들면 된다.
//			EmMember member2 = new EmMember();
//			member2.setUsername("HELLO");
//			member2.setHomeAddress(copyAddress);
//			em.persist(member2);
			
			// 임베디드 타입 값을 여러 엔티티에서 공유하면 위험한 이유
			// 이러면 update 쿼리가 member1, member2 모두 날아간다
			// 부작용!!
//			member1.getHomeAddress().setCity("newCity");
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
