package base;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.WelcomeLoginPage;

public class FrameWorkBase {
	
	public static WebDriver driver; 
	protected WelcomeLoginPage page;

	
	/*public FrameWorkBase()
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
     }*/
	@BeforeSuite
	public void browserLaunchByGrow()
	{
		
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--incognito");
		driver=new ChromeDriver(opt);
		//ChromeDriverManager.getInstance().setup();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://groww.in/");
		
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void createObject()
	{
		page=new WelcomeLoginPage();
		page=new WelcomeLoginPage(driver);
	}

	@AfterSuite
	public void closeBrowser() {
		System.out.println("closeBrowser");
     	//driver.close();
	}
	
}
              