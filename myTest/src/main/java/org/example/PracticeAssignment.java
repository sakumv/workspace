package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeAssignment
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Assignment
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Select any of the check box
        WebElement we =  driver.findElement(By.id("checkBoxOption3"));
        we.click();
        //Get the text
        String chkValue = we.getAttribute("value");

        //Set the value in the Drop down box
        we = driver.findElement(By.id("dropdown-class-example"));
        Select slct = new Select(we);
        slct.selectByValue(chkValue);

        //Enter the text in the text box
        driver.findElement(By.id("name")).sendKeys(chkValue);
        driver.findElement(By.id("alertbtn")).click();

        String txt = driver.switchTo().alert().getText();
        System.out.println(txt);
        if (txt.contains(chkValue))
        {
            System.out.println("Text available in alert message");
        }

        driver.switchTo().alert().accept();

        //

        driver.switchTo().defaultContent();
        //driver.close();

    }


}
