package embeddedtype;

import java.util.List;
import java.util.Set;

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
//			Address address = new Address("city", "street", "10000");
			
//			EmMember member1 = new EmMember();
//			member1.setUsername("HELLO");
//			member1.setHomeAddress(address);
//			member1.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));
//			em.persist(member1);

//			Address newAddress = new Address("Newcity", address.getStreet(), address.getZipcode());
//			member1.setHomeAddress(newAddress);
			
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
			
			EmMember member = new EmMember();
			member.setUsername("member1");
			member.setHomeAddress(new Address("homecity", "street", "10000"));
			
			member.getFavoriteFoods().add("치킨");
			member.getFavoriteFoods().add("족발");
			member.getFavoriteFoods().add("피자");
			
			member.getAddressHistory().add(new AddressEntity("old1", "streetOld1", "1"));
			member.getAddressHistory().add(new AddressEntity("old2", "streetOld2", "2"));
			
			em.persist(member);
			
			em.flush();
			em.clear();
			System.out.println("============select============");
			// 값 타입 켈렉션은  기본적으로 지연로딩이다.
			EmMember findMember = em.find(EmMember.class, member.getId());
			
			List<AddressEntity> addressHistory = findMember.getAddressHistory();
			for(AddressEntity add : addressHistory) {
				System.out.println("Address = " + add.getAddress().getCity());
			}
			
			Set<String> favoriteFood = findMember.getFavoriteFoods();
			for(String str : favoriteFood) {
				System.out.println("Facorite_food = " + str);
			}
			System.out.println("============select============");
			
			System.out.println("============update============");
			Address a = findMember.getHomeAddress();
			findMember.setHomeAddress(new Address("newnewCity", "street", "30000"));
			
			// 값 타입 컬렉션들은 값을 변경하는게 아니고 갈아 끼워야한다.
			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");
			
			findMember.getAddressHistory().remove(new AddressEntity("old1", "streetOld1", "1"));
			findMember.getAddressHistory().add(new AddressEntity("NEW_old1", "street_new_Old1", "1"));
			System.out.println("============update============");
			
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
