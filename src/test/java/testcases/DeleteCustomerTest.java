package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class DeleteCustomerTest extends testBase{
	
	@Test
	public static void deleteCustomerTest() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("return document.title");
		
		click("bmLoginBtn_XPATH");
		
		click("customerBtn_XPATH");
		
		//driver.findElement(By.xpath(OR.getProperty("customerselect_XPATH"))).sendKeys("Ron");
		type("customerselect_XPATH", "Ron");
		
		click("customerDeleteBtn_XPATH");
		

		
		int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr")).size();
//		List <WebElement> tablerow = parentTable.findElements(By.xpath("./tr"));
//		int rows = tablerow.size();
		int expected_rows=0;
		
		//js.executeScript("return document.title");
		//rows_count = driver.execute_script("return document.getElementsByTagName('tr').length")
		//int rows= js.executeScript(parentTable.findElement(By.xpath("./tr")));
		
		//int rowCount = selenium.getXpathCount("//table[@id='Datatable']/tbody/tr").intValue();
//		WebElement parentTable = driver.findElement(By.xpath(OR.getProperty("webtableDeleteCustomer")));
//		List <WebElement> tablerow = parentTable.findElements(By.xpath("./tr"));
//		int rows = tablerow.size();
		
		
		
		Assert.assertEquals(rows, expected_rows);
		
	}
}
