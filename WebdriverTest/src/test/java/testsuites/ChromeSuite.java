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
	public void KarinasTest() {

		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/login");
		driver.findElement(By.id("user_login")).sendKeys("meticulon_tester1");
		driver.findElement(By.id("user_password")).sendKeys("Rigorous");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("write a post")).click();
		driver.findElement(By.id ("category_271")).click();
		driver.findElement(By.id("article_title")).sendKeys("Test Post");
		driver.findElement(By.name("commit")).click();
		driver.get("http://meticulous-moose-1.herokuapp.com/");
		WebElement testPost = driver.findElement(By.xpath(".//*[contains(text(), 'Test Post')]"));
		assertTrue(testPost.isDisplayed());
		driver.findElement(By.linkText("Test Post")).click();
		driver.findElement(By.id("comment_author")).sendKeys("Testposter");
		driver.findElement(By.id("comment_email")).sendKeys("qelewe@amail.club");
		driver.findElement(By.id("comment_body")).sendKeys("Not spam");
		driver.findElement(By.id ("form-submit-button")).click();
		driver.get("http://meticulous-moose-1.herokuapp.com/admin/feedback");
		WebElement spam = driver.findElement(By.xpath(".//*[contains(text(), 'Not spam')]"));
		driver.findElement(By.linkText("Flag as spam")).click();
		driver.findElement(By.linkText("All Articles")).click();
		driver.findElement(By.linkText("Test Post")).click();
		driver.findElement(By.linkText("delete")).click();
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		WebElement userMenu = driver.findElement(By.id("user_menu"));
		Actions action = new Actions(driver);
		action.moveToElement(userMenu).moveToElement(driver.findElement(By.xpath(".//*[@id='user_menu']/li[3]/a")))
				.click().build().perform();
		
		
	}
	
/*	@Test
	public void Tester6Test() {
		// Log in for the first time
		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/login");
		driver.findElement(By.id("user_login")).sendKeys("meticulon_tester6");
		driver.findElement(By.id("user_password")).sendKeys("Rigorous");
		driver.findElement(By.className("btn-info")).click();
		Assert.assertTrue(driver.findElement(By.className("notice")).isDisplayed(), "Failed to log in!");

		// Add a blog post
		String blogTitle = "Tester6 Blog Post!";
		driver.get("http://meticulous-moose-1.herokuapp.com/admin/content/new");
		driver.findElement(By.id("article_title")).sendKeys(blogTitle);
		driver.findElement(By.id("article_body_and_extended")).sendKeys("This is a very short blog post.\n\nBut it has two lines in it!");
		driver.findElement(By.id("category_271")).click();
		driver.findElement(By.name("commit")).click();
		String blogTitleXpath = "//a[text()='" + blogTitle + "']";
		Assert.assertTrue(driver.findElement(By.xpath(blogTitleXpath)).isDisplayed(), "Failed to find the created blog post!");

		// Log out
		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/logout");
		Assert.assertTrue(driver.findElement(By.className("notice")).isDisplayed(), "Failed to log out!");
		
		// Check that the blog post appears
		driver.get("http://meticulous-moose-1.herokuapp.com/");
		Assert.assertTrue(driver.findElement(By.xpath(blogTitleXpath)).isDisplayed(), "Failed to find the blog post on the main page!");
		
		// Add a comment
		driver.findElement(By.xpath(blogTitleXpath)).click();
		driver.findElement(By.id("comment_author")).sendKeys("Tester6 Commenter");
		driver.findElement(By.id("comment_email")).sendKeys("tester6.email@example.com");
		driver.findElement(By.id("comment_url")).sendKeys("http://www.meticulon.com");
		driver.findElement(By.id("comment_body")).sendKeys("Spam comments are a threat to any blog.\n\n<b>Especially if that blog permits HTML.</b>");
		driver.findElement(By.id("form-submit-button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Tester6 Commenter']")).isDisplayed(), "Failed to find the created comment!");
		
		// Log in and flag the comment as spam
		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/login");
		driver.findElement(By.id("user_login")).sendKeys("meticulon_tester6");
		driver.findElement(By.id("user_password")).sendKeys("Rigorous");
		driver.findElement(By.className("btn-info")).click();
		Assert.assertTrue(driver.findElement(By.className("notice")).isDisplayed(), "Failed to log in!");
		driver.findElement(By.xpath("//a[text()='Total comments:']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Tester6 Commenter']")).isDisplayed(), "Failed to find the spam comment!");
		driver.findElement(By.xpath("//a[text()='Tester6 Commenter']/ancestor::tr//a[text()='Flag as spam']")).click();
		try {
			// ...because apparently Eclipse complains if a simple 2-second wait doesn't get exception handling.
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("//strong[text()='Tester6 Commenter']")).isDisplayed(), "Failed to flag the comment as spam!");
		
		// Delete the blog post and log out again
		driver.get("http://meticulous-moose-1.herokuapp.com/admin");
		driver.findElement(By.xpath("//a[text()='Your posts:']")).click();
		driver.findElement(By.xpath("//tr[td//text()='Tester6 Blog Post!']//a[text()='Delete']")).click();
		driver.findElement(By.className("btn-danger")).click();
		Assert.assertTrue(driver.findElement(By.className("notice")).isDisplayed(), "Failed to delete the blog post!");
		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/logout");
		Assert.assertTrue(driver.findElement(By.className("notice")).isDisplayed(), "Failed to log out at the end!");
	}
*/ 
	
/*	
	@Test
	public void M7Test() {

		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/login");
		
		WebElement parentLogin = driver.findElement(By.tagName("form"));
		parentLogin.findElement(By.id("user_login")).sendKeys("meticulon_tester7");
		parentLogin.findElement(By.id("user_password")).sendKeys("Rigorous");
		parentLogin.findElement(By.name("login")).click();
	
		WebElement articleElement = driver.findElement(By.linkText("New Article"));
		articleElement.click();
		
		WebElement parentLeft = driver.findElement(By.className("editor-left"));
		parentLeft.findElement(By.name("article[title]")).sendKeys("Ra!");
		parentLeft.findElement(By.id("article_body_and_extended")).sendKeys("From the primal chaos Ra spoke his name, thereby creating himself.");
		//Assert here to confirm article visible in admin panel
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement parentRight = driver.findElement(By.className("editor-right"));
		parentRight.findElement(By.id("category_1")).click();
		parentRight.findElement(By.name("commit")).click();
		
		driver.get("http://meticulous-moose-1.herokuapp.com");
		
		try {
			WebElement articleTitle = driver.findElement(By.linkText("Ra!"));
			Assert.assertTrue(articleTitle.isDisplayed());	
		}
		//This finally should be a catch
		finally {
		}
		
		WebElement articleTitle = driver.findElement(By.linkText("Ra!"));
		articleTitle.click();
		
		WebElement parentComment = driver.findElement(By.id("commentform"));
		parentComment.findElement(By.id("comment_author")).sendKeys("Ptah");
		parentComment.findElement(By.id("comment_email")).sendKeys("ptah@heliopolis.com");
		parentComment.findElement(By.id("comment_url")).sendKeys("https://en.wikipedia.org/wiki/Ptah");
		parentComment.findElement(By.id("comment_body")).sendKeys("Yeah, sure you were buddy. We all know what /really/ happened.");
		parentComment.findElement(By.id("form-submit-button")).click();
		//Assert here to confirm comment
		
		driver.get("http://meticulous-moose-1.herokuapp.com/admin/content");
		
		WebElement parentFind = driver.findElement(By.name("search[searchstring]"));
		parentFind.sendKeys("ra!");
		WebElement parentSearch = driver.findElement(By.name("commit"));
		parentSearch.click();
		WebElement spamParent = driver.findElement(By.id("articleList"));
		spamParent.findElement(By.linkText("1")).click();
		
		WebElement parentSpam = driver.findElement(By.linkText("Flag as spam"));
		parentSpam.click();
		
		//Assert here rather than sleep to visually confirm spam flag
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("http://meticulous-moose-1.herokuapp.com/admin/content");
		
		WebElement deletionParent = driver.findElement(By.id("articleList"));
		deletionParent.findElement(By.linkText("Ra!")).click();
		WebElement deletionRight = driver.findElement(By.className("editor-right"));
		deletionRight.findElement(By.linkText("delete")).click();
		WebElement deletionFinal = driver.findElement(By.xpath(".//*[@class='btn btn-danger']"));
		deletionFinal.click();
		//Assert here to confirm deletion
		
		driver.get("http://meticulous-moose-1.herokuapp.com/accounts/logout");		
		
	}
*/

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