package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Actions a = new Actions(driver);
        WebElement mouOver = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        a.moveToElement(mouOver).build().perform();

        WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));

        //use .doubleClick() -- for selecting text
        //use .contextClick() -- for right click action

        a.moveToElement(searchText).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

    }






}
