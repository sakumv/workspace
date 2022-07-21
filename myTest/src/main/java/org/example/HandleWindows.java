package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement blinkText = driver.findElement(By.xpath("//a[@class='blinkingText']"));
        blinkText.click();

        //get window handles and switch to other window
        Set<String> windoes = driver.getWindowHandles();

        Iterator<String> it = windoes.iterator();

        String parentWindoe = it.next();
        String childWindoe = it.next();

        driver.switchTo().window(childWindoe);
        String emailText = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();

        System.out.println(emailText);

        //get the email from the text
        String email = emailText.split("at")[1].trim().split(" ")[0];
        System.out.println(email);

        driver.switchTo().window(parentWindoe);
        driver.findElement(By.id("username")).sendKeys(email);

        driver.close();
        driver.quit();

    }


}
