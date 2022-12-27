package facts;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {

//	@Test
//	public void test() throws InterruptedException{
//		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.wikipedia.org");
//		Assert.assertEquals("Wikipedia", driver.getTitle());
//		Thread.sleep(5000);
//	
//		WebElement link = driver.findElement(By.id("js-link-box-en"));
//		link.click();
//		Thread.sleep(5000);
//		Assert.assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
//	
//		driver.quit();
//	}
	
	
	
	
	
	
	
//}
	WebDriver driver; 
			
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		Assert.assertEquals("Wikipedia", driver.getTitle());
	}
	@Test
	public void testEnglishLink() throws InterruptedException{
		WebElement link = driver.findElement(By.id("js-link-box-en"));
		link.click();
		Thread.sleep(5000);
		Assert.assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
	}
	@Test
	public void testSearchBox() throws InterruptedException{
		WebElement searchBox = driver.findElement(By.id("searchInput"));;
		searchBox.sendKeys("Software testing");
		Thread.sleep(5000);
		searchBox.submit();
		Thread.sleep(5000);
		Assert.assertEquals("Software testing - Wikipedia", driver.getTitle());
	}
	@After
	public void closePage(){
		driver.quit();
	}
}