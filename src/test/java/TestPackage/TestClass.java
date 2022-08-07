package TestPackage;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public static WebDriver driver;
	
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
		}
		driver.manage().window().maximize();
		driver.get("https:google.com");
	}
}
