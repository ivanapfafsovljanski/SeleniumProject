package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class PersonalInfoPage {
	WebDriver driver;
	ExcellReader readFromExcell;
	WebElement lastNameFieldChanging;
	WebElement passwordConformationField;
	WebElement saveBtn;
	WebElement successMesage;
	
	
	public PersonalInfoPage(WebDriver driver, ExcellReader readFromExcell) {
		this.driver = driver;
		this.readFromExcell = readFromExcell;
	}
	
	public void changeingLastName() {
		lastNameFieldChanging = driver.findElement(By.id("lastname"));
		lastNameFieldChanging.clear();
		lastNameFieldChanging.sendKeys(readFromExcell.textualValue("PersonalInfo", 5, 4));
	}
	public void passwordConformation() {
		passwordConformationField = driver.findElement(By.id("old_passwd"));
		passwordConformationField.sendKeys(readFromExcell.textualValue("PersonalInfo", 6, 4));
	}
	public void saveBtnClick() {
		saveBtn = driver.findElement(By.name("submitIdentity"));
		saveBtn.click();
	}
	public String assertSuccessMesage() {
		successMesage = driver.findElement(By.cssSelector(".alert.alert-success"));
		return successMesage.getText();
	}
	public void clickOnBackToYourAccountBtn() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a")).click();
	}
	
	public void returningOldlastName() {
		lastNameFieldChanging = driver.findElement(By.id("lastname"));
		lastNameFieldChanging.clear();
		lastNameFieldChanging.sendKeys(readFromExcell.textualValue("PersonalInfo", 4, 8));
	}
}
