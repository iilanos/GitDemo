package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		//String url=prop.getProperty("url");
		//driver.get(url);
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String password) throws IOException, InterruptedException {
		String url=prop.getProperty("url");
		driver.get(url);
		log.info("Navigated to homePage");
		LandingPage lp = new LandingPage(driver);
		Thread.sleep(1000);
		LoginPage loginPage=lp.getLogin();		
		
		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		//System.out.println(text);
		loginPage.getCheckbox().click();
		loginPage.getLogin().click();
		
		ForgotPasswordPage fp = loginPage.forgotPassowrd();
		Thread.sleep(2000);
		fp.getEmail().sendKeys("sonali@gmail.com");
		fp.getSubmit().click();
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//Column stands for different values per test
		
		//Object[][] data = new Object[2][3];
		Object[][] data = new Object[1][2];
		
		data[0][0]= "restricteduser@gmail.com";
		data[0][1]="password";
		/*data[0][2]="Restricted user";
		
		data[1][0]="nonrestricteduser@gmail.com";
		data[1][1]="5665758";
		data[1][2]="Non Restricted user";*/
		
		return data;
		
		
		
	}
	

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
