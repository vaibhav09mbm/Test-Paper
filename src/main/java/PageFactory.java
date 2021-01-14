import org.openqa.selenium.WebDriver;

public class PageFactory {
	
	
	private WebDriver driver;
	 
	public PageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	
	public   GooglePage getGooglePage()
	{
		return (new GooglePage(driver));
	}

}
