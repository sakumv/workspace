package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxSelection {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();

        List<WebElement> chkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement we : chkbox)
        {
            if (we.isSelected())
            {
                //get the id
                String str = we.getAttribute("id");
                String xp = "//label[@for='"+str+"']";
                System.out.println(driver.findElement(By.xpath(xp)).getText());
                //get the label and get text
            }
        }

        System.out.println();

        driver.quit();

    }



}
