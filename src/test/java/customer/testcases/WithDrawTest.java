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

public class WithDrawTest extends testBase {

	@Test(dataProvider = "customerDP", dataProviderClass = DataProviders.class)
	public static void withDrawTest(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite2("CustomerSuite", "WithDrawTest", data.get("RunMode"));

		try {

			click("customerloginBtn_XPATH");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(OR.getProperty("userselect_customer_XPATH"))));

			select("userselect_customer_XPATH", data.get("CustomerName"));
			click("customer_login_Btn_XPATH");
			click("withdrawBtn_CSS");
			type("withdrawinputBox_XPATH", data.get("AmountToWithDraw"));
			click("withdrawsubmitBtn_XPATH");

			String a = driver.findElement(By.xpath(OR.getProperty("withdrawsuccessmessage_XPATH"))).getText();

			assertThat(a, equalTo(data.get("WithDrawMessage")));

			log.info("WithDraw Test is Passed like a Charm");

		} catch (AssertionError e) {

			e.printStackTrace();
			log.debug(e);
			Assert.fail(String.valueOf(e), e);
		}
	}
}