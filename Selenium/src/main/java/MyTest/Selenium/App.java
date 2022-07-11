package MyTest.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Get the URL
		
		driver.get("https://www.linkedin.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//Get the username and password
		driver.findElement(By.id("session_key")).sendKeys("trial@test.com");
		
		
		driver.findElement(By.id("session_password")).sendKeys("test@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.close();
		driver.quit();
		
		

	}
}
