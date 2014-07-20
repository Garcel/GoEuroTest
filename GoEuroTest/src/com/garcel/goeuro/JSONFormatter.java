package com.garcel.goeuro;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

/**
 * JSONFormatter class which formats the data obtained from the url to fit our requirements.
 * 
 * @author Garcel
 * Project "GoEuroTest"
 * July 2014
 */
public class JSONFormatter {
	
	/**
	 * Method which formats the JSON document to fit our requirements.
	 * 
	 * @param data The original JSON document.
	 * @return the data correctly formated.
	 */
	public String format (String data, String fields){
		Logger logger = Logger.getLogger("JSONFormatter");
		//First we establish the csv heading with the data fields to be output.
		String output = fields + "\n";
		
		//Now we create a Gson object to map every JSONObject contained into the JSONArray to a LocationModel class.
		Gson gson = new Gson();
		JsonArray locations = (JsonArray) new JsonParser().parse(data);
		
		//For each of the JSONObjects obtained in the previous step, we get the data correctly formated.
		for (int i = 0; i < locations.size(); i ++){
			logger.info("Mapping Object..." +  (i + 1) + " of " + locations.size() +  " -> Input:\n" + locations.get(i).toString() + "\n");
			
			LocationModel lm = gson.fromJson(locations.get(i), LocationModel.class);
				
			logger.info("Output:\n" + lm.toString() + "\n");
			output += lm.toString();
			output += "\n";
		}
		
	return output;
	}
}
