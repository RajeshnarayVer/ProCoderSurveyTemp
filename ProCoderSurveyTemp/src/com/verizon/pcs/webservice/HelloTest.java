package com.verizon.pcs.webservice;



import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.SecurityContext;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.internal.MapPropertiesDelegate;
import org.glassfish.jersey.server.ContainerRequest;
import org.junit.After;
import org.junit.Before;


/**
 * The class <code>HelloTest</code> contains tests for the class <code>{@link Hello}</code>.
 *
 * @generatedBy CodePro at 8/28/15 2:23 AM
 * @author Administrator
 * @version $Revision: 1.0 $
 */
public class HelloTest {
	/**
	 * Run the void sayApplHello(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	
	
	@org.junit.Test
	public void testCustName_1()
		throws Exception {
		Hello fixture = new Hello();
		SiteSurveyClient ss = new SiteSurveyClient();
		//fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());
		String reqXml = "<createReq><name>Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
	 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>File1.jpg</filename>" + 
	 			"<filename>File2.jpg</filename><filename>File3.jpg</filename></attachlist></createReq>";
		String result = ss.callProCoderService(reqXml);
		assertEquals("Customer Name cannot be more than 100 characters", result);
		//fixture.sayApplHello(reqXml);
		//fixture.sayHtmlHello();

		// add additional test code here
	}

	
	/**
	 * Run the String sayHtmlHello() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	@org.junit.Test
	public void testFileName_3()
		throws Exception {
		Hello fixture = new Hello();
		SiteSurveyClient ss = new SiteSurveyClient();
		fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());		
		String reqXml = "<createReq><name>Cust1</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
	 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>File1.jpg</filename>" + 
	 			"<filename>File2.jpg</filename>"
	 			+ "<filename>FileFileust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1ust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1.jpg</filename>"
	 			+ "</attachlist></createReq>";
		String result = ss.callProCoderService(reqXml);
		assertEquals("Filename cannot be bigger than 200 characters", result);
	}

	

	@org.junit.Test
	public void testFileName_1()
		throws Exception {
		Hello fixture = new Hello();
		SiteSurveyClient ss = new SiteSurveyClient();
		fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());		
		String reqXml = "<createReq><name>Cust1</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
	 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>FileFileust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1ust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1.jpg</filename>" + 
	 			"<filename>File2.jpg</filename>"
	 			+ "<filename>File3.jpg</filename>"
	 			+ "</attachlist></createReq>";
		String result = ss.callProCoderService(reqXml);
		assertEquals("Filename cannot be bigger than 200 characters", result);
	}
	
	@org.junit.Test
	public void testFileName_2()
		throws Exception {
		Hello fixture = new Hello();
		SiteSurveyClient ss = new SiteSurveyClient();
		fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());		
		String reqXml = "<createReq><name>Cust1</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
	 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>File1.jpg</filename>" + 
	 			"<filename>FileFileust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1ust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1Cust1.jpg</filename>"
	 			+ "<filename>File3.jpg</filename>"
	 			+ "</attachlist></createReq>";
		String result = ss.callProCoderService(reqXml);
		assertEquals("Filename cannot be bigger than 200 characters", result);
	}

	/**
	 * Run the String sayPlainTextHello() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	@org.junit.Test
	public void testSayPlainTextHello_1()
		throws Exception {
		Hello fixture = new Hello();
		fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());

		//String result = fixture.sayPlainTextHello();

		// add additional test code here
		//assertEquals("Hello Jersey", result);
	}

	/**
	 * Run the String sayXMLHello() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	/*
	@org.junit.Test
	public void testSiteSurvey_1()
		throws Exception {
		Hello fixture = new Hello();
		SiteSurveyClient ss = new SiteSurveyClient();
		fixture.request = new ContainerRequest(URI.create(""), URI.create(""), "", (SecurityContext) null, new MapPropertiesDelegate());		
		String reqXml = "<createReq><name>SiteSurveyTest</name><address>New address</address><room>Room1</room><type>HICAPS</type>" + 
	 			"<by>Tom</by><date>2015-08-28</date><rem>test</rem><attachlist><filename>File1.jpg</filename>" + 
	 			"<filename>File2.jpg</filename>"
	 			+ "<filename>File3.jpg</filename>"
	 			+ "</attachlist></createReq>";
		String result = ss.callProCoderService(reqXml);		
		assertEquals("<?xml version=\"1.0\"?><hello> Hello Jersey</hello>", result);
	}

*/
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 8/28/15 2:23 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HelloTest.class);
	}
}