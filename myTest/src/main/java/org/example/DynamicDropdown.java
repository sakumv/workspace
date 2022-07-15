package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicDropdown {


    public static void main( String[] args ) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        //Get the Departure City by clicking text and selecting Drop down
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //wait for the drop down to load
        Thread.sleep(2000);

        //Select Chennai from Dropdown
        driver.findElement(By.xpath("//a[@value='MAA']")).click();

        //Go to next Arrival and select the same drop down
        //ctl00_mainContent_ddl_destinationStation1_CTXT
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();

        driver.quit();

    }

}
