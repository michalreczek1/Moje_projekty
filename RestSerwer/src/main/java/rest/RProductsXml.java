package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sklep.db.DBConnection;
import sklep.db.DBException;
import sklep.db.ProductDAO;
import sklep.db.RecordNotFound;
import sklep.model.Price;
import sklep.model.Product;

@Path("/products.xml")
@Produces("application/xml")
@Consumes("application/xml")
public class RProductsXml {
    @GET
    public List<Product> readAll() throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.readAll();
        }
    }
    
    @GET
    @Path("/{id}")
    public Product readOne(@PathParam("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId);
        }
    }
    
    @GET
    @Path("/{id}/price")
    public Price getPrice(@PathParam("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return new Price(productDAO.findById(productId).getPrice());
        }
    }
    
    @PUT
    @Path("/{id}/price")
    public void setPrice(
                @PathParam("id") int productId,
                Price newPrice
            ) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            Product product = productDAO.findById(productId);
            product.setPrice(newPrice.getValue());
            productDAO.update(product);
            db.commit();
        }
    }
   
}



