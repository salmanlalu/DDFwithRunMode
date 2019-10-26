package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class withdrawTest extends testBase {

	@Test
	public static void withDrawTest() {
		
		click("customerloginBtn_XPATH");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(OR.getProperty("userselect_customer_XPATH"))));

		select("userselect_customer_XPATH", "Hermoine Granger");

		click("customer_login_Btn_XPATH");
		
		click("withdrawBtn_CSS");
		
		type("withdrawinputBox_XPATH", "1");
		
		click("withdrawsubmitBtn_XPATH");
		
		String a = driver.findElement(By.xpath(OR.getProperty("withdrawsuccessmessage_XPATH"))).getText();
		
		String b = "Transaction successful";
		
		Assert.assertTrue(a.contains(b));
		
		System.out.println(a);
		
		
	}
}
