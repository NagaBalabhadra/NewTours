package com.pack.methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookAFlight {
	
	private WebDriver driver;
	private By firstName = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input");
	private By lastName = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input");
	private By creditcardNumber = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td/table/tbody/tr[2]/td[2]/input");
	private By tickectlessoption= By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input");
	private By selectpurchase= By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input");
	
	public BookAFlight(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getBookFlightPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	/*Verifies Book a Flight Page Title using Selenium Information command i.e getTitle() */
	public boolean verifyBookFlightPageTitle() {
		System.out.println("Page4Tiltle-----"+getBookFlightPageTitle());
		String expectedTitle = "Book a Flight: Mercury Tours";
		return getBookFlightPageTitle().contains(expectedTitle);
	}
	/* Will enter FirstName, LastName, CreditCardNumber, Enables Ticketless Travel  and clicks Secure Purchase button*/
	public void bookFlight() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		enterFirstName("Naga");
		Thread.sleep(1000);
		enterLastName("Balabhadra");
		Thread.sleep(1000);
		enterCreditCardNumber("22222");
		Thread.sleep(1000);
		selectTicketless();
		Thread.sleep(1000);
		clickBook();
		Thread.sleep(1000);
		
	}
	
	public void enterFirstName(String fName) {
		WebElement emailTxtBox = driver.findElement(firstName);
		if(emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		WebElement passwordTxtBox = driver.findElement(lastName);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(lName);
	}
	public void enterCreditCardNumber(String ccNumber) {
		WebElement creditCardNo = driver.findElement(creditcardNumber);
		
		if(creditCardNo.isDisplayed())
			creditCardNo.sendKeys(ccNumber);
	}
	public void selectTicketless() {
		WebElement ticketless = driver.findElement(tickectlessoption);
		
		
		ticketless.click();
	}
	public void clickBook() {
		WebElement book = driver.findElement(selectpurchase);
		
		if(book.isDisplayed())
			book.click();
	}
	
	public String getConfirmationPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifyConfirmationPageTitle() {
		System.out.println("Page5Tiltle-----"+getConfirmationPageTitle());
		String expectedTitle = "Flight Confirmation: Mercury Tours";
		return getBookFlightPageTitle().contains(expectedTitle);
	}
}
