package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.ExcellReader;

public class MyAddressPage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcellReader readFromExcell;
	WebElement updateBtn;
	Select statesDdb;
	
	List<WebElement> formsFields;
	List<WebElement> fieldsToChange;
	List<WebElement> listOfAddresses;
	List<String> listOfNewAddressValues;
	
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement company;
	WebElement address;
	WebElement AddressLine2;
	WebElement city;
	WebElement state;
	WebElement zipCode;
	WebElement country;
	WebElement phoneHome;
	WebElement phoneMobile;
	WebElement additionalInfo;
	WebElement addressTitle;
	WebElement addNweAddressBtn;
	WebElement deleteBtn;
	
	public MyAddressPage(WebDriver driver, JavascriptExecutor js, ExcellReader readFromExcell) {
		this.driver = driver;
		this.js = js;
		this.readFromExcell = readFromExcell;
	}
	
	//excell reader - da li je ovo duplo?!?
/*	public String stringFromExcell(String sheetName, int rowNo, int cellNo) {
		String textField = readFromExcell.textualValue(sheetName, rowNo, cellNo);
		return textField;
	}
	public int numbersFromExcell(String sheetName, int rowNo, int cellNo) {
		int numericField = readFromExcell.numericValue(sheetName, rowNo, cellNo);
		return numericField;
	}*/
	public void clickOnUpdateBtn() throws InterruptedException {
		//updateBtn = driver.findElement(By.cssSelector(".btn.btn-default.button.button-small"));
		updateBtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[9]/a[1]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", updateBtn);
		//js.executeScript("arguments[0].scrollIntoView();", updateBtn);
	}
	//FILING FORM list of forms fields
	public void settingListOfFormFileld() {
		formsFields = driver.findElements(By.className("form-control"));
	}

	//FORM/
	public void formFieldsSet() {
		settingListOfFormFileld();
		//first 4 required fields
		fieldsToChange = new ArrayList<WebElement>();
		firstNameField = formsFields.get(1);
		lastNameField = formsFields.get(2);
		address = formsFields.get(4);
		city = formsFields.get(6);
		//numeric fileds
		zipCode = formsFields.get(8);
		phoneHome = formsFields.get(10);
		//adress title
		addressTitle = formsFields.get(14);
		//added to list
		fieldsToChange.add(firstNameField);
		fieldsToChange.add(lastNameField);
		fieldsToChange.add(address);
		fieldsToChange.add(city);
		//added to list
		fieldsToChange.add(zipCode);
		fieldsToChange.add(phoneHome);
		fieldsToChange.add(addressTitle);
	}
	//select from dropdown list
	public void dropdownLists() {
		statesDdb = new Select(driver.findElement(By.id("id_state")));
		statesDdb.selectByIndex(25);
		
	}
	public void addressInitialValue() {
		formFieldsSet();
		for (int i = 0; i < 4; i++) {
			fieldsToChange.get(i).clear();
			fieldsToChange.get(i).sendKeys(readFromExcell.textualValue("MyAddress",(i+3), 9 ));	
		}
	}

	public void formChange() {
		formFieldsSet();
		for (int i = 0; i < 4; i++) {
			fieldsToChange.get(i).clear();
			fieldsToChange.get(i).sendKeys(readFromExcell.textualValue("MyAddress", (i+5), 4));	
		}
	}
	public void saveChangesInForm() {
		driver.findElement(By.id("submitAddress")).click();;
	}
	//za asertovanje
	public void changedAddressValueAssert() {
		listOfNewAddressValues = new ArrayList<String>();
		listOfNewAddressValues.add(driver.findElement(By.className("address_name")).getText());
		listOfNewAddressValues.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[2]")).getText());
		listOfNewAddressValues.add(driver.findElement(By.className("address_address1")).getText());
		listOfNewAddressValues.add(driver.findElement(By.className("address_address2")).getText());
	}

	public void clickOnAddNewAddressBtn() {
		List<WebElement> btnsOnMyAddressPage = driver.findElements(By.cssSelector(".btn.btn-default.button.button-medium"));
		addNweAddressBtn = btnsOnMyAddressPage.get(1);
		js.executeScript("arguments[0].click();", addNweAddressBtn);
	}
	//adding new addres
	public void newAddress() {
		formFieldsSet();
		for (int i = 0; i < 4; i++) {
			fieldsToChange.get(i).clear();
			fieldsToChange.get(i).sendKeys(readFromExcell.textualValue("MyAddress",(i+17), 4 ));	
		}
		
		fieldsToChange.get(4).sendKeys(String.valueOf(readFromExcell.numericValue("MyAddress", 21, 4)));
		fieldsToChange.get(5).sendKeys(String.valueOf(readFromExcell.numericValue("MyAddress", 22, 4)));
		fieldsToChange.get(6).clear();
		fieldsToChange.get(6).sendKeys(readFromExcell.textualValue("MyAddress",25, 4 ));
	}
//asserting addition of new address
	public int numberOfAddresses() {
		listOfAddresses = driver.findElements(By.className("address"));
		int numberOfAddresses = listOfAddresses.size();
		return numberOfAddresses;
	}
	
	//delete address
	public void deleteAddress() throws InterruptedException {
		deleteBtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div[2]/ul/li[9]/a[2]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", deleteBtn);
		driver.switchTo().alert().accept();
	}
	
}
