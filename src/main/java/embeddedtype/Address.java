package embeddedtype;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	// 임베디드 타입은 기본생성자가 필수이다.
	public Address() {
		super();
	}
	
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	private String city;
	private String street;
	private String zipcode;
	
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public String getZipcode() {
		return zipcode;
	}
	
	

}
