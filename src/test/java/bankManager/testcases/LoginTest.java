package bankManager.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;


public class LoginTest extends testBase {

	@Test(dataProvider = "bankManagerDP", dataProviderClass = DataProviders.class)
	public void loginAsBankManager(Hashtable <String, String> data) throws InterruptedException {

		DataUtil.checkExecutionSuite("BankManagerSuite", "LoginTest", data.get("RunMode"));
		
		click("bmLoginBtn_XPATH");
		log.info("loginTest Started");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("homebtn_XPATH"))));

		Assert.assertTrue(isPresentElement(By.cssSelector(OR.getProperty("addcustomerbtn_CSS"))));
		
		//assertThat(isPresentElement(By.cssSelector(OR.getProperty("addcustomerbtn_CSS"))), is(true));
		
		log.info("loginTest is passed like a charm :)");
		

	}

}
