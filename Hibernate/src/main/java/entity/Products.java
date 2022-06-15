package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedQuery(name="Products.findAll", query="SELECT p FROM Products p")
public class Products {
    @Id
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "vat")
    private BigDecimal vat;
    @Basic
    @Column(name = "description")
    private String description;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (productId != products.productId) return false;
        if (productName != null ? !productName.equals(products.productName) : products.productName != null)
            return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (vat != null ? !vat.equals(products.vat) : products.vat != null) return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
