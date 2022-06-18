package sklep.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String s) throws Exception {
		// TODO Auto-generated method stub
		return LocalDateTime.parse(s);
	}

	@Override
	public String marshal(LocalDateTime dt) throws Exception {
		return dt.toString();
	}

}
