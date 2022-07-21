package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScopeAssignment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Assignment
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Get the count of links in the page
        List<WebElement> alist = driver.findElements(By.tagName("a"));
        int count = alist.size();
        System.out.println("No of links :- " + count);

        //GEt the links in footer section
        System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());

        //another way - get the footer driver
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //Get the links from first column of footer section
        WebElement miniDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int col1Count = miniDriver.findElements(By.tagName("a")).size();
        System.out.println(col1Count);

        //Click on each link and check for broken links
        List<WebElement> links = miniDriver.findElements(By.tagName("a"));

        for (int i=0; i<links.size(); i++)
        {
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            links.get(i).sendKeys(clickonlinkTab);
        }

        //Get all the window handles
        Set<String> winSet = driver.getWindowHandles();
        Iterator<String> itSet = winSet.iterator();
        itSet.next(); //ignore the parent handle
        while (itSet.hasNext())
        {
            //Current window get title
            String curHandle = itSet.next();
            driver.switchTo().window(curHandle);
            String title = driver.getTitle();
            if (title.contains("404"))
            {
                System.out.println("This is a broken link");
            }
            else
            {
                System.out.println(title);
            }
        }

        //driver.close();

    }


}
