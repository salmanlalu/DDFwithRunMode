package testcases;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends testBase {

	@Test(dataProvider = "bankManagerDP", dataProviderClass = DataProviders.class)
	public static void addCustomerTest(Hashtable<String, String> data) {

		DataUtil.checkExecutionSuite1("BankManagerSuite", "AddCustomerTest", data.get("RunMode"));
						
		try {
		click("bmLoginBtn_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("homebtn_XPATH"))));
		log.info("addCustomerTest is started");

		click("addcustomerbtn_CSS");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("customerfirstName_XPATH"))));

		type("customerfirstName_XPATH", data.get("FirstName"));
		type("customerlastName_XPATH", data.get("LastName"));
		type("customerPostCode_XPATH", data.get("PostCode"));

		click("addcustomerbtnsmall_XPATH");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("Alert")));
		
		alert.accept();

		log.info("addCustomerTest is passed like a charm");
		
		click("homebtn_XPATH");
		
		} catch(Exception e) {
			log.debug(e);
		} 

	}

}