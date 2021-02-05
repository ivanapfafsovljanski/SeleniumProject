package tests;

import org.testng.annotations.Test;

public class LogInTest extends TestsBase{

	
	@Test 
	public void Login() throws InterruptedException {
		driver.navigate().to("https://www.w3schools.com/");
		Thread.sleep(3000);
}
}
