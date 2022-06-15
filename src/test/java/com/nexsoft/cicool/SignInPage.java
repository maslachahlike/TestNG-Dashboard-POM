package com.nexsoft.cicool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	//2
	protected WebDriver driver;
	
	/*tanpa page factory
	private By email = By.xpath("//input[@placeholder='Email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By btnSignIn = By.xpath("//button[@type='submit']");
	*/
	
	//kalau tanpa page factory
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;
	
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignIn;
	
	
	@FindBy(xpath = "//p[normalize-space()='E-mail Address and Password do not match.']")
	private WebElement errorPassword;
	

	@FindBy(xpath = "//p[normalize-space()='User does not exist']")
	private WebElement errorUsername;
	
	
	@FindBy(xpath = "//p[normalize-space()='The Username field is required.']")
	private WebElement errorEmptyUsernameAndPassword;
	
	
	@FindBy(xpath = "//a[normalize-space()='I forgot my password.']")
	private WebElement forgotPassword;
	
	
	public SignInPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public Dashboard loginValidUser(String username, String user_password) {
		/*
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(user_password);
		driver.findElement(btnSignIn).click();
		*/
		
		//tanpa page factory
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();
		
		return PageFactory.initElements(driver, Dashboard.class);
		
	}
	
	
	public String getErrorPassword() {
		return errorPassword.getText();
		
	}
	
	
	public String getErrorUsername() {
		return errorUsername.getText();
	
	}
	
	
	public String geterrorEmptyUsernameAndPassword() {
		return errorEmptyUsernameAndPassword.getText();
	
	}
	
	
	public ForgotPasswordPage clickForgotPassword() {
		forgotPassword.click();
		ForgotPasswordPage forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
		return forgotPasswordPage;
	}
	
	
}
