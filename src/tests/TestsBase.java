package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestsBase {
	WebDriver driver;
	@BeforeClass
	public void preKlase() {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterClass
	public void posleKlase() {
		driver.close();
	}
}
