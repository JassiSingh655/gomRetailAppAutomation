package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Redmi 9A");
		desiredCapabilities.setCapability("platformVersion", "10 QP1A.190711.020");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appPackage", "gomechanic.retail");
		desiredCapabilities.setCapability("appActivity", "gomechanic.retail.HomeActivity");
		desiredCapabilities.setCapability("udid", "PV4HBUTG5XYXYPMN");
		desiredCapabilities.setCapability("noReset", false);
		desiredCapabilities.setCapability("newCommandTimeout", 3600);
		desiredCapabilities.setCapability("connectHardwareKeyboard", true);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		desiredCapabilities.setCapability("autoGrantPermissions", "true");
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);

	}

	@Test
	public void sampleTest() {

		System.out.println("App is launchged successfully");

	}

//	@AfterClass(alwaysRun = true)
//	public void tearDown() {
//		if (driver != null)
//		driver.close();
	
public void verticalSwipe() {
	TouchAction  action =new TouchAction((PerformsTouchActions) driver);	
	Dimension size	=driver.manage().window().getSize();
	int width=size.width;
	int height=size.height;				
	int middleOfX=width/2;
	int startYCoordinate= (int)(height*.7);
	int endYCoordinate= (int)(height*.2);
					
//	action.press(PointOption.point(middleOfX, startYCoordinate))
//	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//	.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
}
	
}
