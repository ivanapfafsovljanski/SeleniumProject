package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTest extends TestsBase{
	//@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		allPages.clickLoginBtnHomePage();
		Thread.sleep(1000);
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 4, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 6, 4));
		pageAuthorication.ClickloginBtn();
		Thread.sleep(1000);
		pageMyAccount.clickOnProfileInfoBtn();
	}
	//@Test (priority = 40)
	public void changigPersonalInfo() {
		pagePersonalInfo.changeingLastName();
		pagePersonalInfo.passwordConformation();
		pagePersonalInfo.saveBtnClick();
		Assert.assertEquals(pagePersonalInfo.assertSuccessMesage(), readFromExcell.textualValue("PersonalInfo", 8, 4));
		//changing to old values
		pagePersonalInfo.clickOnBackToYourAccountBtn();
		pageMyAccount.clickOnProfileInfoBtn();
		pagePersonalInfo.returningOldlastName();
		pagePersonalInfo.passwordConformation();
		pagePersonalInfo.saveBtnClick();
	}
	//@AfterMethod
	public void afterMethod() {
		//changing to old values
		pagePersonalInfo.clickOnBackToYourAccountBtn();
		pageMyAccount.clickOnProfileInfoBtn();
		pagePersonalInfo.returningOldlastName();
		pagePersonalInfo.passwordConformation();
		pagePersonalInfo.saveBtnClick();
	}
}
