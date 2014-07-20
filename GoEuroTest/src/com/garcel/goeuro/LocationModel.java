package com.garcel.goeuro;

import com.google.gson.Gson;

/**
 * Class which represents the Location object, representing each of the JSONObjects into the JSONArray obtained.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class LocationModel {

	private final String _type;
	private final String _id;
	private final String name;
	private final String type;
	private Geo_Position geo_position;
	private final String latitude;
	private final String longitude;
	
	/**
	 * Constructor.
	 * 
	 * @param _type
	 * @param _id
	 * @param name
	 * @param type
	 * @param geo_position
	 */
	public LocationModel (String _type, String _id, String name, String type, String geo_position){
		this._type = _type;
		this._id = _id;
		this.name = name;
		this.type = type;
		
		Gson gson = new Gson();
		this.geo_position = gson.fromJson(geo_position, Geo_Position.class);
		this.latitude = this.geo_position.getLatitude();
		this.longitude = this.geo_position.getLongitude();
	}

	/**
	 * Method which returns _type attribute.
	 * 
	 * @return _type
	 */
	public String get_type() {
		return _type;
	}

	/**
	 * Method which returns _id attribute.
	 * 
	 * @return _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * Method which returns name attribute.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method which returns type attribute.
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method which returns latitude attribute.
	 * 
	 * @return latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Method which returns longitude attribute.
	 * 
	 * @return longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	
	/**
	 * Method which returns the string representation of the object.
	 */
	@Override
	public String toString (){
		return _type + ";" + _id + ";" + name + ";" + type + ";" + geo_position.toString();
	}
	
	/**
	 * Class which represents the Geo_Position object.
	 * 
	 * @author Garcel
	 * Project "GoEuroTest"
	 * July 2014
	 */
	private class Geo_Position {
		private String latitude;
		private String longitude;
		
		/**
		 * Constructor.
		 * 
		 * @param latitude
		 * @param longitude
		 */
		private Geo_Position (String latitude, String longitude){
			this.latitude = latitude;
			this.longitude = longitude;
		}

		/**
		 * Method which returns latitude attribute.
		 * 
		 * @return latitude
		 */
		private String getLatitude() {
			return latitude;
		}

		/**
		 * Method which returns longitude attribute.
		 * 
		 * @return longitude
		 */
		private String getLongitude() {
			return longitude;
		}
		
		/**
		 * Method which returns the string representation of the object.
		 */
		@Override
		public String toString (){
			return latitude + ";" + longitude;
		}
	}
}
