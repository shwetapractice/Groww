package com.utility;

import java.io.File;

import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GrowScreenshot {
	
	 public static String getscreenShot(WebDriver driver,String filename) throws IOException
		{
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"\\reports"+filename+".png";
			
			File des=new File(path);
			
			FileUtils.copyFile(src, des);
			
			return path;	
			
		}

	

}
