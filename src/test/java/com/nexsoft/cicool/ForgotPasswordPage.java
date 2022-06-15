package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

	protected WebDriver driver;
	
	
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement forgotPassword;
	
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public String getForgotPasswordValue() {
		String text = forgotPassword.getText();
		return text;
	
	}
	
	
}
