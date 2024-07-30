package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;



import base.ExcelFileHandle;




public class WelcomeLoginPage  {
	
	public static Properties prop=null;
	public static String path=System.getProperty("user.dir");
	public WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//*[text()='Login/Register']")private WebElement login;
	@FindBy(id="login_email1")private WebElement email;
    @FindBy(xpath="//*[text()='Continue']") private  WebElement button;
	@FindBy(id="login_password1")private WebElement password;
	@FindBy(xpath="//span[text()='Submit']")private WebElement submit;
	@FindBy(xpath="(//*[@class='otpinput88 headingLarge backgroundPrimary otpinput88confidential'])[1]")
	private WebElement otp;
	@FindBy(xpath="(//input[@id='globalSearch23'])[1]")private WebElement search;
	@FindBy(xpath="(//*[@class='aboutCompany_tdValue__Ioaru right-align bodyLargeHeavy'])[1]")
	private WebElement orgparent;
	@FindBy(xpath="(//*[@class='aboutCompany_tdValue__Ioaru right-align bodyLargeHeavy'])[2]")
	private WebElement mandir;
	@FindBy(xpath="(//*[@class='ft785Value right-align contentPrimary bodyLargeHeavy'])[1]")
	private WebElement marketcap;
	@FindBy(xpath="//*[@class='lpu38Pri valign-wrapper false displayBase']")private WebElement price;
	@FindBy(xpath="//*[@class='lpu38Head truncate displaySmall']") private WebElement sharename;
	
	public WelcomeLoginPage()
	{
		System.out.println("Properties files test data"+path);
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(path+"/src/main/java/testdata/credentials.properties");
			prop.load(fis);
			} 
		catch (IOException e) 
		    {
				
			}
	}
	
	public WelcomeLoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		
	}
	
	public void entercredentials() throws InterruptedException
	{
		login.click();
		email.sendKeys(prop.getProperty("email"));
		button.click();
		password.sendKeys(prop.getProperty("pwd"));
		submit.click();
		Thread.sleep(30000);
		otp.sendKeys("4562");
	}
	
	public void searchShare() throws InterruptedException
	{
		Thread.sleep(3000);
		search.sendKeys("Tata motors");
		Thread.sleep(1000);
	    search.sendKeys(Keys.RETURN);
	}
	
	public void readDatafromFile() throws IOException, InterruptedException
	{
        FileInputStream fis=new FileInputStream(".\\Data\\Growwdetails.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		int rowcount=sh.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row=sh.getRow(i);
			
			String stockname=row.getCell(0).getStringCellValue();
			
			//String marketcapital=row.getCell(1).getStringCellValue();
			
			String parentorg=row.getCell(2).getStringCellValue();
			
			String mandirector=row.getCell(3).getStringCellValue();
			
			
			
			search.clear();
			search.sendKeys(stockname);
			Thread.sleep(1000);
		    search.sendKeys(Keys.RETURN);
		    
		    String parent=orgparent.getText();
			//String capital=marketcap.getText();
			String Managingdir=mandir.getText();
		    
		    SoftAssert soft=new SoftAssert();
		    
		    soft.assertEquals(parent, parentorg,"Parent Oraganization of "+stockname);
		    
		 //   soft.assertEquals(capital, marketcapital,"Market capital of "+stockname);
		    
		    soft.assertEquals(Managingdir, mandirector, "Managing Director of "+stockname);
		    
		    soft.assertAll();
		    
		}	
	}
	
	public void writeDataInSheet() throws IOException, InterruptedException
	{
		search.clear();
		search.sendKeys("Rail Vikas");
		Thread.sleep(1000);
	    search.sendKeys(Keys.RETURN);
	    
		//ExcelFileHandle.writeDataInExcel(0, 0,0, "Stock Name");
		ExcelFileHandle.writeDataInExcel(1,0,0, sharename.getText());
	}
	
	public void writePrice() throws IOException
	{
		//ExcelFileHandle.writeDataInExcel(0, 1,1, "Price of Stock");
		ExcelFileHandle.writeDataInExcel(1,0,1, price.getText());
	}
	
	
}
  