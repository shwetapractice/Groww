package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.FrameWorkBase;


public class WelcomePageTestCase extends FrameWorkBase{
	

	
	@Test(priority=0)
	public void loginTestCase() throws InterruptedException
	{
		page.entercredentials();	
	}

	@Test(priority=1)
	public void homePageTest() throws InterruptedException
	{
		page.searchShare();
	}
	
	@Test (priority=2)
	public void readDatafromFile() throws IOException, InterruptedException
	{
		page.readDatafromFile();
		//compareDataFromExcel();
	}
	
	@Test (priority=3)
	public void writeData() throws IOException, InterruptedException
	{
		page.writeDataInSheet();
		page.writePrice();
	}
	
	
   
}
   