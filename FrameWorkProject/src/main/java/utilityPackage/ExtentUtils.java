package utilityPackage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentUtils {
	static ExtentReports extent;
	static ExtentTest logger;
	static WebDriver driver;

	public static void finalreport(ITestResult result, WebDriver driver, String className) throws IOException {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String timeStamp = format.format(new Date());
		long millisStart = Calendar.getInstance().getTimeInMillis();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				"./ExtentReports/" + className + "_" + millisStart + ".html");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("LoginTest" + timeStamp);
		reporter.config().setReportName("Sample Report");
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = ScreenshotUtility.getScreenshot(driver);

			logger.log(Status.FAIL, MarkupHelper.createLabel(
					result.getMethod().getMethodName() + "Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case PASSED", ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
		extent.flush();
	}

}
