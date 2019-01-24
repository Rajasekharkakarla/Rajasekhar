package task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import libs.Browser_Startup;
import webPage.HomePage;

public class Login extends Browser_Startup {
	@Test
	public  void login() {
		
		HomePage Tic=PageFactory.initElements(driver, HomePage.class);
		Tic.login("Validation");
		
	
	}

}
