import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNDTV {

	WebDriver driver;

	@Test
	public void testHref() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vaibhav.khandelwal\\eclipse-workspace\\test-paper\\src\\main\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.ndtv.com/business");
		NDTV ndtvPage = new NDTV(driver);
		List<WebElement> href =
				driver.findElements(ndtvPage.headerMenu);
        href.stream().forEach(y -> System.out.println(y.getAttribute("href")));
        
        List<WebElement> hrefFoot =
				driver.findElements(ndtvPage.footerMenu);
        href.stream().forEach(y -> System.out.println(y.getAttribute("href")));
        
	}
	
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();

	}
}
