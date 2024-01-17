package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class BmemberProduct {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Bmember member;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Bproduct product;
}
