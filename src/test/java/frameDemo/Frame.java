package frameDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frame {
	WebDriver driver;
	@Test
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/Users/fatemaislam/Downloads/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		driver.get("https://www.yahoo.com/");
		String myTitle=driver.getTitle();
		System.out.println("Title is " + myTitle);
		String expectedTitle="Yahoo";
       Assert.assertEquals(myTitle,expectedTitle);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='yui_3_18_0_4_1512678617793_1175']"));
		
		for(WebElement ele:list ){
			List<WebElement> element=driver.findElements(By.tagName("a"));
			System.out.println(ele.getAttribute("href"));
		}
		driver.findElement(By.xpath("//text()[.='More...']/ancestor::a[1]")).sendKeys("Nutrition");
	  driver.findElement(By.xpath(".//*[@id='uh-search-button']")).click();
	  List<WebElement>image=(List<WebElement>) driver.findElements(By.tagName("img"));
	  System.out.println("Number of images on page " +image.size());
	  driver.findElement(By.xpath(".//*[@id='yucs-login_signIn']")).click();
	  driver.findElement(By.id("login-signin")).click();
	  String actualError=driver.findElement(By.xpath(".//*[@id='username-error']")).getText();
	  String  expectedError= "Sorry, we don't recognize this email.";
	  Assert.assertTrue(actualError.contains(expectedError));
	}
	 
	}
	

