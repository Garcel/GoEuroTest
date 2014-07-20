package com.garcel.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Class CSWWriter which writes data to csv file.
 * @author IMENTEC
 *
 */
public class CSVWriter {
	private String outputName = "";
	private Logger logger;
	
	/**
	 * Constructor.
	 * 
	 * @param outputName
	 */
	public CSVWriter (String outputName){
		this.outputName = outputName + ".csv";
		logger = Logger.getLogger("CSVWriter");
	}
	
	/**
	 * Method which saves the data to a file.
	 * 
	 * @param content
	 */
	public void save (String content){
        try
        {  
        	logger.info("Opening file for writting...");
        	BufferedWriter wt = new BufferedWriter(new FileWriter (new File (outputName)));
            
        	logger.info("Writting...");
            wt.write(content);
        
            logger.info("Data saved, now closing file...");
            wt.close();
            logger.info("DONE.");
        }catch(IOException e)
        {   
        	logger.error("Couldn't write to file");
        }
	}
}
