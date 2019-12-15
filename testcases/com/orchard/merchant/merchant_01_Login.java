package com.orchard.merchant;

import org.testng.annotations.Test;


import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class merchant_01_Login {
	WebDriver driver;
	private AbstractPage abstractPage;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  abstractPage = new AbstractPage();
	  abstractPage.openAnyUrl(driver, "https://int-orchard.jmango360.com/");
  }

  @Test
  public void TC_01_LoginWithEmailIncorrect() {
  }
  
  @Test
  public void TC_01_LoginWithEmailCorrect() {
	  
		/*Wait for Login form visible*/
	  abstractPage.waitForControlVisible(driver, "//input[@id='username']");
	 
		/* Input to username and password*/
	  abstractPage.sendKeyToElement(driver, "//input[@id='username']", "thao.nguyen@jmango360.com");
	  
	  abstractPage.sendKeyToElement(driver, "//input[@id='password']", "123456");
	  
		/* Click to Login Button*/
	  abstractPage.clickToElement(driver, "//button[@id='btnLoginSubmit']");
	  
		/* Verify login successful*/
	  Assert.assertTrue(abstractPage.isControlDisplay(driver, "//div/h3[text()=\"My Apps\"]"));
  }
  
  
  @AfterClass
  public void afterClass() {
	  abstractPage.quitBrowser(driver);
  }

}
