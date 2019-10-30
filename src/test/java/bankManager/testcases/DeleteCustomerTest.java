package bankManager.testcases;

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

public class DeleteCustomerTest extends testBase {

	@Test(dataProvider = "bankManagerDP", dataProviderClass = DataProviders.class)
	public static void deleteCustomerTest(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite("BankManagerSuite", "DeleteCustomerTest", data.get("RunMode"));

		try {

			click("bmLoginBtn_XPATH");
			click("customerBtn_XPATH");
			type("customerselect_XPATH", data.get("CustomerName"));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("customerDeleteBtn_XPATH"))));
			click("customerDeleteBtn_XPATH");

			int expected_rows = 0;
			int rows = driver.findElements(By.xpath(OR.getProperty("webtableDeleteCustomer"))).size();

			driver.switchTo().defaultContent();

			assertThat(rows, equalTo(expected_rows));
			log.info("DeleteCustomerTest passed like a charm");

		} catch (AssertionError e) {

			log.info(e);
			Assert.fail(String.valueOf(e), e);
		}

	}

}
