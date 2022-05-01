package com.business.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.pojo.CustomerDetails;
import com.pojo.JSONConverter;

public class JDBCConnector {
public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = null;
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","ayya");
	//Create an object of statement class which will help to execute the query
	Statement statement = connection.createStatement();
	
	ResultSet resultSet = statement.executeQuery("\n" + "select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
	
	//resultSet.next(); //setting the pointer to first row
	
	
	ArrayList<CustomerDetails> all_customerDetails = new ArrayList<CustomerDetails>();
	
	while(resultSet.next())
	{
		CustomerDetails customer_details = new CustomerDetails();
		customer_details.setCourseName(resultSet.getString(1));
		customer_details.setPurchasedDate(resultSet.getString(2));
		customer_details.setAmount(resultSet.getInt(3));
		customer_details.setLocation(resultSet.getString(4));
		all_customerDetails.add(customer_details);
	}
	connection.close();
	
	
	JSONConverter json_converter = new JSONConverter();
	json_converter.createOneJSON(all_customerDetails);
	json_converter.getCustomerDetails("/Users/ayyappa/eclipse-workspace/RoadMapToSDET_Udemy/src/main/resources/CustomerDetail_Customre-0.JSON");
}
}
