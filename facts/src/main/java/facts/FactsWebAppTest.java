package facts;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FactsWebAppTest
{
	WebDriver driver;
	WebElement SelectTypeButton;
	
	@Before
	public void openFactsHomepage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/facts/");
		Assert.assertEquals("Software Engineering", driver.getTitle());
	}
	
	@Test
	public void SearchByAllTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("all"));
		
		SearchBar.sendKeys("Fallacy");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		WebElement SearchResult = driver.findElement(By.cssSelector("tr[valign='top'] td dl"));
		Assertions.assertEquals("You can manage quality into a software product.\n"
				+ "—Robert L. Glass\n"
				+ "—Fallacy\n"
				+ "Random test input is a good way to optimize testing.\n"
				+ "—Robert L. Glass\n"
				+ "—Fallacy", SearchResult.getText());
	}
	
	@Test
	public void SearchByTypeTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("type"));
		
		SearchBar.sendKeys("Fact");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		WebElement SearchResult = driver.findElement(By.cssSelector("tr[valign='top'] td dl"));
		Assertions.assertEquals("The working environment has a profound impact on productivity and quality.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "New tools/techniques cause an initial loss of productivity/quality.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Quality IS: a collection of attributes.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Quality is NOT: user satisfaction, meeting requirements, achieving cost/schedule, or reliability.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Software is usually tested at best at the 55-60 percent (branch) coverage level.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "100 percent coverage is still far from enough.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Test tools are essential, but many are rarely used.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Test automation rarely is. Most testing activities cannot be automated.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact", SearchResult.getText());
	}
	
	@Test
	public void SearchByTextTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("text"));
		
		SearchBar.sendKeys("You can manage quality into a software product.");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		WebElement SearchResult = driver.findElement(By.cssSelector("tr[valign='top'] td dl"));
		Assertions.assertEquals("You can manage quality into a software product.\n"
				+ "—Robert L. Glass\n"
				+ "—Fallacy", SearchResult.getText());
	}
	
	@Test
	public void SearchByAuthorTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("author"));
		
		SearchBar.sendKeys("Robert L. Glass");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		WebElement SearchResult = driver.findElement(By.cssSelector("tr[valign='top'] td dl"));
		Assertions.assertEquals("The working environment has a profound impact on productivity and quality.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "New tools/techniques cause an initial loss of productivity/quality.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Quality IS: a collection of attributes.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Quality is NOT: user satisfaction, meeting requirements, achieving cost/schedule, or reliability.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "You can manage quality into a software product.\n"
				+ "—Robert L. Glass\n"
				+ "—Fallacy\n"
				+ "Random test input is a good way to optimize testing.\n"
				+ "—Robert L. Glass\n"
				+ "—Fallacy\n"
				+ "Software is usually tested at best at the 55-60 percent (branch) coverage level.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "100 percent coverage is still far from enough.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Test tools are essential, but many are rarely used.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact\n"
				+ "Test automation rarely is. Most testing activities cannot be automated.\n"
				+ "—Robert L. Glass\n"
				+ "—Fact", SearchResult.getText());
	}
	
	@Test
	public void InvalidSearchTextTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("all"));
		
		SearchBar.sendKeys("John");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		WebElement SearchResult = driver.findElement(By.cssSelector("tr[valign='top'] td p"));
		Assertions.assertEquals("Not Found!", SearchResult.getText());
	}
	
	@Test
	public void NullSearchTextTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement SearchBar = driver.findElement(By.id("searchText"));
		SelectTypeButton = driver.findElement(By.id("all"));
		
		SearchBar.sendKeys("");
		Thread.sleep(500);
		SelectTypeButton.click();
		Thread.sleep(2000);
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@value='search']"));
		SearchButton.click();
		Thread.sleep(5000);
		
		//Returns an empty list if element does not exist
		Boolean resultExists = driver.findElements(By.cssSelector("tr[valign='top'] td dl")).size() > 0; 
		Assertions.assertFalse(resultExists);
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
}

