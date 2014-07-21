package test.garcel.goeuro;

import static  org.junit.Assert.*;

import org.junit.Test;

import com.garcel.goeuro.JSONFormatter;

/**
 * JSONFormatterTest class which tests JSONFormatter class.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class JSONFormatterTest {
	
	/**
	 * Method which tests the correctness of the formatted data output.
	 */
	@Test
	public void formatTest (){

		JSONFormatter j = new JSONFormatter ();
	
		String input = "[{\"_type\":\"Position\",\"_id\":378655,\"key\":null,\"name\":\"Madrid\",\"fullName\":\"Madrid, Spain\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Spain\",\"geo_position\":{\"latitude\":40.4165,\"longitude\":-3.70256},\"location_id\":378655,\"inEurope\":true,\"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null}]";
		String fields = "_type;_id;name;type;latitude;longitude";
		assertEquals(j.format (input, fields), fields + "\n" + "Position;378655;Madrid;location;40.4165;-3.70256" + "\n");
	}
}
