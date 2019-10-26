package utilities;

import utilities.ExcelReader;

import java.util.Hashtable;

import org.testng.SkipException;
import utilities.Constants;

public class DataUtil {

	public static boolean isSuiteRunnable(String suiteName) {

		ExcelReader excel = new ExcelReader(Constants.SUITE_XCEL_PATH);
		int rows = excel.getRowCount(Constants.SUITE_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String data = excel.getCelldata(Constants.SUITE_SHEET, rNum, Constants.SUITENAME_COLS);
			if (data.equals(suiteName)) {

				String runmodes = excel.getCelldata(Constants.SUITE_SHEET, rNum, Constants.RUNMODES_COLS);

				if (runmodes.equals(Constants.RUNMODES_YES))
					return true;
				if (runmodes.equals(Constants.RUNMODES_NO))
					return false;
			}

		}

		return false;
	}

	public static boolean isTestRunnableSuite1(String testCaseName) {

		ExcelReader excel = new ExcelReader(Constants.SUITE_BANKMANAGER_XCEL_PATH);

		int rows = excel.getRowCount(Constants.TestCase_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String data = excel.getCelldata(Constants.TestCase_SHEET, rNum, Constants.TESTCASENAME_COLS);

			if (data.equals(testCaseName)) {

				String runmodes = excel.getCelldata(Constants.TestCase_SHEET, rNum, Constants.RUNMODES_TestCase_COLS);

				if (runmodes.equals(Constants.RUNMODES_YES))
					return true;
				if (runmodes.equals(Constants.RUNMODES_NO))
					return false;
			}

		}

		return false;
	}
	
	public static boolean isTestRunnableSuite2(String testCaseName) {

		ExcelReader excel = new ExcelReader(Constants.SUITE_CUSTOMER_XCEL_PATH);

		int rows = excel.getRowCount(Constants.TestCase_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String data = excel.getCelldata(Constants.TestCase_SHEET, rNum, Constants.TESTCASENAME_COLS);

			if (data.equals(testCaseName)) {

				String runmodes = excel.getCelldata(Constants.TestCase_SHEET, rNum, Constants.RUNMODES_TestCase_COLS);

				if (runmodes.equals(Constants.RUNMODES_YES))
					return true;
				if (runmodes.equals(Constants.RUNMODES_NO))
					return false;
			}

		}

		return false;
	}


	public static Object[][] getData(String testCase, ExcelReader excel) {

		int rows = excel.getRowCount(Constants.DATA_SHEET);

		System.out.println("The total Number of rows are: " + rows);

		String testName = testCase;

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCelldata(Constants.DATA_SHEET, testCaseRowNum, 0);

			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}

		System.out.println("Test Case Start drom the row number: " + testCaseRowNum);

		int dataStartRow = testCaseRowNum + 2;

		int testRows = 0;

		while (!excel.getCelldata(Constants.DATA_SHEET, dataStartRow + testRows, 0).equals("")) {

			testRows++;
		}

		System.out.println("total rows for the testcase: " + testRows);

		int dataStartCol = testCaseRowNum + 1;

		int testCol = 0;

		while (!excel.getCelldata(Constants.DATA_SHEET, dataStartCol, testCol).equals("")) {

			testCol++;
		}

		System.out.println("Total Column for the test case: " + testCol);

		Object[][] data = new Object[testRows][1];

		int i = 0;

		for (int rNum = dataStartRow; rNum < (dataStartRow + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();
			//HashMap<String, String> map = new HashMap<String, String>();
			
			for (int cNum = 0; cNum < testCol; cNum++) {

				String testData = excel.getCelldata(Constants.DATA_SHEET, rNum, cNum);
				String colName = excel.getCelldata(Constants.DATA_SHEET, dataStartCol, cNum);

				table.put(colName, testData);
				//map.put(colName, testData);
			}
			data[i][0] = table;
			//data[i][0] = map;
			i++;

		}

		return data;
	}

	public static void checkExecutionSuite1(String SuiteName, String TestCaseName, String dataRunmodes) {

		boolean suiterun = isSuiteRunnable(SuiteName);
		boolean caserun = isTestRunnableSuite1(TestCaseName);

		if (suiterun == false) {
			throw new SkipException("Skipping the testsuite " + SuiteName);
		}

		if (caserun == false) {
			throw new SkipException("Skipping the test " + TestCaseName);
		}

		if (dataRunmodes.equalsIgnoreCase(Constants.RUNMODES_NO)) {
			throw new SkipException("Skipping the test " + TestCaseName + " because of the Runmodes");
		}

	}
	
	public static void checkExecutionSuite2(String SuiteName, String TestCaseName, String dataRunmodes) {

		boolean suiterun = isSuiteRunnable(SuiteName);
		boolean caserun = isTestRunnableSuite2(TestCaseName);

		if (suiterun == false) {
			throw new SkipException("Skipping the testsuite " + SuiteName);
		}

		if (caserun == false) {
			throw new SkipException("Skipping the test " + TestCaseName);
		}

		if (dataRunmodes.equalsIgnoreCase(Constants.RUNMODES_NO)) {
			throw new SkipException("Skipping the test " + TestCaseName + " because of the Runmodes");
		}

	}

}
