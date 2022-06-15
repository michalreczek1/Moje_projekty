package rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/dt")
@Produces("text/plain")
public class DataICzas {
    private LocalDateTime dt = LocalDateTime.now();
    
    {
        System.out.println("Jest tworzony obiekt klasy DataICzas");
    }

    @GET
    public LocalDateTime dt() {
        return dt;
    }

    @Path("/date")
    @GET
    public LocalDate data() {
        return dt.toLocalDate();
    }
    
    @Path("/date/year")
    @GET
    public int year() {
        return dt.getYear();
    }

    @Path("/date/month")
    @GET
    public int month() {
        return dt.getMonthValue();
    }

    @Path("/date/day")
    @GET
    public int day() {
        return dt.getDayOfMonth();
    }

    @Path("/date/wd")
    @GET
    public String weekday() {
        return dt.getDayOfWeek().toString();
    }

    @Path("/date/doy")
    @GET
    public int doy() {
        return dt.getDayOfYear();
    }

    @Path("/time")
    @GET
    public LocalTime time() {
        return dt.toLocalTime();
    }

    @Path("/time/hour")
    @GET
    public int hour() {
        return dt.getHour();
    }

    @Path("/time/minute")
    @GET
    public int minute() {
        return dt.getMinute();
    }

    @Path("/time/second")
    @GET
    public int second() {
        return dt.getSecond();
    }

}



