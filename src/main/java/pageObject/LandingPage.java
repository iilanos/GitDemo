package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".pull-left>h2");
	private By navigationBar=By.cssSelector(".navigation.clearfix");
	
	//By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public LoginPage getLogin()
	{
		driver.findElement(signIn).click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	

}
