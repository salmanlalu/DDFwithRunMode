package rough;

import org.openqa.selenium.By;

import base.testBase;
import utilities.*;

public class runnabletest extends testBase {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//
//		boolean a = DataUtil.isTestRunnableSuite1("OpenAccountTest");
//		System.out.println(a);
		
		

		click("bmLoginBtn_XPATH");
		
		click("customerBtn_XPATH");
		
		//int rows = driver.findElements(By.xpath(OR.getProperty("webtableDeleteCustomer"))).size();
		
		//.out.println("Total rows: " +rows);
		
		click("homebtn_CSS");
		
	}

}
