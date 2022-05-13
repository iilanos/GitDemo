package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.id("email");
	private By password = By.id("password");
	private By checkBox = By.id("remember_me");
	private By login= By.xpath("//input[@type='submit']");
	private By forgotPassowrd = By.cssSelector("[href*='forgot_password']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public ForgotPasswordPage forgotPassowrd()
	{
		driver.findElement(forgotPassowrd).click();
		System.out.println("inside forgot passord");
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		return fp;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getCheckbox()
	{
		return driver.findElement(checkBox);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

}
