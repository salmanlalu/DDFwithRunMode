package bankManager.testcases;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddCustomerTest extends testBase {

	@Test(dataProvider = "bankManagerDP", dataProviderClass = DataProviders.class)
	public static void addCustomerTest(Hashtable<String, String> data) throws AssertionError {

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

			String textAlert = alert.getText();
			alert.accept();

			assertThat(textAlert, containsString(data.get("Alert")));

			log.info("addCustomerTest is passed like a charm");

		} catch (AssertionError e) {
			log.info(e);
			Assert.fail(String.valueOf(e), e);
		}

	}

}