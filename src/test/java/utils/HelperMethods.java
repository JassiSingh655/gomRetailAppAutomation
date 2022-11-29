package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperMethods {
	
	protected WebDriver driver;
	ConfigFileReader properties = new ConfigFileReader();
	String AccessoriesURL = properties.getKey("AccessoriesURL");
	String SparesURL = properties.getKey("SparesURL");
	String RetailURL = properties.getKey("RetailURL");

	
	 public HelperMethods(WebDriver driver) { 
	 this.driver = driver;
	 PageFactory.initElements(driver, this); 
	 }

	@BeforeSuite(alwaysRun = true)
	//@BeforeClass(alwaysRun = true)
	public void setup() {
		
		Reporter.log("=====Browser Session Started=====", true);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		//WebElement cashOnDelvery = driver.findElement(By.xpath(
				//"html/body/div[1]/div/div[2]/div[1]/div/div/div[4]/div[3]/div/div[9]/div[3]/div/div[1]/div/div"));

	}
	
	
	  @Test() public void checkout() throws InterruptedException {
	  driver.findElement(By.xpath("//*[contains(text(),'Add To Cart')]")).click();
	  Thread.sleep(2000); ////*[@title=�Songs Lis Applet'], _1T5jT
	  driver.findElement(By.xpath("//*[@title='View Cart']")).click();
	  Thread.sleep(2000); String
	  Productdetails=driver.findElement(By.className("_1T5jT")).getText().toString(
	  ); System.out.println("Product Details are "+Productdetails); }
	  
	  @Test() public void Login() throws InterruptedException {
	  driver.findElement(By.xpath("//span[contains(text(),'Login/Sign up')]")).
	  click(); Thread.sleep(2000); WebElement mobile =
	  driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
	  //mobile.click(); 
	  mobile.sendKeys("8447466512"); 
	  String entered_mobile =
	  mobile.getText(); System.out.println(entered_mobile);
	  driver.findElement(By.className("_1XPkN")).click();
	  driver.findElement(By.xpath("//input[@placeholder='One Time Password']")).
	  sendKeys("0000"); driver.findElement(By.className("_1XPkN")).click();
	  Thread.sleep(2000); }
	  
	  @Test() public void PlaceOrder() throws InterruptedException {
	  driver.findElement(By.xpath("//*[contains(text(),' Select')]")).click();
	  Thread.sleep(2000); JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1200)"); Thread.sleep(1000);
	  driver.findElement(By.xpath(
	  "html/body/div[1]/div/div[2]/div[1]/div/div/div[4]/div[3]/div/div[9]/div[3]/div/div[1]/div/div"
	  )).click(); Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[contains(text(),'PLACE ORDER')]")).click();
	  Thread.sleep(2000); }


	 
	
	@AfterSuite(alwaysRun = true)
	//@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();
	}

}
