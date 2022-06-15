package sklep.model;

import java.util.Objects;

public class Customer {
	private String email;
	private String name;
	private String phone;
	private String address;
	private String postalCode;
	private String city;
	
	public Customer() {
	}
	
	public Customer(String email, String name, String phone, String address, String postalCode, String city) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, address, city, phone, postalCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(phone, other.phone) && Objects.equals(postalCode, other.postalCode);
	}

}
