package com.pojo;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class JSONConverter {
	ObjectMapper object_map;

	public JSONConverter() {
		object_map = new ObjectMapper();
	}

	public void createJSON(ArrayList<CustomerDetails> all_customerDetails)
			throws StreamWriteException, DatabindException, IOException {

		for (int i = 0; i < all_customerDetails.size(); i++) {
			object_map.writerWithDefaultPrettyPrinter().writeValue(new File(
					"/Users/ayyappa/eclipse-workspace/RoadMapToSDET_Udemy/src/main/resources/CustomerDetail_Customre-"
							+ i + ".JSON"),
					all_customerDetails.get(i));

		}

	}

	public void createOneJSON(ArrayList<CustomerDetails> all_customerDetails) throws StreamWriteException, DatabindException, IOException {
		JSONObject jsonobj = new JSONObject();
		
		
		/*
		 * JsonArray arr = new JsonArray(); Gson gson = new Gson();
		 * 
		 * for (int i = 0; i < all_customerDetails.size(); i++) { String jsonString =
		 * gson.toJson(all_customerDetails.get(i)); arr.add(jsonString); }
		 */
		
		
		jsonobj.put("data", all_customerDetails);
		
		/*
		 * String unescaped = StringEscapeUtils.unescapeJson(jsonobj.toString()); String
		 * formatted = unescaped.replace("\"{", "{"); String last =
		 * formatted.replace("}\"", "}"); System.out.println(last);
		 * 
		 * FileWriter file = new FileWriter(
		 * "/Users/ayyappa/eclipse-workspace/RoadMapToSDET_Udemy/src/main/resources/All-CustomerDetail_Customers.JSON"
		 * ); file.write(last); file.close();
		 */
		
		object_map.writeValue(new File(
				"/Users/ayyappa/eclipse-workspace/RoadMapToSDET_Udemy/src/main/resources/All_CustomerDetail.JSON"),
				jsonobj);
	}
	
	
	public void getCustomerDetails(String fileName) throws IOException
	{
		CustomerDetails details = object_map.readValue(new File(fileName), CustomerDetails.class);
		
		System.out.println(details.getCourseName());
	}

}
