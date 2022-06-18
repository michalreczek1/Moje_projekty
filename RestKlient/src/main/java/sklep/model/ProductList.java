package sklep.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class ProductList {
    @XmlElement(name="product") // każdy element listy
    private final List<Product> products = new ArrayList<>();
    
    public ProductList() {
        // zostawia pustą listę
    }
    
    public ProductList(Collection<Product> products) {
        this.products.addAll(products);
    }
    
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
    
    public void setProducts(Collection<Product> products) {
        this.products.clear();
        this.products.addAll(products);
    }

}



