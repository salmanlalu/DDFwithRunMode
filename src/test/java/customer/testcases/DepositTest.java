package customer.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;
import utilities.DataProviders;
import utilities.DataUtil;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DepositTest extends testBase {

	@Test(dataProvider = "customerDP", dataProviderClass = DataProviders.class)
	public static void depositTest(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite("CustomerSuite", "DepositTest", data.get("RunMode"));

		try {

			click("customerloginBtn_XPATH");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(OR.getProperty("userselect_customer_XPATH"))));

			select("userselect_customer_XPATH", data.get("CustomerName"));
			click("customer_login_Btn_XPATH");
			click("depositBtn_CSS");
			type("depositinputBox_XPATH", data.get("AmountToDeposit"));
			click("depositsubmitBtn_XPATH");

			String a = driver.findElement(By.xpath(OR.getProperty("depositsuccessmessage_XPATH"))).getText();

			assertThat(a, equalTo(data.get("DepositMessage")));
			log.info("Deposit Test is Passed Like A Charm");

		} catch (AssertionError e) {
			log.info(e);
			Assert.fail(String.valueOf(e), e);

		}
	}
}