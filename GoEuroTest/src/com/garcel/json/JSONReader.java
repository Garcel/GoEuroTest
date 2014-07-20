package com.garcel.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;  

import org.apache.log4j.Logger;

/**
 * Class JSONRedaer which reads data from the Location JSON API, by appending the string we just introduced to the API url.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class JSONReader {
	private String json = "";
	private URL url;
	private HttpURLConnection urlC;
	private Logger logger;
	
	/**
	 * Constructor.
	 * 
	 * @param st The string to be appended to the API url.
	 */
	public JSONReader (String st){
		logger = Logger.getLogger("JSONReader");
	    try {
	    	url = new URL(st);
	    	logger.info("Accesing url " + url);
	    	
			urlC =  (HttpURLConnection) url.openConnection();
			urlC.connect();
			logger.info("Connecting to url...");
			
		} catch (MalformedURLException e) {
			logger.error("ERROR: Url is not valid.");
		}catch (IOException e){
			logger.error("ERROR: Connection couldn't be established.");
		}
	}
	
	/**
	 * Method which reads data from our customized url.
	 * 
	 * @return data from our customized url.
	 */
	public String read (){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader( urlC.getInputStream()));
			
			logger.info("Reading data from url...");
			String aux = "";
			while ((aux = in.readLine()) != null){
				json += aux;
			}
			logger.info("DONE. Data read: \n\n" + json + "\n");
			
			in.close();
			logger.info("Closing connection.");
		} catch (IOException e) {
			logger.error("ERROR: Connection couldn't be established.");
		}
		
		return json;
	}
}
