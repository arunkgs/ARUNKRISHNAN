package testCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.driverinstance;
import junit.framework.Assert;
import pages.loginPage;
import utilityPackage.ExcelUtils;

public class TC_1_LoginPage_ValidTest extends driverinstance {
	private String sTestCaseName;
	private int iTestCaseRow;

	@Test(dataProvider = "Authentication")
	public void tc_01_login_Test(String uname, String password) throws IOException {
		loginPage login = new loginPage(driver);
		login.enterusername(uname);
		login.enterpassword(password);
		login.clicksignin();
		Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		utilityPackage.ExcelUtils.setExcelFile("./TestData/TestData.xlsx", "testdata");
		String sTestCaseName = "DataProviderWithExcel";
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		Object[][] testObjArray = ExcelUtils.getTableArray(iTestCaseRow);
		return (testObjArray);
	}
}
