package com.pack.methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	protected WebDriver driver;
	private By usernameTextBox = By.name("userName");
	private By passwordTextBox = By.name("password");
	private By submitBtn = By.name("login");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	/* Will signIn with UserName,Password and Clicks continue*/
	public FindAFlight SignIn() throws InterruptedException {
		enterUserName("mercury");
		enterPassword("mercury");
		clickOnSignIn();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return new FindAFlight(driver);
	}

	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	/*Verifies Home Page Title using Selenium Information command i.e getTitle() */
	public boolean verifyHomePageTitle() {
		System.out.println("Page1Tiltle-----"+getPageTitle());
		String expectedPageTitle="Welcome: Mercury Tours";
		return getPageTitle().contains(expectedPageTitle);
	}
	
	/*Validates the nameTxtBox using Selenium Validation command i.e isDisplayed() 
     and sends username using Selenium Interactive command i.e sendkeys() */
	
	public void enterUserName(String username) {
		WebElement nameTxtBox = driver.findElement(usernameTextBox);
		if(nameTxtBox.isDisplayed())
			nameTxtBox.sendKeys(username);
	}
	/*Validates the passwordTxtBox using Selenium Validation command i.e isDisplayed() 
    and sends password using Selenium Interactive command i.e sendkeys() */
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordTextBox);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	/*Validates the signInBtn using Selenium Validation command i.e isDisplayed() 
    and clicks continue using Selenium Interactive command i.e click() */
	
	public void clickOnSignIn() {
		WebElement signInBtn = driver.findElement(submitBtn);
		if(signInBtn.isDisplayed())
			signInBtn.click();
		
	}
	
}