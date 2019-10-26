package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class depositTest extends testBase {

	@Test
	public static void deposittest() {
		
		click("customerloginBtn_XPATH");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(OR.getProperty("userselect_customer_XPATH"))));

		select("userselect_customer_XPATH", "Harry Potter");

		click("customer_login_Btn_XPATH");
		
		click("depositBtn_CSS");
		
		type("depositinputBox_XPATH", "1000");
		
		click("depositsubmitBtn_XPATH");
		
		String a = driver.findElement(By.xpath(OR.getProperty("depositsuccessmessage_XPATH"))).getText();
		
		String b = "Deposit Successful";
		
		Assert.assertTrue(a.contains(b));
		
		System.out.println(a);
		
	}
}
