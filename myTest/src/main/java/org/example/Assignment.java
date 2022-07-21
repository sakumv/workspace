package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
       // https://rahulshettyacademy.com/angularpractice/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Test Name");
        driver.findElement(By.name("email")).sendKeys("Test@name.org");
        //password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        ////input[@type='checkbox']
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Select dd = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        dd.selectByIndex(1);
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("07/16/2022");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        WebElement we = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
        //Check success message
        if (we.isDisplayed())
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }

        driver.quit();

    }



}
