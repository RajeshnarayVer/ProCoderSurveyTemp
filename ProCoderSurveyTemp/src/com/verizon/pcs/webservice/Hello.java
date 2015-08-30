package com.verizon.pcs.webservice;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import java.io.File; 
import java.io.StringReader; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.util.Calendar; 

 
import org.w3c.dom.*; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder; 

 
import org.xml.sax.InputSource; 
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException; 


// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {
	
	@Context
	  Request request;
	
	// This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }

	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public String sayXMLHello() {		  
		//if(request != null) 		  
		//{
			try { 
				String reqXml = "<createReq><name>NewOne</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
				 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>File1.jpg</filename>" + 
				 			"<filename>File2.jpg</filename><filename>File3.jpg</filename></attachlist></createReq>"; 

				
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
				 				  if(k==0) pro.setFilename1(filenames.getFirstChild().getNodeValue()); 
				 				  if(k==1) pro.setFilename2(filenames.getFirstChild().getNodeValue()); 
				 				  if(k==2) pro.setFilename3(filenames.getFirstChild().getNodeValue()); 
				 			  } 
						  } 
				 	      } 
				 	  } 
				 	   
				 	  String myDriver = "org.gjt.mm.mysql.Driver"; 
				       String myUrl = "jdbc:mysql://113.128.161.204/mydb"; 
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
	//}
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHtmlHello() {
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	    		  + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	  }

	} 

