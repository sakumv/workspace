package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindowsAssignment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebElement newText = driver.findElement(By.linkText("Click Here"));
        newText.click();

        //get window handles and switch to other window
        Set<String> windoes = driver.getWindowHandles();

        Iterator<String> it = windoes.iterator();

        String parentWindoe = it.next();
        String childWindoe = it.next();

        driver.switchTo().window(childWindoe);
        String strTxt = driver.findElement(By.tagName("h3")).getText();

        System.out.println(strTxt);

        driver.switchTo().window(parentWindoe);
        String txt = driver.findElement(By.tagName("h3")).getText();
        System.out.println(txt);

        driver.close();
        driver.quit();

    }


}
