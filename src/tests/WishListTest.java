package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends TestsBase{

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		allPages.clickLoginBtnHomePage();
		Thread.sleep(1000);
		pageAuthorication.getemailField().sendKeys(allPages.stringFromExcell("Login", 4, 4));
		pageAuthorication.getpasswordField().sendKeys(allPages.stringFromExcell("Login", 6, 4));
		pageAuthorication.ClickloginBtn();
		pageMyAccount.clickOnMyWishListBtn();
	}
	@Test(priority = 45)
	public void addingWishList() {
		pageWishList.enteringNameOfWishList(5);
		pageWishList.clickOnSaveWishlistBtn();
		pageWishList.assertWishLictCreated();
		Assert.assertTrue(pageWishList.assertWishLictCreated());
	}
	@Test(priority = 46)
	public void deltingWishList() throws InterruptedException {
		pageWishList.clickOnDeleteBtns();
		Thread.sleep(5000);		
		Assert.assertEquals(pageWishList.deleteBtnList().size(), 0);
	}
	@Test(priority = 55)
	public void addingMultipleWishlists() throws InterruptedException {
		int i = 0;
		for (; i < 3; i++) {
			pageWishList.enteringNameOfWishList(24+i);
			pageWishList.clickOnSaveWishlistBtn();
		}
		//expected number is i + 1 because first row in table is header
		//list is created by counting rows in table where wishlists names are placed
		Assert.assertEquals(pageWishList.wishlistList().size(), i+1);
		pageWishList.clickOnDeleteBtns();
	}
	
	@AfterMethod
	public void logOut() throws InterruptedException {
		pageMyAccount.clickOnSignOutBtn();
	}
}
