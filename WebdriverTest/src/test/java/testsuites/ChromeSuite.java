package testsuites;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ChromeSuite {

	private WebDriver driver;

	@Test
	public void testNewArticle() {
		
		// Mike adds a new comment for test purposes
		// Mike testing push to remote
		// After Merge comment added

		driver.get("https://meticulous-moose-1.herokuapp.com/accounts/login");

		// Find the element that's ID attribute is 'user_login' (Username)
		// Enter Username on the element found by above desc.

		driver.findElement(By.id("user_login")).sendKeys("meticulon_tester1");

		// Find the element that's ID attribute is 'user_password' (Password)
		// Enter Password on the element found by the above desc.

		driver.findElement(By.id("user_password")).sendKeys("Rigorous");

		// Now submit the form. WebDriver will find the form for us from the
		// element

		driver.findElement(By.name("login")).click();

		// Go to the new article page (note code below implemented using
		// findElements due to FF finding a non visible New Article link in the
		// top menu)

		List<WebElement> myElements = driver.findElements(By.linkText("New Article"));
		WebElement firstlink = myElements.get(0);
		firstlink.click();
		
		// Click the HTML tab
		driver.findElement(By.linkText("HTML")).click();

		// Add a title to the new article

		driver.findElement(By.id("article_title")).sendKeys("Selenium Test Article");

		// Add some body text to the article

		driver.findElement(By.id("article_body_and_extended")).sendKeys(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam vitae ante tincidunt, posuere enim non, suscipit urna. Duis interdum urna.");

		// Click the publish button

		driver.findElement(By.name("commit")).click();

		// Assert that the new article has been created

		WebElement newArticle = driver.findElement(By.linkText("Selenium Test Article"));
		Assert.assertTrue(newArticle.isDisplayed());

		// Find the element that's ID attribute is 'account_logout' (Log Out)

		WebElement userMenu = driver.findElement(By.id("user_menu"));
		Actions action = new Actions(driver);
		action.moveToElement(userMenu).moveToElement(driver.findElement(By.xpath(".//*[@id='user_menu']/li[3]/a")))
				.click().build().perform();

	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		// Create a new instance of the Chrome driver
		
		// Local webdriver 
		//System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\Meticulon\\Desktop\\Automation\\WebDriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		// Selenium Grid webdriver
		String nodeURL = "http://172.20.2.166:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception 

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}