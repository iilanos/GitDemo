package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class validateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("driver is initialized");
		//String url=prop.getProperty("url");
		driver.get(prop.getProperty("url"));
		log.info("Navigating to homepage");
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		//Assert.assertFalse(lp.getNavigationBar().isDisplayed());
		
		log.info("validation successfull");
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	

}
