package project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class others {
	
	WebDriver driver;
		
		@BeforeTest
		public void setup() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SMART PC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://demo.nopcommerce.com/");
	}
	@Test(priority = 1)
	public void testHoverAndClick() throws InterruptedException {
	    Actions actions = new Actions(driver);
	    WebElement Electronics = driver.findElement(By.linkText("Electronics"));
	    actions.moveToElement(Electronics).build().perform();
		  Thread.sleep(3000);
		  WebElement Others = driver.findElement(By.linkText("Others"));
		  Others.click();
	}
	@Test(priority = 2)
	public void testScrollUsingJavaScript() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("Portable Sound Speakers")).click();
		  Thread.sleep(3000);
	}
	@Test(priority = 3)
	public void scrolldown1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		  Thread.sleep(4000);
		 
		  driver.findElement(By.xpath("//button[@id='add-to-cart-button-23']")).click();
		  Thread.sleep(4000);
	}
	@Test(priority = 4)
	public void shoppingtocart() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[@href='/cart']")).click();
		
	Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
	}
		
	@Test(priority = 5)
	public void checkout() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		
		driver.findElement(By.id("checkout")).click();
		  Thread.sleep(3000);
		 
		  TakesScreenshot shots = (TakesScreenshot)driver;
		  File file1 = shots.getScreenshotAs(OutputType.FILE);
		  File file2 = new File("C:\\Users\\SMART PC\\Pictures\\screenshot\\image.png");
		  FileUtils.copyFile(file1, file2);
		 
		 
		 
		 
		  driver.findElement(By.xpath(" //input[@id='Email']")).sendKeys("absf@com");
			Thread.sleep(3000);
			driver.findElement(By.xpath(" //input[@id='Password']")).sendKeys("abcd@121");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	@AfterTest
	public void cleanup() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
}
