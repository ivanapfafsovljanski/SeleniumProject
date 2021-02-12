package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class PagesPage {
	WebDriver driver;
	ExcellReader readFromExcell;
	
	
public PagesPage(WebDriver driver, ExcellReader readFromExcell) {
		this.driver = driver;
		this.readFromExcell = readFromExcell;
	}
public void clickLoginBtnHomePage() {
	driver.findElement(By.className("login")).click();
}


//excell reader
public String stringFromExcell(String sheetName, int rowNo, int cellNo) {
	String textField = readFromExcell.textualValue(sheetName, rowNo, cellNo);
	return textField;
}

public String worningMsg(){
	return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();	
}
//for Assert
public boolean signOutBtnDisplayed() {
	return driver.findElement(By.className("logout")).isDisplayed();
}
//for Assert
public String authenticationNavPgDisplayed() {
	return driver.findElement(By.className("navigation_page")).getText();
}
//btn in nav-bar with name
public void clickOnMyAccountBtn() {
	driver.findElement(By.className("header_user_info")).click();
}

}