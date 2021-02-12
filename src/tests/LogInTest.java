package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestsBase{

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		allPages.clickLoginBtnHomePage();
		Thread.sleep(1000);
	}
	
	
	@Test(priority = 1)
	public void LoginValid() throws InterruptedException{
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 4, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 6, 4));
		pageAuthorication.ClickloginBtn();
		Assert.assertTrue(allPages.signOutBtnDisplayed());
		pageMyAccount.clickOnSignOutBtn();
	}
	@Test(priority = 2)
	public void LogOuValid() throws InterruptedException {
		LoginValid();
		Assert.assertEquals(allPages.authenticationNavPgDisplayed(), allPages.stringFromExcell("Login", 40, 5));
	}
	@Test(priority = 5)
	public void LoginEmpty() {
		pageAuthorication.ClickloginBtn();
		Assert.assertEquals(allPages.worningMsg(), allPages.stringFromExcell("Login", 16, 5));
	}
	@Test(priority = 10)
	public void LoginWrongEmail() {
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 22, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 24, 4));
		pageAuthorication.ClickloginBtn();
		Assert.assertEquals(allPages.worningMsg(), allPages.stringFromExcell("Login", 25, 5));
	}
	@Test(priority = 15)
	public void LoginWrongPsw() {
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 31, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 33, 4));
		pageAuthorication.ClickloginBtn();
		Assert.assertEquals(allPages.worningMsg(), allPages.stringFromExcell("Login", 34, 5));
	}
	@Test(priority = 20)
	public void LoginWrongCredentials() throws InterruptedException{
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 49, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 51, 4));
		pageAuthorication.ClickloginBtn();
		Assert.assertEquals(allPages.worningMsg(), allPages.stringFromExcell("Login", 53, 5));
	}
	
}

