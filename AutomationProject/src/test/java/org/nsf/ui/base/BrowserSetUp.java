package org.nsf.ui.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

import org.apache.logging.log4j.*;


public class BrowserSetUp {

	Logger log = LogManager.getLogger(BrowserSetUp.class);
	public static WebDriver driver;

	public WebDriver getWebDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {			
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

        

		return driver;

	}
	

	

}
