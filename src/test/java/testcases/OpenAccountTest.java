package testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenAccountTest extends testBase {

	@Test(dataProvider = "bankManagerDP", dataProviderClass = DataProviders.class)
	public static void openAccountTest(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite("BankManagerSuite", "OpenAccountTest", data.get("RunMode"));
		
		try {
		click("bmLoginBtn_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("openaccount_XPATH"))));

		click("openaccount_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("userselect_XPATH"))));
		log.info("openAccountTest is started");

		select("userselect_XPATH", data.get("CustomerName"));
		select("currencyselect_XPATH", data.get("Currency"));

		click("processbtn_XPATH");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String textOpenAccountAlert = alert.getText();
		alert.accept();
		//Assert.assertTrue(alert.getText().contains(data.get("Alert")));
		assertThat(textOpenAccountAlert, containsString(data.get("Alert")));
		
		log.info("openAccountTest is passed like a charm");
		
		} catch(AssertionError e) {
			log.info(e);
			Assert.fail(String.valueOf(e), e);
			
		}
		
	}

}
