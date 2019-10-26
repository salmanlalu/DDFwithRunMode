package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.Constants;
import utilities.ExcelReader;
import utilities.DataUtil;

public class DataProviders {

	
	@DataProvider(name="bankManagerDP", parallel = false)
	public Object [][] getDataforBanlManagerSuite(Method m){
		
		String testcase = m.getName();
		ExcelReader excel = new ExcelReader(Constants.SUITE_BANKMANAGER_XCEL_PATH);
		
		return DataUtil.getData(testcase, excel);
	}
	
	@DataProvider(name="customerDP")
	public Object [][] getDataforCustomerSuite(Method m){
		
		String testcase = m.getName();
		ExcelReader excel = new ExcelReader(Constants.SUITE_CUSTOMER_XCEL_PATH);
		
		return DataUtil.getData(testcase, excel);
	}
	
	
}
