package utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info of the report
	public ExtentTest test; // create test case
	public WebDriver driver;
	public String dateFormat;

	public void onStart(ITestContext context) {
		LocalDateTime localTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		dateFormat = localTime.format(formatter);
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/extentreports/" + dateFormat + "-report.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); // set the title of the report
		sparkReporter.config().setReportName("Functional Testing"); // set name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "autotest");
		extent.setSystemInfo("Tester", "Vipul Kumar");

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed : " + result.getTestClass().getRealClass().getSimpleName() + ".class -"
				+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestClass().getRealClass().getSimpleName() + ".class - " + result.getName());
		this.driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sspath = System.getProperty("user.dir") + "/test-output/screenshots/" + result.getName() + " "
				+ dateFormat + "-ss.png";
		File trgtfile = new File(sspath);
		srcfile.renameTo(trgtfile);
		// FileUtils.copyFile(srcfile, trgtfile);
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed : " + result.getTestClass().getRealClass().getSimpleName() + ".class - "
				+ result.getName()).addScreenCaptureFromPath(sspath);
		test.log(Status.FAIL, "Test Fail cause is : " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP,
				"Test Skip : " + result.getTestClass().getRealClass().getSimpleName() + ".class - " + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
