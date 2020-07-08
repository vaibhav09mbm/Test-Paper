import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JqueryPage {
	
	WebDriver driver;
	By toggleBtn = By.xpath("//*[text()='Toggle Effect']");
	By animateSec = By.id("effect");
	By frame = By.className("demo-frame");

	public JqueryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickTogl()
	{
		driver.findElement(toggleBtn);
	}
	
	public int sizeOfBox()
	{
		String wdt = driver.findElement(animateSec).getCssValue("width");
		wdt = wdt.replace("px", "");
		return Integer.parseInt(wdt);
	}
	
	public String overflow()
	{
		String ovfl = driver.findElement(animateSec).getCssValue("overflow");
		return ovfl;
	}
	
	public String color()
	{
		String col = driver.findElement(animateSec).getCssValue("background-color");
		System.out.println(col);
		if(col.equals("rgba(255, 255, 255, 1)"))
		return "white";
		else 
			return "red";
	}
	
	public void switchFrame()
	{
		driver.switchTo().frame(driver.findElement(frame));

	}
}
