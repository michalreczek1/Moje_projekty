package sklep.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlAttribute(name="id")
    private Integer orderId;
    
    @XmlAttribute(name="customer-email")
    private String customerEmail;

    @XmlElement(name="order-date")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private LocalDateTime orderDate;
    
    @XmlAttribute(name="status")
    private Status orderStatus;
    
    @XmlElementWrapper(name = "products")
    @XmlElement(name="product")
    private final List<OrderProduct> products = new ArrayList<>();
    
    public Order() {
    }

    public Order(Integer orderId, String customerEmail, LocalDateTime orderDate, Status orderStatus) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public static Order ofDbFields(int orderId, String customerEmail, java.sql.Timestamp orderDate, String orderStatus) {
        return new Order(orderId, customerEmail,
                orderDate.toLocalDateTime(),
                Status.valueOf(orderStatus));
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public List<OrderProduct> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(OrderProduct product) {
        this.products.add(product);
    }

    public void addProducts(Collection<OrderProduct> products) {
        this.products.addAll(products);
    }

    public void setProducts(Collection<OrderProduct> products) {
        this.products.clear();
        this.products.addAll(products);
    }

    
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerEmail=" + customerEmail + ", orderDate=" + orderDate
                + ", orderStatus=" + orderStatus + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerEmail, orderDate, orderId, orderStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return Objects.equals(customerEmail, other.customerEmail) && Objects.equals(orderDate, other.orderDate)
                && Objects.equals(orderId, other.orderId) && orderStatus == other.orderStatus;
    }


    public enum Status {
        unpaid,
        paid,
        shipped,
        closed;
    }
}



