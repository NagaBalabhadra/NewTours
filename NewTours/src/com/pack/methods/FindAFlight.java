package com.pack.methods;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindAFlight {
	private WebDriver driver;
	private By oneWayBtn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]");
	private By roundTripBtn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]");
	private By arrivingDropdown = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select");
	private By departureDropdown = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select");
	private By economyClass = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input");
	private By businessClass = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]");
	private By firstClass = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]");
	private By continueBtn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input");
	
	public FindAFlight(WebDriver driver) {
		this.driver=driver;
	}
	public String getFindFlightPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	/*Verifies Find a Flight Page Title using Selenium Information command i.e getTitle() */
	public boolean verifyFindFlightPageTitle() {
		System.out.println("Page2Tiltle-----"+getFindFlightPageTitle());
		String expectedTitle = "Find a Flight: Mercury Tours:";
		return getFindFlightPageTitle().contains(expectedTitle);
	}
	/* Will Select One Way radio button, depart from Sydney, arrival in London, First Class and Clicks continue*/
	public SelectAFlight flightSearch() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		clickOneWayOption();
		Thread.sleep(1000);
		departure() ;
		Thread.sleep(1000);
		arrival();
		Thread.sleep(1000);
		selectClass();
		Thread.sleep(1000);
		clickContinue();
		Thread.sleep(1000);
		return new SelectAFlight(driver) ;
	}
	public void clickOneWayOption() {
		WebElement twoway = driver.findElement(roundTripBtn);
		WebElement oneway = driver.findElement(oneWayBtn);
		
		if(twoway.isEnabled())
			oneway.click();
		
	}
	
	
	public void departure() {
		WebElement departingIn = driver.findElement(departureDropdown);
		new Select(departingIn).selectByValue("Sydney");
	}
	public void arrival() {
		WebElement arrivingIn = driver.findElement(arrivingDropdown);
		new Select(arrivingIn).selectByValue("London");
	}
	public void selectClass() {
		WebElement economy = driver.findElement(economyClass);
		WebElement business = driver.findElement(businessClass);
		WebElement first = driver.findElement(firstClass);
		if(economy.isEnabled())
			first.click();
		else if (business.isEnabled())
			first.click();
		else
			System.out.println("First class is selected");
	}
	public void clickContinue() {
		WebElement continuebutton = driver.findElement(continueBtn);
		
		if(continuebutton.isDisplayed())
			continuebutton.click();
	}
	
}
