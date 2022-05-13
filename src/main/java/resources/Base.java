package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		//FileInputStream fis = new FileInputStream("D:\\Sonali\\java workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			//execute in chrome driver
			//System.setProperty("webdriver.chrome.driver", "D:\\Sonali\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\chromedriver.exe"); 
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
				options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
			
		}
		else if(browserName.contains("firefox"))
		{
			//execute in filefox driver
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if(browserName.contains("headless"))
				options.addArguments("--headless");
			driver = new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	

}
