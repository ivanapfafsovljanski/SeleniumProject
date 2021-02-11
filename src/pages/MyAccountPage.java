package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressBtn;
	

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnSignOutBtn() {
		driver.findElement(By.className("logout")).click();
	}
	public void clickOnMyAddressBtn() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a")).click();
	}
	public void clickOnProfileInfoBtn() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")).click();
	}
	public void clickOnMyWishListBtn() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a")).click();
	}
	
	
	

}
