package task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import libs.Browser_Startup;
import webPage.HomePage;

public class Make_my_trip extends Browser_Startup{

	@Test
	public static void TicketBooking() throws Exception {
		HomePage Tic=PageFactory.initElements(driver, HomePage.class);
		Tic.bookTicket("Cuddapha", "Hyderabad", "DepartDate", "ReturnDate", "1");
		
		

	}

}
