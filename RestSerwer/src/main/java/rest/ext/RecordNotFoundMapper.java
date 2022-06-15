package rest.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import sklep.db.RecordNotFound;
@Provider
public class RecordNotFoundMapper implements ExceptionMapper<RecordNotFound> {

    @Override
    public Response toResponse(RecordNotFound e) {
        String tresc = String.format("<html><body>"
                + "<h1>A ku ku.. nic nie znaleziono.</h1>"
                + "<div style='color:red'>%s</div>"
                + "</body></html>",
                e.getMessage());
        
        return Response.status(Response.Status.NOT_FOUND)
                .type("text/html;charset=utf-8")
                .entity(tresc)
                .build();
    }

}



