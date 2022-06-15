package com.nexsoft.cicool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginUser {

	protected WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void testLogin() {
		/*
		HomePage home = new HomePage(driver);
		SignInPage fromSignIn = home.clickSignIn();
		fromSignIn.logiValidUser("maslachahawwaliyah@gmail.com", "@Lilike1922");
		*/
		
		
		/*
		 * tanpa page factory
		 */
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage fromSignIn = home.clickSignIn();
		//fromSignIn.logiValidUser("maslachahawwaliyah@gmail.com", "like31");
		
		Dashboard dashboard = fromSignIn.loginValidUser("maslachahawwaliyah@gmail.com", "like31");
		dashboard.clickCrudBuilder();
		dashboard.clickCrudBuilder().clickSeeButtonWithTitle("Absensi");
		
		
		
		
		
	}
}
