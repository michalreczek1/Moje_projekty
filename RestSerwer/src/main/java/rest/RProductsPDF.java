package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sklep.db.DBConnection;
import sklep.db.DBException;
import sklep.db.ProductDAO;
import sklep.db.RecordNotFound;
import sklep.model.Product;
import sklep.model.ProductList;

@Path("/products.pdf")
@Produces("application/pdf")
public class RProductsPDF {
    @GET
    public ProductList readAll() throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return new ProductList(productDAO.readAll());
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
    
}



