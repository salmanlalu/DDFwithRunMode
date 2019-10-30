package utilities;

public class Constants {

	    //Constants for Suite
		public static String SUITE_SHEET = "Suite";
		public static String BANKMANGER_SUITENAME = "BankManagerSuite";
		public static String CUSTOMER_SUITENAME = "CustomerSuite";
		public static int SUITENAME_COLS = 0;
		public static int RUNMODES_COLS = 1;

		
		//Constants for Testcases
		public static String TestCase_SHEET = "TestCases";
		public static String DATA_SHEET = "TestData";
		public static int TESTCASENAME_COLS = 0;
		public static int RUNMODES_TestCase_COLS = 1;

		
		//General Runmodes constants
		public static String RUNMODES_YES = "Y";
		public static String RUNMODES_NO = "N";
		
		//Path for all the xcel files
		public static String SUITE_XCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Suite.xlsx";
		public static String SUITE_BANKMANAGER_XCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\BankManagerSuite.xlsx";
		public static String SUITE_CUSTOMER_XCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\CustomerSuite.xlsx";
		
}
