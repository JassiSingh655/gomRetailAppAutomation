package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class SelectCarNoLogin extends BaseClass {

	@Test(priority=1)
	public void clickSelectCarButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.id("gomechanic.retail:id/tvSelectYourCarOBF"))))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("gomechanic.retail:id/atvCarSearchSCF")).sendKeys("Creta");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Creta']")))).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Automatic']")))).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Petrol']")))).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public void HomePageVeirfy() {
		
			String homePagetext = driver.findElement(By.id("gomechanic.retail:id/tvHeaderCatHCS")).getText();
			System.out.println(homePagetext);
			Reporter.log("Veirfy Address is current address", true);
			String currentAddress = driver.findElement(By.id("gomechanic.retail:id/tvAddress")).getText();
			System.out.println(currentAddress);
		//	Assert.assertEquals(currentAddress, "Sector 41 "); //Will pass while in office only duhh!
			String selectedCar = driver.findElement(By.id("gomechanic.retail:id/tvCarNameSOSF")).getText();
			System.out.println(selectedCar);
			Assert.assertEquals(selectedCar, "CRETA"); //Will pass while in office only duh!
		}

	}


