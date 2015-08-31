package com.verizon.pcs.webservice;

import java.io.StringReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.glassfish.jersey.client.ClientConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SiteSurveyClient {
	
	public static void main(String[] args) {
		  
		SiteSurveyClient test = new SiteSurveyClient();
		  test.callProCoderService("test");
		  
		  }

	  public String callProCoderService(String reqXml)
	  {
	  ClientConfig config = new ClientConfig();

	    Client client = ClientBuilder.newClient(config);

	    WebTarget target = client.target(getBaseURI());

	   /* String response = target.path("rest").
	              path("hello").
	              request().
	              accept(MediaType.TEXT_PLAIN).
	              get(Response.class)
	              .toString();*/
	       
	    
	    try { 
					
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
			InputSource is=new InputSource(new StringReader(reqXml)); 
			Document dom=builder.parse(is); 
			
			 
			NodeList nodeList=dom.getElementsByTagName("createReq"); 
			System.out.println(nodeList.getLength()); 
			
			 ProBean pro = new ProBean(); 
				   
				  for (int i=0; i < nodeList.getLength(); ++i) { 
			 		  Node node=nodeList.item(i); 
			 		  NodeList children=node.getChildNodes(); 
			 		  System.out.println(children.getLength()); 
			 	      for (int j=0; j < children.getLength(); ++j) { 
			 		  Node child=children.item(j); 
			 		  if (child.getNodeName().equals("name")){ 
			 				  System.out.println(child.getFirstChild().getNodeValue()); 
			 				  if(child.getFirstChild().getNodeValue() != null && child.getFirstChild().getNodeValue().length()>100)
			 				  {
			 					  System.out.println("Customer Name cannot be more than 100 characters");
			 					  return "Customer Name cannot be more than 100 characters";
			 				  }
			 				  else
			 					  pro.setName(child.getFirstChild().getNodeValue()); 
				  } 
			 		  else if(child.getNodeName().equals("address")) 
			 		  { 
			 			  System.out.println(child.getFirstChild().getNodeValue()); 
			 			  pro.setAddress(child.getFirstChild().getNodeValue()); 
			 		  } 
			 		  else if(child.getNodeName().equals("room")) 
			 				  { 
			 					  System.out.println(child.getFirstChild().getNodeValue()); 
			 					  pro.setAddress(child.getFirstChild().getNodeValue()); 
			 				  }	   
			 		  else if(child.getNodeName().equals("type")) 
			 		  { 
			 			  System.out.println(child.getFirstChild().getNodeValue()); 
			 			  pro.setType(child.getFirstChild().getNodeValue()); 
			 		  } 
			 		  else if(child.getNodeName().equals("by")) 
			 		  { 
			 			  System.out.println(child.getFirstChild().getNodeValue()); 
						  pro.setBy(child.getFirstChild().getNodeValue()); 
					  } 
			 		  else if(child.getNodeName().equals("rem")) 
			 		  { 
			 			  System.out.println(child.getFirstChild().getNodeValue()); 
			 			  pro.setRem(child.getFirstChild().getNodeValue()); 
			 		  } 
			 		  else if(child.getNodeName().equals("attachlist")) 
			 		  { 
			 			  NodeList files=child.getChildNodes(); 
			 			  System.out.println(files.getLength()); 
			 			  for (int k=0; k < files.getLength(); ++k) { 
							  Node filenames=files.item(k); 
			 				  System.out.println(filenames.getFirstChild().getNodeValue()); 
			 				  if(filenames.getFirstChild().getNodeValue()!=null && filenames.getFirstChild().getNodeValue().length()>200)
			 				  {
			 					  System.out.println("Filename cannot be bigger than 200 characters");
			 					  return "Filename cannot be bigger than 200 characters";
			 				  }
			 				  if(k==0) pro.setFilename1(filenames.getFirstChild().getNodeValue()); 
			 				  if(k==1) pro.setFilename2(filenames.getFirstChild().getNodeValue()); 
			 				  if(k==2) pro.setFilename3(filenames.getFirstChild().getNodeValue()); 
			 			  } 
					  } 
			 	      } 
			 	  } 
			 	   
			 	  String myDriver = "org.gjt.mm.mysql.Driver"; 
			       String myUrl = "jdbc:mysql://localhost/mydb"; 
			       Class.forName(myDriver); 
			       Connection conn = DriverManager.getConnection(myUrl, "root", "mysql"); 
			 
			 System.out.println("Db connected");
			       Calendar calendar = Calendar.getInstance(); 
			       java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime()); 
			 
			 
			       String query = " insert into sitesurvey "
			       		+ "(customer,siteaddress, room, surveytype, surveydate, surveyedby, attachment1, "
			       		+ "attachment2, attachment3, remarks)"
			           + " values (?, ?, ?, ?, ?, ? , ?, ?, ?, ?)"; 
			           
			       // create the mysql insert preparedstatement 
			       PreparedStatement preparedStmt = conn.prepareStatement(query); 
			       preparedStmt.setString (1, pro.getName()); 
			       preparedStmt.setString (2, pro.getAddress()); 
			       preparedStmt.setString (3, pro.getRoom()); 
			       preparedStmt.setString (4, pro.getType()); 				       
			       preparedStmt.setDate(5, startDate); 
			       preparedStmt.setString (6, pro.getBy()); 
			       preparedStmt.setString (7, pro.getFilename1()); 
			       preparedStmt.setString (8, pro.getFilename2()); 
			       preparedStmt.setString (9, pro.getFilename3()); 
			       preparedStmt.setString (10, pro.getRemarks());
			       			       
			   
			       // execute the preparedstatement 
			       preparedStmt.execute(); 
			         System.out.println(pro.getName() + "Inserted successfully");
			      conn.close(); 
			 
			 	} 
			 	catch(Exception e) 
			 	{ 
			 		e.printStackTrace(); 
			 	} 
	    
	    

	    //String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
	    String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
	    //String htmlAnswer= target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
	    //System.out.println(response);
	    //System.out.println(plainAnswer);
	    System.out.println(xmlAnswer);
	    //System.out.println(htmlAnswer);
	    return xmlAnswer;
	    
	  }
	  
		  private URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first").build();
		  }

}
