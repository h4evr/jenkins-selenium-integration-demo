package selenium;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nullable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUp() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setJavascriptEnabled(true);
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	}
	
	@Test
	public void test() {
		
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		
		element.sendKeys("Cheese!");
		
		element.submit();
		
		System.out.println("Page title is " + driver.getTitle());
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(@Nullable WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		
		System.out.println("Page title is " + driver.getTitle());
		
		driver.quit();
	}
}
