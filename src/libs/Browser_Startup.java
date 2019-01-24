package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Browser_Startup extends Property_Config {

	public static WebDriver driver;
	public static Property_Config config=new Property_Config();
	@BeforeClass
	@Parameters({"browserName"})
	public static void loadBrowser(String browserName){
	  config.LoadConfiguration();
		if(browserName.equals("chrome")){
			//Using WebdriverManager to setup the Chrome instead of setProperty
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			
		}else if(browserName.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(config.property.getProperty("URL"));
	}
	
	@AfterMethod()
	public static void fail(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus()){
			Reuse_Fun.screenShot(driver, "task1");
		driver.quit();
		}
		
	}
}