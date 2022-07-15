package org.example;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;



public class CheckboxSelection2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.id("checkBoxOption1")).click();
        driver.findElement(By.id("checkBoxOption2")).click();
        driver.findElement(By.id("checkBoxOption2")).click();

        List<WebElement> chkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(chkbox.size());



        for (WebElement we : chkbox)
        {

            if (we.isSelected())
            {
                we.click();
            }
        }

        System.out.println("All done");

        driver.quit();

    }



}
