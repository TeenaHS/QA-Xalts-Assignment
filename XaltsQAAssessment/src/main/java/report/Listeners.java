package report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test is successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test has failed");
		if (driver != null) {
			try {
				String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			test.fail("Screenshot not captured: WebDriver is null.");
		}
	}

	private String takeScreenshot(String methodName) throws IOException {
		if (driver == null) {
			System.out.println("Driver is null, skipping screenshot capture.");
			return "";
		}
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/screenshots/" + methodName + ".png";

		File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots/");
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}

		FileUtils.copyFile(srcFile, new File(destination));
		return destination;
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
