package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class amazontest {
	  WebDriver driver;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setup(String browser) throws MalformedURLException {
	        DesiredCapabilities dc = new DesiredCapabilities();

	        if (browser.equalsIgnoreCase("chrome")) {
	            dc.setBrowserName("chrome");
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            dc.setBrowserName("firefox");
	        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
	            dc.setBrowserName("MicrosoftEdge");
	        }

	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
	    }

	    @Test
	    public void openAmazon() {
	        driver.get("https://www.amazon.in");
	        System.out.println("Title: " + driver.getTitle());
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
