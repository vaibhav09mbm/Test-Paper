import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {

	PageFactory pf;
	BrowserFactory bf;

	@Test
	@Parameters({ "browser" })
	public void testGoogle(String browser) throws InterruptedException, MalformedURLException {
		bf = new BrowserFactory(browser);
		bf.getDriver().get("https://www.facebook.com");
		pf = new PageFactory(bf.getDriver());
		GooglePage gp = pf.getGooglePage();
		gp.typeInSearch("hello");
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(2000);
	}

	@Test
	@Parameters({ "browser" })
	public void testGoogleq(String browser) throws InterruptedException, MalformedURLException {
		bf = new BrowserFactory(browser);
		bf.getDriver().get("https://www.google.com");
		pf = new PageFactory(bf.getDriver());
		GooglePage gp = pf.getGooglePage();
		gp.typeInSearch("hello");
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(2000);
	}

	@AfterMethod
	public void cloq() {
		// bf.getDriver().close();
		System.out.println(Thread.currentThread().getName());
		bf.getDriver().quit();
	}
}
