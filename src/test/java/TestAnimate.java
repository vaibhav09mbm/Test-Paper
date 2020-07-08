import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAnimate {

	public static final String URL = "https;://jqueryui.com/animate/";
	public WebDriver driver;

	
	int ini_size;
	int fin_size;

	String col_ini;
	String col_fin;
	

	@BeforeTest
	public void testAnimate() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vaibhav.khandelwal\\eclipse-workspace\\test-paper\\src\\main\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		JqueryPage objAnimat = new JqueryPage(driver);
		driver.get(URL);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(objAnimat.frame));
		} catch (TimeoutException e) {
			System.out.println("Time out finding frame");
		}

		objAnimat.switchFrame();
		ini_size = objAnimat.sizeOfBox();
		col_ini = objAnimat.color();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(objAnimat.toggleBtn)).click();
		} catch (TimeoutException e) {
			System.out.println("Time out finding toggle btn");
		}

		wait.until(
				ExpectedConditions.not(ExpectedConditions.attributeToBe(objAnimat.animateSec, "overflow", "hidden")));

		fin_size = objAnimat.sizeOfBox();
		col_fin = objAnimat.color();
	}

	@Test (description="size of the box increases on click")
	public void secSizeTest() {
		Assert.assertEquals(ini_size < fin_size, true, "the size is not getting increased");
	}

	@Test (description="colour changes to Red on click")
	public void colorTest() {
		Assert.assertEquals(col_ini, "white", "The color background is not white");
		Assert.assertEquals(col_fin, "red", "The color background is not red");

	}

	@AfterTest
	public void close() {
		driver.close();
		driver.quit();

	}
}
