package rest;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sklep.db.DBConnection;
import sklep.db.DBException;
import sklep.db.ProductDAO;
import sklep.db.RecordNotFound;
import sklep.model.Product;

@Path("/products.json")
@Produces("application/json")
@Consumes("application/json")
public class RProductsJson {
    @GET
    public List<Product> readAll() throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.readAll();
        }
    }
    @GET
    @Path("/{id}")
    public Product readOne(@PathParam ("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId);
        }
    }
    
    @GET
    @Path("/{id}/price")
    public BigDecimal getPrice(@PathParam("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId).getPrice();
        }
    }

    @POST
    public Product add(Product product) throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            productDAO.save(product);
            db.commit();
            return product;
        }
    }

    
}
