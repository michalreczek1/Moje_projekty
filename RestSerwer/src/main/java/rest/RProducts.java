package rest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import sklep.db.DBConnection;
import sklep.db.DBException;
import sklep.db.ProductDAO;
import sklep.db.RecordNotFound;
import sklep.model.Product;
import sklep.photo.PhotoUtil;

@Path("/products")
public class RProducts {
    @GET
    @Produces({"application/xml", "application/json", "text/plain"})
    public List<Product> readAll() throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.readAll();
        }
    }
    
    // Ten sam adres może być obsługiwany przez kilka metod, które produkują wynik w różbych formatach
    
    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json", "text/plain"})
    public Product readOne(@PathParam("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId);
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces("text/html;charset=UTF-8")
    public String readOneHtml(@PathParam("id") int productId) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            Product product = productDAO.findById(productId);
            return "<html><body>" + product.getHtml() + "</body><html>";
        }
    }
    
    @GET
    @Path("/{id}/price")
    @Produces({"application/json", "text/plain"})
    public BigDecimal getPrice(
                @PathParam("id") int productId
            ) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            return productDAO.findById(productId).getPrice();
        }
    }

    // Dla operacji PUT i POST jeden (i tylko jeden) z parametrów powinien być pozostawiony bez żadnej adnotacji.
    // To właśnie do tego parametru zostaną wpisane dane, które przyszły w treści zapytania (tzw Body albo Entity).
    // Adnotacja @Consumes mówi w jakim formacie te dane mogą być przysłane.
    @PUT
    @Path("/{id}/price")
    @Consumes({"application/json", "text/plain"})
    public void setPrice(
                @PathParam("id") int productId,
                BigDecimal newPrice
            ) throws DBException, RecordNotFound {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            Product product = productDAO.findById(productId);
            product.setPrice(newPrice);
            productDAO.update(product);
            db.commit();
        }
    }
    
    // W tej wersji w odpowiedzi na polecenie POST wysyłamy specjalny kod Created z nagłówkiem Location
    // wskazując URL, pod którym znajduje się utworzony rekord.
    // To jest rozwiązanie zalecane przez standardy.
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response add(Product product,
            @Context UriInfo uriInfo) throws DBException {
        try(DBConnection db = DBConnection.open()) {
            ProductDAO productDAO = db.productDAO();
            productDAO.save(product);
            db.commit();
            
            URI location = uriInfo
                    .getAbsolutePathBuilder()
                    .path("{id}")
                    .build(product.getProductId());
            return Response.created(location).build();
        }
    }
    
    @GET
    @Path("/{id}/photo")
    @Produces("image/jpeg")
    public byte[] getPhoto(
                @PathParam("id") int productId
            ) throws DBException, RecordNotFound {
        
        return PhotoUtil.readBytes(productId);
    }
    
}



