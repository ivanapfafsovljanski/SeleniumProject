package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class AuthoricationPage {
	WebDriver driver;
	
	WebElement emailField;
	WebElement passWordField;
	WebElement loginBtn;

	public AuthoricationPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement getemailField() {
		return emailField = driver.findElement(By.id("email"));
	}
	public WebElement getpasswordField() {
		return passWordField = driver.findElement(By.id("passwd"));
	}
	public void ClickloginBtn() {
		loginBtn = driver.findElement(By.id("SubmitLogin"));
		loginBtn.click();
	}
	
	

}

