package pages;

import org.testng.annotations.Test;

import java.awt.Scrollbar;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccessoriesHomePage extends BaseClass {

	SelectCarNoLogin scl = new SelectCarNoLogin();

	@Test(priority = 3)
	public void openAccessoriesPage() throws InterruptedException {
		scl.clickSelectCarButton();
		scl.HomePageVeirfy();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Accessories']")))).click();
		String accessoriestextinSearchBox = driver.findElement(By.id("gomechanic.retail:id/alphaBetViewHF")).getText();
		System.out.println(accessoriestextinSearchBox);
		Thread.sleep(5000);
		Assert.assertEquals("Search Accessories", accessoriestextinSearchBox);
		System.out.println("The text in the searchbox is: " + accessoriestextinSearchBox);
		// print all subCat values
		List<WebElement> items = driver.findElements(By.id("gomechanic.retail:id/tvFeatureTitle"));
		Iterator<WebElement> itr = items.iterator();
		while (itr.hasNext()) {
			String subcat = itr.next().getAttribute("text");
			System.out.println(subcat + ": ");
		}
	}
}
