package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthoricationPage;
import pages.MyAccountPage;
import pages.MyAddressPage;
import pages.PagesPage;
import pages.PersonalInfoPage;
import pages.WishListPage;

public class TestsBase {
	WebDriver driver;
	ExcellReader readFromExcell;
	JavascriptExecutor js;
	MyAccountPage pageMyAccount;
	PagesPage allPages;
	AuthoricationPage pageAuthorication;
	MyAddressPage pageMyAddress;
	PersonalInfoPage pagePersonalInfo;
	WishListPage pageWishList;



@BeforeClass
public void beforeClass() throws IOException {
	
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");	
	this.driver = new ChromeDriver();
	this.readFromExcell = new ExcellReader("data\\TC1.xlsx");
	this.js = (JavascriptExecutor) driver;
	this.pageMyAccount = new MyAccountPage(driver);
	this.allPages = new PagesPage(driver, readFromExcell);
	this.pageAuthorication = new AuthoricationPage(driver);
	this.pageMyAddress = new MyAddressPage(driver, js, readFromExcell);
	this.pagePersonalInfo = new PersonalInfoPage(driver, readFromExcell);
	this.pageWishList = new WishListPage(driver, readFromExcell, js);
	
	
	driver.manage().window().maximize();
}

@AfterClass
public void afterClass() throws IOException {
	driver.close();
	
}
}
