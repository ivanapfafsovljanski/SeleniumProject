package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTest extends TestsBase{
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		allPages.clickLoginBtnHomePage();
		Thread.sleep(1000);
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 4, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 6, 4));
		pageAuthorication.ClickloginBtn();
		pageMyAccount.clickOnMyAddressBtn();
		Thread.sleep(1000);
	}
	@Test (priority = 30)
	public void changeAddress() throws InterruptedException {
		
		pageMyAddress.clickOnUpdateBtn();
		pageMyAddress.formChange();
		pageMyAddress.saveChangesInForm();
		
		for (int i = 0; i < pageMyAddress.changedAddressValueAssert().size(); i++) {	
			if (i == 3) {
				Assert.assertEquals(pageMyAddress.changedAddressValueAssert().get(i), readFromExcell.textualValue("MyAddress", (5+i), 4) + ",");
			}
			else
			Assert.assertEquals(pageMyAddress.changedAddressValueAssert().get(i), readFromExcell.textualValue("MyAddress", (5+i), 4));		
		}
		
		pageMyAddress.clickOnUpdateBtn();
		pageMyAddress.addressInitialValue();
		pageMyAddress.saveChangesInForm();
	}
	@Test (priority = 35)
	public void addNewAddress() {
		int noAddressStart = pageMyAddress.numberOfAddresses();
		pageMyAddress.numberOfAddresses();
		pageMyAddress.clickOnAddNewAddressBtn();
		pageMyAddress.newAddress();
		pageMyAddress.dropdownLists();
		pageMyAddress.saveChangesInForm();		
		Assert.assertEquals(pageMyAddress.numberOfAddresses(), (noAddressStart + 1));
		}
	@Test (priority = 36)
	public void delleteAddress() throws InterruptedException {
		int noAddressStart = pageMyAddress.numberOfAddresses();
		pageMyAddress.deleteAddress();
		Assert.assertEquals(pageMyAddress.numberOfAddresses(), (noAddressStart - 1));
	}
	@AfterMethod
	public void logOut() throws InterruptedException {
		pageMyAccount.clickOnSignOutBtn();
	}
	
}
