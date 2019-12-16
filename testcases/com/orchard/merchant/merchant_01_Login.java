package com.orchard.merchant;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;

public class merchant_01_Login {
	WebDriver driver;
	
	//khai bao
	private LoginPageObject loginPage;
	private AbstractPage abstractPage;
	private HomePageObject homePage;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  abstractPage = new AbstractPage();
	  abstractPage.openAnyUrl(driver, "https://int-orchard.jmango360.com/");
	  
	  //Khoi tao
	  loginPage = new LoginPageObject();
	  homePage = new HomePageObject();
  }

  @Test
  public void TC_01_LoginWithEmailIncorrect() {
	
  }
  
  
  @Test
  public void TC_01_LoginWithEmailCorrect() {
	  
		/*Wait for Login form visible*/
	  //abstractPage.waitForControlVisible(driver, "//input[@id='username']");
	 //loginPage.waitForUserIDVisible();
		/* Input to username and password*/
	 
	 //.inputToUserIDTextbox();
	 // abstractPage.sendKeyToElement(driver, "//input[@id='username']", "thao.nguyen@jmango360.com");
	  
	 //loginPage.inputToPasswordIDTextbox();
	 // abstractPage.sendKeyToElement(driver, "//input[@id='password']", "123456");
	  
		/* Click to Login Button*/
	//homePage = loginPage.clickToLoginButton();
	 // abstractPage.clickToElement(driver, "//button[@id='btnLoginSubmit']");
	  
		/* Verify login successful*/
	  //Assert.assertTrue(abstractPage.isControlDisplay(driver, "//div/h3[text()=\"My Apps\"]"));
	//homePage.isHomePageIsDisplay();
  }
  
  
  @AfterClass
  public void afterClass() {
	  abstractPage.quitBrowser(driver);
  }

}
