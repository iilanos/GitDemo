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

public class validate extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("Initializing driver");
		String url=prop.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		LandingPage lp = new LandingPage(driver);
		//Thread.sleep(2000);
		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses");
		log.info("validation successfull");
			
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
