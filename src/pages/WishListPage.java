package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class WishListPage {
WebDriver driver;
ExcellReader readFromExcell;
JavascriptExecutor js;

WebElement nameInputField;
WebElement saveWishlistBtn;
List<WebElement> listOfWishlistNames;
List<WebElement> listOfDeleteBtns;


public WishListPage(WebDriver driver, ExcellReader readFromExcell, JavascriptExecutor js) {
	this.driver = driver;
	this.readFromExcell = readFromExcell;
	this.js = js;
}
public void enteringNameOfWishList(int x) {
	nameInputField = driver.findElement(By.id("name"));
	nameInputField.sendKeys(readFromExcell.textualValue("WishList", x, 4));
}
public void clickOnSaveWishlistBtn() {
	driver.findElement(By.id("submitWishlist")).click();
}
public List<WebElement> wishlistList() {
	listOfWishlistNames = driver.findElements(By.tagName("tr"));
	return listOfWishlistNames;
}

public boolean assertWishLictCreated() {
	wishlistList();
	String name;
	name = listOfWishlistNames.get(1).getText();
	if (name.contains(readFromExcell.textualValue("WishList", 5, 4))) {
		return true;
	}
	else
		return false;

}
public List<WebElement> deleteBtnList() {
	listOfDeleteBtns = driver.findElements(By.className("icon-remove"));
	return listOfDeleteBtns;
}
public void clickOnDeleteBtns() throws InterruptedException {
	deleteBtnList();
	for (int i = 0; i < listOfDeleteBtns.size(); i++) {
		listOfDeleteBtns.get(i).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
}

}
