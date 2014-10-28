package com.linage.mapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * 
 * @author Edwin Permana
 * class Map read property file from config returned as HashMap
 */
public class MappingReader {

	private static String configFile = "highjump_t_tran_log_mapping.properties";
	private LinkedHashMap<String,String> mapping = new LinkedHashMap<String, String>();
	public static void main(String[] args) {
		//Test read file
		MappingReader mapreader= new MappingReader();
		mapreader.readPropertyFile(configFile);
		
	}
	
/**
 * Pre:: Initialize read property files from configFile 
 * POST: return new HashMap filled with property files;
 */
	public LinkedHashMap<String,String> readPropertyFile(String configFile) {
		// System.out.println("In readPropertyFile method");
		
		 InputStream input;
		
		 try {
			
			 input = MappingReader.class.getClassLoader().getResourceAsStream(configFile);
				 
			 BufferedReader br = new BufferedReader(new InputStreamReader(input));
			 
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					String[] parts = line.split("=");
					 mapping.put(parts[0], parts[1]);
				}
			 
				br.close();
			 
		
		 
		 //System.out.println("HashMap generated::" + mapping);
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return  mapping;
		 }
	
	
	
}
