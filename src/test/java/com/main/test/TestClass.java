package com.main.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.main.page.PageClass;
public class TestClass {

    private WebDriver driver;
    private PageClass google;

    @BeforeTest
    public void setUp() throws MalformedURLException { 
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("headless");
	//options.addArguments("disable-infobars"); // disabling infobars
	//options.addArguments("disable-extensions"); // disabling extensions
	//options.addArguments("disable-dev-shm-usage"); // overcome limited resource problems
	//options.addArguments("no-sandbox"); // Bypass OS security model
	//options.addArguments("remote-debugging-port=9222");
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        google = new PageClass(driver);
    }

    @Test
    public void googleTest() {
        google.goTo();
        //Assert.assertTrue(google.checkTitle("Store"));
	Assert.assertTrue(google.checkTitle("Player"));
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }   

}
