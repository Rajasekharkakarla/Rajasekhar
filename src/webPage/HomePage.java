package webPage;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage {
	
	public WebDriver driver;
	

	public HomePage(WebDriver driver){
		this.driver=driver;
	}
		@FindBy(id="hp-widget__sfrom")WebElement From;
		@FindBy(id="hp-widget__sTo")WebElement To;
		@FindBy(id="hp-widget__depart")WebElement Depart;
		@FindBy(id="hp-widget__return")WebElement ReturnDate;
		@FindBy(xpath="//div[@class='dateFilter hasDatepicker']") WebElement DepartCalendar;
		@FindBy(xpath="//div[@class='dateFilterReturn hasDatepicker']") WebElement ReturnCalendar;
		@FindBy(id="hp-widget__paxCounter_pot")WebElement PassengerCount;
		@FindBy(id="searchBtn")WebElement Search;
		@FindBy(xpath="//div[@class='ch__moreTabProfile header-dropdown']/ul/li") List<WebElement> ele;
		@FindBy(id="ch_login_email")WebElement Email;
		@FindBy(id="ch_login_password")WebElement Password;
		@FindBy(id="ch_login_btn")WebElement  Submit;
		@FindBy(xpath="//div[@class='ch_socialMedia ch_loginSocialMedia']/a[1]")WebElement LoginWithFb;
		@FindBy(linkText="LOG-IN WITH GOOGLE")WebElement LoginWithGoogle;
		
		@FindBy(xpath="//*[@id=\"ch_login_icon\"]/span[2]") WebElement login;
		public void login(String Validation) {
			switch(Validation) {
			case"Field Verification":
				login.click();
				if(Email.isDisplayed() & Password.isDisplayed()&Submit.isDisplayed()) {
					assertTrue(true);
				}else {
					assertTrue(false);
				}
			}
			
		}
		
		public void bookTicket(String src,String Dest,String DepartDate,String ReturnDate,String PassengerCount) throws Exception{
			From.clear();
		    From.sendKeys(src);
		    To.clear();
		    To.sendKeys(Dest);
		    Depart.click();
		    List<WebElement> departDate=DepartCalendar.findElements(By.xpath("//div[@class='dateFilter hasDatepicker']/div[1]/div[1]/table/tbody//td"));
		    Thread.sleep(2000);
		    for(WebElement values:departDate){
		    	if(values.getText().contains("28")){
		    		System.out.println(values);
		    		values.click();
		    		break;
		    	}
		    }
		    
		    Actions act=new Actions(driver);
		    act.moveToElement(driver.findElement(By.id("ch_funnel_more"))).build().perform();
		    for(int i=0;i<ele.size();i++) {
		    	
		    System.out.println(ele.get(i).getText());
		    }
		    
				
					
					
			}
		}