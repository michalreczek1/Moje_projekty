package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {
    @Id
    @Basic
    @Column(name = "customer_email")
    private String customerEmail;
    @Basic
    @Column(name = "customer_name")
    private String customerName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;
    @Basic
    @Column(name = "city")
    private String city;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (customerEmail != null ? !customerEmail.equals(customers.customerEmail) : customers.customerEmail != null)
            return false;
        if (customerName != null ? !customerName.equals(customers.customerName) : customers.customerName != null)
            return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (postalCode != null ? !postalCode.equals(customers.postalCode) : customers.postalCode != null) return false;
        if (city != null ? !city.equals(customers.city) : customers.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerEmail != null ? customerEmail.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
