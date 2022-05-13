package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	private By email = By.id("email");
	private By submit = By.cssSelector("[name='commit']");
	
	public ForgotPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}

}
