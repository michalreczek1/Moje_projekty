package rest.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        String tresc = String.format("<html><body>"
                + "<h1>Błąd</h1>"
                + "<div>Błąd typu <code>%s</code></div>"
                + "<div style='color:red'>%s</div>"
                + "</body></html>",
                e.getClass().getName(),
                e.getMessage());
        
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .type("text/html;charset=utf-8")
                .entity(tresc)
                .build();
    }

}



