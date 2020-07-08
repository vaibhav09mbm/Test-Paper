import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NDTV {


	WebDriver driver;
	By headerMenu = By.xpath("//*[@class='nglobalnav']/a");
	By footerMenu = By.className("//*[@class='more']/a");
	
	public NDTV(WebDriver driver)
	{
		this.driver = driver;
	}

}
