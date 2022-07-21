package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleFramesAssignment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Assignment
        driver.get("http://the-internet.herokuapp.com/");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.linkText("Nested Frames"))).build().perform();
        driver.findElement(By.linkText("Nested Frames")).click();

//        Set<String> wh = driver.getWindowHandles();
//        Iterator<String> it = wh.iterator();
//
//        String parent = it.next();
//        String child = it.next();

//        driver.switchTo(child);
            driver.switchTo().frame(driver.findElement(By.name("frame-top")));
            driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
            System.out.println(driver.findElement(By.id("content")).getText());

            driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();


        //driver.close();

    }


}
