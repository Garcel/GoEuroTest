package com.garcel.main;

import org.apache.log4j.Logger;

import com.garcel.csv.CSVWriter;
import com.garcel.goeuro.JSONFormatter;
import com.garcel.json.JSONReader;

/**
 * Main class which starts the program.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class Main {
	private static final String APIURL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	//The name of the data fields  we need from the API, to be used as csv heading.
	private static final String fields = "_type;_id;name;type;latitude;longitude";
	/**
	 * Main method.
	 * 
	 * @param args The string to be consulted in the API.
	 */
	public static void main (String [] args){
		Logger logger = Logger.getLogger("Main");
		
		//if args < 0, no string was introduced so program finishes.
		if (args.length > 0){
			logger.info("Making query request...");
			
			JSONReader jr = new JSONReader (APIURL + args[0]);
			
			String content = jr.read();
				
			if(!content.equals("[]") && !content.equals("")){
				logger.info("Formating data...");
					
				JSONFormatter jf = new JSONFormatter ();
				String fData = jf.format(content, fields);
					
				logger.info("Saving data to file...");
					
				CSVWriter tw = new CSVWriter (args[0]);
				tw.save(fData);
				logger.info("Program finished without errors.");
			}
			else{
				logger.warn("No data to save.");
				}
		}else
			logger.error("ERROR: No input string.");
	}
}
