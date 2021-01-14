import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	static ThreadLocal<RemoteWebDriver> rDriver = new ThreadLocal<>();
	URL url;

	public BrowserFactory(String driver) throws MalformedURLException {
		url = new URL("http://localhost:4444/wd/hub");
		// TODO Auto-generated constructor stub
		if (driver.equals("Chrome")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\vaibhav.khandelwal\\Downloads\\chromedriver_win32\\chromedriver.exe"
			 * );
			 */
			rDriver.set(new RemoteWebDriver(url,dc));

		}

		if (driver.equals("Firefox")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "C:\\Users\\vaibhav.khandelwal\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe"
			 * );
			 */
			rDriver.set(new RemoteWebDriver(url,dc));

		}

	}

	public WebDriver getDriver() {
		return rDriver.get();

	}

}
