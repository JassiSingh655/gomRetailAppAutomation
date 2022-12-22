package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutWithDetailingService extends SelectCarNoLogin {

	SelectCarNoLogin scl = new SelectCarNoLogin();

	@Test(priority = 3)
	public void addDetailingService() {

		scl.clickSelectCarButton();
		scl.HomePageVeirfy();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Detailing Services']"))))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//android.widget.TextView[@text='3M™ Car Rubbing & Polishing']"))))
				.click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")))).click();

	}

	@Test(priority = 4)
	public void checkoutwithoutaddon() {
		driver.findElement(By.id("gomechanic.retail:id/ivBackSDPF")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("gomechanic.retail:id/tvViewCartTextLOS")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String CartItem = driver.findElement(By.id("gomechanic.retail:id/tvCartItemTitle")).getText();
		System.out.println(CartItem);
		Assert.assertEquals("High Performance AC Service", CartItem);

	}

	@Test(priority = 5)
	public void checkout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Proceed to Checkout']"))))
				.click();

	}

	@Test(priority = 6)
	public void loginWithTrueCaller() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE WITH 8800906221']")))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 7)
	public void verifyItemTotal() {

		String itemTotal = driver.findElement(By.id("gomechanic.retail:id/tvTotalCartAmountCF")).getText();
		System.out.println("The cart total is " + itemTotal);
		scl.verticalSwipe();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void applyCouponGoappMoney() {

		driver.findElement(By.id("gomechanic.retail:id/tvCoupon")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.id("gomechanic.retail:id/tvApplyCouponCF[4]")).click();
//		List<WebElement> applyButtons = driver.findElements(By.id("gomechanic.retail:id/tvApplyCouponCF"));
//        System.out.println(applyButtons.size());
//		applyButtons.get(1).click();
		driver.findElement(By.id("gomechanic.retail:id/tvApplyCouponCF")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String couponSuccessMessage = driver.findElement(By.id("gomechanic.retail:id/tvCongratsDSCN")).getText();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(couponSuccessMessage, "GoAppMoney Applied");
		// driver.findElement(By.id("gomechanic.retail:id/tvCoupon")).click();
	}

	@Test(priority = 9)
	public void checkoutButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")))).click();

	}

	@Test(priority = 10)
	public void selectDateTime() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='CHECKOUT']")))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> nextDayDate = driver.findElements(By.id("gomechanic.retail:id/select_data_time_item_layout"));
		System.out.println(nextDayDate.size());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextDayDate.get(2).click();
		List<WebElement> nextDate = driver.findElements(By.id("gomechanic.retail:id/clTimeView"));
		System.out.println(nextDate.size());
		nextDate.get(1).click();
//		wait.until(ExpectedConditions.visibilityOf(
//				driver.findElement(By.id("gomechanic.retail:id/clTimeView]"))))
//				.click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Google Pay']")))).click();

	}

}
