import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStackOverflow {

	WebDriver driver;
    File driverExe = new File ("src/main/resources/chromedriver.exe");
	@Test
	public void testHref() throws InterruptedException {

		System.out.println(driverExe.getAbsolutePath());
		System.setProperty("webdriver.chrome.driver",
				driverExe.getAbsolutePath());

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://stackoverflow.com/tags");
		Stackover stackOve = new NDTV(driver);
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
