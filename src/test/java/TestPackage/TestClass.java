package TestPackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public static WebDriver driver;
	@FindBy(name = "q")
	private WebElement ele;
	
	@Parameters("browser")
	@Test
	public void demo(@Optional String browserName) {
		switch (browserName.toUpperCase()) {
		case "CHROME":
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.setHeadless(false);
			options.setAcceptInsecureCerts(true);
			driver = WebDriverManager.chromedriver().capabilities(options).create();
			break;
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
			default:driver = WebDriverManager.chromedriver().create();
		}
		driver.manage().window().maximize();
		driver.get("https:google.com");
		System.out.println("Browser Name"+browserName+"Opened successfully");
		PageFactory.initElements(driver, this);
		ele.sendKeys("https://amazon.com");
		ele.sendKeys(Keys.ENTER);
		System.out.println("Current Tab title------>"+driver.getTitle());
	}
//	@Parameters("browser")
//	@Test
	public void remoteDriver()  {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setBrowserName(broswerName);
//		cap.setPlatform(Platform.WIN8_1);
////		ChromeOptions options = new ChromeOptions();
////		options.setHeadless(false);
////		options.addArguments(Arrays.asList("-incognito"));
////		options.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
////		options.merge(cap);
//		driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"),cap);
//		
		driver.get("http://google.com");
		
	}
}
