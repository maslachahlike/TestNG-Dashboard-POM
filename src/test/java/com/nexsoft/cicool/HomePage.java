package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
	/*
	private By signIn = By.xpath("//a[@class='page-scroll']");
	private By languageSetting = By.xpath("//a[@class='dropdown-toggle']");
	*/
	
	/*
	 * tanpa page factory
	 */
	
	@FindBy(xpath = "//a[@class='page-scroll']")
	private WebElement signIn;
	

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement btnLogout;
	
	
	@FindBy(xpath = "//a[@class='page-scroll dropdown-toggle']")
	private WebElement btnDashboardUsername;
	
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement btnLogin;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public SignInPage clickSignIn() {
		//driver.findElement(signIn).click();
		
		/*
		 * tanpa page factory
		 */
		
		signIn.click();
		
		SignInPage signInPage =  PageFactory.initElements(driver, SignInPage.class);
		
		return signInPage;
		
	}
	
	
	public void logout() {
		
		btnDashboardUsername.click();
		btnLogout.click();
	
	}


}