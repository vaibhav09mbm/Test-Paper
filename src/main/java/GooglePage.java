import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	private WebDriver driver;
	
	GooglePage(WebDriver driver){
		this.driver = driver;
		
	}
	
	By ele = By.xpath("//input[@title='Search']");
	
	public void typeInSearch(String text)
	{
		driver.findElement(ele).sendKeys(text);
	}
}
