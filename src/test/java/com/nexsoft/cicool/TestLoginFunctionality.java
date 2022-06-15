package com.nexsoft.cicool;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginFunctionality {

	protected WebDriver driver;
	public void sleep(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public String screenshoot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //fungsi dari selenium getScreenshotAs, kalau diambil dia akan memanggil file screenshoot an, file yang disimpen dari memory
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\TestScreenshoot\\" + waktu + ".png";
		File screenshoot = new File(namaFile);
		
		try {
			FileUtils.copyFile(srcFile, screenshoot); //file kosong
		} catch (Exception e) {
			e.printStackTrace();
		}
		return namaFile; //return nilainya 
	
	}
	
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
		//HomePage home = PageFactory.initElements(driver, HomePage.class);
	
	}
	
	/*
	 * tugas day 20 TestNG
	 */
	
	@Test(priority = 1)
	public void testLogin_With_ValidUser_And_Pasword() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = home.clickSignIn().loginValidUser("maslachahawwaliyah@gmail.com", "like31");
		
		/*
		 * screenshot
		 */
		sleep(500);
		String file = "<img src = 'file://"+screenshoot()+"'height=\"350\" width=\"700\"/>"; 
		Reporter.log(file);
		
		Assert.assertEquals(dash.getUsername(), "Maslachahawwaliyah");
		driver.get(System.getProperty("url"));
	}
	
	
	@Test(priority = 2)
	public void testLogin_With_ValidUser_And_WrongPasword() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.logout();
		SignInPage signIn = home.clickSignIn();	
		
		/*
		 * screenshot
		 */
		sleep(500);
		String file = "<img src = 'file://"+screenshoot()+"'height=\"350\" width=\"700\"/>"; 
		Reporter.log(file);
		
		Dashboard dashboard = signIn.loginValidUser("maslachahawwaliyah@gmail.com", "like");
		Assert.assertEquals(signIn.getErrorPassword(), "E-mail Address and Password do not match.");	
		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true," Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}
	
	
	@Test(priority = 3)
	public void testLoginWith_WrongUser_And_ValidPasword() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signIn = home.clickSignIn();
		
		/*
		 * screenshot
		 */
		sleep(500);
		String file = "<img src = 'file://"+screenshoot()+"'height=\"350\" width=\"700\"/>"; 
		Reporter.log(file);
		
		Dashboard dashboard = signIn.loginValidUser("maslachahlike@gmail.com", "like31");
		Assert.assertEquals(signIn.getErrorUsername(), "User does not exist");
		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true," Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}
	
	
	@Test(priority = 4)
	public void testLoginWith_EmptyUser_And_EmptyPasword() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signIn = home.clickSignIn();
		
		/*
		 * screenshot
		 */
		sleep(500);
		String file = "<img src = 'file://"+screenshoot()+"'height=\"350\" width=\"700\"/>"; 
		Reporter.log(file);
		
		Dashboard dashboard = signIn.loginValidUser("", "");
		Assert.assertEquals(signIn.geterrorEmptyUsernameAndPassword(), "The Username field is required.");
		try {
			dashboard.getUsername();
		} catch (Exception e) {
			assertTrue(true," Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}
	
	
	@Test(priority = 5)
	public void testForgotPassword() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signIn = home.clickSignIn();
		ForgotPasswordPage forgotPass = signIn.clickForgotPassword();
		
		/*
		 * screenshot
		 */
		sleep(500);
		String file = "<img src = 'file://"+screenshoot()+"'height=\"350\" width=\"700\"/>"; 
		Reporter.log(file);
		
		//Dashboard dashboard = signIn.loginValidUser("", "");
		
		
		Assert.assertEquals(forgotPass.getForgotPasswordValue(), "Send a link to reset the password");
		try {
			forgotPass.getForgotPasswordValue();
		} catch (Exception e) {
			assertTrue(true," Text Tidak ditemukan " + e.getMessage());
		}
		
		
	}
	
	
}
