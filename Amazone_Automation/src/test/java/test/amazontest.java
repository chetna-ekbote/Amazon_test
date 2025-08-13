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
	        DesiredCapabilities cap = new DesiredCapabilities();

	        if (browser.equalsIgnoreCase("chrome")) {
	            cap.setBrowserName("chrome");
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            cap.setBrowserName("firefox");
	        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
	            cap.setBrowserName("MicrosoftEdge");
	        }

	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
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
