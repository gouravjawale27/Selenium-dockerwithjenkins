package testclass;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.ProductPage;
import utility.ConfigReader;

public class BaseTest {
	
	public static WebDriver driver ;
	public HomePage homepage;
	
	public ProductPage productpage;

	@Parameters("browser")
	@BeforeTest
	public void initBrowser(String bname) throws IOException
	{
		 String host = "localhost";
		    MutableCapabilities dc;
		 
		    if(System.getProperty("BROWSER") != null &&
		            System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
		      System.out.println("Firefox is satisfied");
		    	dc = new FirefoxOptions();
		    }
		    else if (bname.equals("chrome")) {
		    	System.out.println("Chrome else if is satisfied");
		    	 dc = new ChromeOptions();
			}
		    else{
		    	System.out.println("Chrome else is satisfied");
		        dc = new ChromeOptions();
		    }
		 
		    if(System.getProperty("HUB_HOST") != null){
		        host = System.getProperty("HUB_HOST");
		    }
		 
//		    String testName = ctx.getCurrentXmlTest().getName();
		 
		    String completeUrl = "http://" + host + ":4444/wd/hub";
//		    dc.setCapability("name", testName);
		    driver = new RemoteWebDriver(new URL(completeUrl), dc);
		
		
		driver.manage().window().maximize();
		
		
		
		
		
		
		
		ConfigReader cr = new ConfigReader();
//		String browsername = cr.readConfig("browser");
//		if(browsername.equals("Chrome"))
//		{
//		driver = new ChromeDriver();
//		}
//		else if(browsername.equals("Firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//			
//		driver.manage().window().maximize();
		
		
		
		String url = cr.readConfigFile("testsiteurl");
		
		driver.get(url);
		
	}
	
	@BeforeClass
	public void createObject()
	{
		 homepage = new HomePage(driver);
		 productpage = new ProductPage(driver);
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
