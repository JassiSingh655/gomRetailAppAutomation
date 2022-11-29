package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.BaseClass;

public class ListenerTest extends BaseClass implements ITestListener {

	//private static WebDriver driver;
	String filePath = "/Users/admin/Documents/GoautomationCode/gomech_orderingtestng/screenshots";

	public void onFinish(ITestContext Result) {

	}

	public void onStart(ITestContext Result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	// When Test case get failed, this method is called.
	public void takeScreenShot(String methodName) throws IOException {
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
		    System.out.println("***Placed screenshots for failed tests in "+filePath+" ***");}

	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the testcase failed is :" + Result.getName());
		System.out.println("***** Error " + Result.getName() + " test has failed *****");
		String methodName = Result.getName().toString().trim();
		ITestContext context = Result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		try {
			takeScreenShot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
	}

	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
	}

	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
	}

}
