package com.verizon.pcs.webservice;

import static org.junit.Assert.*;
import org.junit.Test;
import com.verizon.pcs.webservice.ProBean;
import com.verizon.pcs.webservice.Hello;


public class SiteSurveyTest {

	Hello ss = new Hello();
	ProBean pb = new ProBean();
	
	@Test
	public void checkfilename1()
	{
		assertNotNull(pb.getFilename1());
	}
	
	@Test
	public void checkfilename2()
	{
		assertNotNull(pb.getFilename2());
	}
	
	@Test
	public void checkfilename3()
	{
		assertNotNull(pb.getFilename3());
	}
	
	@Test
	public void checklength1()
	{
		assertFalse("Length greater than 300", (pb.getFilename1().length()>300));
	}
	
	@Test
	public void checklength2()
	{
		assertFalse("Length greater than 300", (pb.getFilename2().length()>300));
	}
	
	@Test
	public void checklength3()
	{
		assertFalse("Length greater than 300", (pb.getFilename3().length()>300));
	}
	
	@Test
	public void checkcustlength()
	{
		assertFalse("Length greater than 100", (pb.getName().length()>100));
	}
	
	@Test
	public void checkBylength()
	{
		assertFalse("Length greater than 100", (pb.getBy().length()>100));
	}
	
	@Test
	public void checkTypelength()
	{
		assertFalse("Length greater than 100", (pb.getType().length()>100));
	}
	
	@Test
	public void checkRoomlength()
	{
		assertFalse("Length greater than 100", (pb.getRoom().length()>100));
	}
	
}
