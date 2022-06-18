package klient;

import javax.ws.rs.core.MediaType;

public class Ustawienia {
    
    public static final String URL_SERWERA = "http://localhost:8080/PC23-RestSerwer-1.0/";
    
    public static String rozszerzenieDlaTypu(MediaType mediaType) {
        switch(mediaType.getSubtype()) {
            case "xml": return "xml";
            case "html": return "html";
            case "plain": return "txt";
            case "json": return "json";
            case "png": return "png";
            case "jpeg": return "jpg";
            default: return "";
        }
    }

}



