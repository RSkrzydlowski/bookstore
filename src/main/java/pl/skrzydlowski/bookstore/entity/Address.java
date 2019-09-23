package pl.skrzydlowski.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	public Address(String locality, String zipCode, String street, String streetNumber) {
		this.locality = locality;
		this.zipCode = zipCode;
		this.street = street;
		this.streetNumber = streetNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;

	private String locality;
	private String zipCode;
	private String street;
	private String streetNumber;

	

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

}
