package sklep.soap;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import sklep.db.DBConnection;
import sklep.db.DBException;
import sklep.db.OrderDAO;
import sklep.db.ProductDAO;
import sklep.db.RecordNotFound;
import sklep.model.Order;
import sklep.model.Product;
import sklep.photo.PhotoUtil;

/*
Usługi sieciowe SOAP w Javie - technologia JAX-WS.
Za tłumaczenie obiektów Javy do XML i z powrotem odpowiada technologia JAXB.
*/
@WebService
@MTOM
public class Sklep {

    @WebResult(name="product")
    public List<Product> odczytajWszystkieProdukty() throws DBException {
        try (DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.readAll();
        }
    }
    
    @WebResult(name="product")
    public Product odczytajWedlugId(@WebParam(name="id") int productId) throws DBException, RecordNotFound {
        try (DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId);
        }
    }
    
    @WebResult(name="product")
    public List<Product> odczytajWedlugCen(
            @WebParam(name="min") BigDecimal minPrice,
            @WebParam(name="max") BigDecimal maxPrice) throws DBException {
        try (DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findByPrice(minPrice, maxPrice);
        }
    }
    
    @WebResult(name="order")
    public List<Order> odczytajWszystkieZamowienia() throws DBException {
        try (DBConnection db = DBConnection.open()) {
            OrderDAO orderDAO = db.orderDAO();
            return orderDAO.readAll();
        }
    }
    
    public void zapiszProdukt(@WebParam(name="product") Product product) throws DBException {
        try (DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            productDAO.save(product);
        }
    }
    
    @WebResult(name="image")
    public byte[] foto(
                    @WebParam(name="id") int productId) throws DBException, RecordNotFound {
            return PhotoUtil.readBytes(productId);
    }
    
}



