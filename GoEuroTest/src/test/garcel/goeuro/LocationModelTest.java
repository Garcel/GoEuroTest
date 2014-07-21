package test.garcel.goeuro;

import static  org.junit.Assert.*;

import org.junit.Test;

import com.garcel.goeuro.LocationModel;

/**
 * LocationModelTest class which tests LocationModel class.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class LocationModelTest {

	/**
	 * Method which tests the correct creation of the class objects by running the constructor. Also tests getters.
	 */
	@Test
	public void constructorTest (){
		LocationModel lm = new LocationModel ("Position", "378655", "Madrid", "location", "{latitude:40.4165,longitude:-3.70256}");
		
		assertEquals ("_type attribute test", lm.get_type(), "Position");
		assertEquals ("_id attribute test", lm.get_id(), "378655");
		assertEquals ("name attribute test", lm.getName(), "Madrid");
		assertEquals ("location attribute test", lm.getType(), "location");
		assertEquals ("latitude attribute test", lm.getLatitude(), "40.4165");
		assertEquals ("longitude attribute test", lm.getLongitude(), "-3.70256");
	}
	
	/**
	 * Method which tests the LocationModel class toString() method.
	 */
	@Test
	public void toStringTest (){
		LocationModel lm = new LocationModel ("Position", "378655", "Madrid", "location", "{latitude:40.4165,longitude:-3.70256}");
		
		assertEquals ("to string method test", lm.toString(), "Position;378655;Madrid;location;40.4165;-3.70256");
	}
}
