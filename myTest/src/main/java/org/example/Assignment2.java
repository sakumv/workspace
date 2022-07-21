package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException
    {
        // https://rahulshettyacademy.com/angularpractice/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        //==//input[@value='user']
        driver.findElement(By.xpath("//input[@value='user']")).click();

        //wait till alert to be dispalyed -- no alert only modal window
        WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(5));
        ww.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        //Click ok on the alert

        driver.findElement(By.id("okayBtn")).click();
        WebElement sElement = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select selectClass = new Select(sElement);
        selectClass.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        //Get the title and check whether it is "ProtoCommerce"

        //Wait till the page is loaded
        ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='my-4']")));

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("ProtoCommerce"))
        {
            System.out.println("Successfully logged in");
            addAllItems(driver);
        }
        //driver.quit();
    }

    public static void addAllItems(WebDriver driver)
    {
        List<WebElement> lsProducts =  driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (int i=0; i < lsProducts.size(); i++)
        {
            lsProducts.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }

    public static void fluWait(WebDriver driver)
    {
        driver.get("https://the-internet-herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("id='start")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
                {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else
                {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }

}
