package test.garcel.json;

import static  org.junit.Assert.*;

import org.junit.Test;

import com.garcel.json.JSONReader;

/**
 * JSONReaderTest class which tests JSONReader class.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class JSONReaderTest {
	
	/**
	 * Method which tests JSONReader class read () method.
	 */
	@Test
	public void formatTest (){
		String url = "http://api.goeuro.com/api/v2/position/suggest/en/Madrid";
		JSONReader j = new JSONReader (url);
		
		String output = "[{\"_type\":\"Position\",\"_id\":378655,\"key\":null,\"name\":\"Madrid\",\"fullName\":\"Madrid, Spain\",\"iata_airport_code\":null," +
		"\"type\":\"location\",\"country\":\"Spain\",\"geo_position\":{\"latitude\":40.4165,\"longitude\":-3.70256},\"location_id\":378655,\"inEurope\":true," +
		"\"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null},{\"_type\":\"Position\",\"_id\":378654,\"key\":null,\"name\":\"Madridejos\",\"fullName\":" +
		"\"Madridejos, Spain\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Spain\",\"geo_position\":{\"latitude\":39.46823,\"longitude\":-3.53196}," +
		"\"location_id\":378654,\"inEurope\":true,\"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null},{\"_type\":\"Position\",\"_id\":430256,\"key\":null," +
		"\"name\":\"Madridanos\",\"fullName\":\"Madridanos, Spain\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Spain\",\"geo_position\":" + 
		"{\"latitude\":41.47967,\"longitude\":-5.6046},\"location_id\":430256,\"inEurope\":true,\"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null}," +
		"{\"_type\":\"Position\",\"_id\":378630,\"key\":null,\"name\":\"Las Rozas de Madrid\",\"fullName\":\"Las Rozas de Madrid, Spain\",\"iata_airport_code\":null," +
		"\"type\":\"location\",\"country\":\"Spain\",\"geo_position\":{\"latitude\":40.49292,\"longitude\":-3.87371},\"location_id\":378630,\"inEurope\":true,\""+
		"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null},{\"_type\":\"Position\",\"_id\":314957,\"key\":null,\"name\":\"Madrid\",\"fullName\":\"Madrid (MAD), Spain" +
		"\",\"iata_airport_code\":\"MAD\",\"type\":\"airport\",\"country\":\"Spain\",\"geo_position\":{\"latitude\":40.468257904052734,\"longitude\":-3.5695650577545166}," + 
		"\"location_id\":378540,\"inEurope\":true,\"countryCode\":\"ES\",\"coreCountry\":true,\"distance\":null}]";
		assertEquals(j.read(), output);
		
		url = "http://api.goeuro.com/api/v2/position/suggest/en/empty";
		j = new JSONReader (url);
		output = "[]";
		assertEquals(j.read(), output);
	}
}
