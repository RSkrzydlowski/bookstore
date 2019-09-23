package pl.skrzydlowski.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	public Contact(String email, String phoneNumber, Customer customer) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customer = customer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;

	private String email;
	private String phoneNumber;
	
	@ManyToOne
	private Customer customer;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
