package frameDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Paypal {
	WebDriver driver;
	@Test
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/Users/fatemaislam/Downloads/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.paypal.com");
	   String my_title=driver.getTitle();
	   System.out.println("Page title is " +my_title);
      String expected_title="Send Money, Pay Online or Set Up a Merchant Account - PayPal";
       Assert.assertEquals(my_title, expected_title);
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     WebElement ww=driver.findElement(By.xpath("//a[contains(@href,'signup')][text()='Sign Up']"));
 	
    ww.click();

	
}
}