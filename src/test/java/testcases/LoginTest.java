package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class LoginTest extends testBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		click("bmLoginBtn_CSS");
		//driver.findElement(By.cssSelector("ng-click='manager()'")).click();
		log.info("loginTest Started");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("homebtn_XPATH"))));

		Assert.assertTrue(isPresentElement(By.cssSelector(OR.getProperty("addcustomerbtn_CSS"))));
		log.info("loginTest is passed like a charm :)");
		click("homebtn_CSS");
	}

}
