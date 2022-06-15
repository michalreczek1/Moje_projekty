package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_products", schema = "public", catalog = "sklep")
public class OrderProducts {
    @Id
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "quantity")
    private short quantity;
    @Basic
    @Column(name = "actual_price")
    private BigDecimal actualPrice;
    @Basic
    @Column(name = "actual_vat")
    private BigDecimal actualVat;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getActualVat() {
        return actualVat;
    }

    public void setActualVat(BigDecimal actualVat) {
        this.actualVat = actualVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProducts that = (OrderProducts) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (actualPrice != null ? !actualPrice.equals(that.actualPrice) : that.actualPrice != null) return false;
        if (actualVat != null ? !actualVat.equals(that.actualVat) : that.actualVat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + productId;
        result = 31 * result + (int) quantity;
        result = 31 * result + (actualPrice != null ? actualPrice.hashCode() : 0);
        result = 31 * result + (actualVat != null ? actualVat.hashCode() : 0);
        return result;
    }
}
