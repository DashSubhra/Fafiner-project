package com.fafiner.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.LoginPage;

public class TestLoginUS13 {

	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preTest()
	{
		driver = TestConfiguration.createDriverInstance();
		login = new LoginPage(driver);
	}
	
	@Test
	public void testLoginErrorTC102()
	{
		login.getUsernameTextbox().sendKeys("Abc");
		login.getPasswordTextbox().sendKeys("123");
		login.getLoginButton().click();
		String actualErrorMsg = login.getErrorMsg().getText();
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
	

}
