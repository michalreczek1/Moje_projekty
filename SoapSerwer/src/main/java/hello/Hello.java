package hello;

import java.time.LocalTime;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Hello {
	public String witaj(@WebParam(name="imie") String imie) {
		return "Witaj" + imie;
	}
	
public String czas() {
	return LocalTime.now().toString();
}
@WebResult (name="wynik")
public int dodaj (@WebParam(name="liczba1")int x,@WebParam(name="liczba2") int y) {
	
	return x+y;
}
@WebResult (name="wynik")
public int oblicz (@WebParam(name="dzialanie") String dzialanie,@WebParam(name="liczba1")  int x,@WebParam(name="liczba2")  int y) {

	if (dzialanie.equals("+")) {
		return x+y;
	}
	else if (dzialanie.equals("-")) {
		return x-y;
	}
	else if (dzialanie.equals("*")) {
		return x*y;
	}
	else if (dzialanie.equals("/")) {
		return x/y;
	}
	else return 0;
}



}
