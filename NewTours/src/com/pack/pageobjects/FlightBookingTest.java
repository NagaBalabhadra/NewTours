package com.pack.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.main.TestSetup;
import com.pack.methods.BookAFlight;
import com.pack.methods.FindAFlight;
import com.pack.methods.HomePage;
import com.pack.methods.SelectAFlight;

public class FlightBookingTest extends TestSetup{
	
	private WebDriver driver;
	private HomePage home;
	private FindAFlight findflight;
	private SelectAFlight selectflight;
	private BookAFlight bookflight;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void verifyHomePage() {
		
		HomePage home = new HomePage(driver);
		System.out.println("URL opened successfully");
		Assert.assertTrue(home.verifyHomePageTitle(), "Home page title doesn't match");
	}
	@Test(priority=1)
	public void verifyLogInFunction() throws InterruptedException {
		
		home = new HomePage(driver);
		findflight = home.SignIn();
		System.out.println("Mercury Tours Login Successful!");
		Assert.assertTrue(findflight.verifyFindFlightPageTitle(), "Find Flight page title doesn't match");
		selectflight = findflight.flightSearch();
		System.out.println("Flight search Successful!");
		Assert.assertTrue(selectflight.verifySelectFlightPageTitle(), "Select Flight page title doesn't match");
		bookflight=selectflight.clickContinue();
		System.out.println("Flight selection complete");
		Assert.assertTrue(bookflight.verifyBookFlightPageTitle(), "Book Flight page title doesn't match");
		bookflight.bookFlight();
		System.out.println("Itinerary Booked");
		Assert.assertTrue(bookflight.verifyConfirmationPageTitle(), "Booking confirmation page title doesn't match");
		
	}
	
	
}