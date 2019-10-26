package customer.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;

public class CustomerLoginTest extends testBase {

	@Test(dataProvider = "customerDP", dataProviderClass = DataProviders.class)
	public void customerLoginTest(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite2("CustomerSuite", "CustomerLoginTest", data.get("RunMode"));

		try {
			click("customerloginBtn_XPATH");
			log.info("CustomerloginTest Started");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(OR.getProperty("userselect_customer_XPATH"))));

			select("userselect_customer_XPATH", data.get("CustomerName"));

			click("customer_login_Btn_XPATH");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("transaction_XPATH"))));

			Assert.assertTrue(isPresentElement(By.xpath(OR.getProperty("transaction_XPATH"))));
			log.info("CustomerloginTest is passed like a charm :)");

		} catch (Exception e) {
			log.debug(e);
		}
	}
}
