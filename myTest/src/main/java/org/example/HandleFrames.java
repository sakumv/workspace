package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleFrames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement we = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(we,target).build().perform();

        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Accept")).click();

        //Assignment
        //driver.close();

    }


}
