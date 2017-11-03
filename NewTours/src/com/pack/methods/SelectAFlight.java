package com.pack.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectAFlight {
	private WebDriver driver;
	private By continueBtn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input");
	public SelectAFlight(WebDriver driver) {
		this.driver=driver;
	}
	public String selectAflightPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	/*Verifies Select a Flight Page Title using Selenium Information command i.e getTitle() */
	public boolean verifySelectFlightPageTitle() {
		System.out.println("Page3Tiltle-----"+selectAflightPageTitle());
		String expectedTitle = "Select a Flight: Mercury Tours";
		return selectAflightPageTitle().contains(expectedTitle);
	}
	/*Clicks Continue*/
	public BookAFlight clickContinue() {
		WebElement continuebutton = driver.findElement(continueBtn);
		
		if(continuebutton.isDisplayed())
			continuebutton.click();
		return new BookAFlight(driver) ;
	}
	

}
