package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ecommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        String[] itemsNeeded= {"Carrot","Brocolli","Beetroot"};
        addItems(driver,itemsNeeded);
        checkOut(driver);
        //driver.quit();
    }
    public static  void addItems(WebDriver driver,String[] itemsNeeded)
    {
        int j=0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++)
        {
            //Extract the name of Vegetable from the text eg. Broccoli - 1 kg
            String[] name=products.get(i).getText().split("-");
            //format it to get actual vegetable name
            String formattedName=name[0].trim();
            //convert array into array list for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);
            //  check whether name you extracted is present in arrayList or not-
            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //If all items are added, no need to go through all the items in the for loop
                if(j==itemsNeeded.length)
                {
                    break;
                }
            }
        }
    }

    public static void checkOut(WebDriver driver)
    {
        WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        //-- //button[text()='PROCEED TO CHECKOUT']
        //Check if it is enabled
        WebElement we = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        if (we.isEnabled())
        {
            //Click on that element
            we.click();
            ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='promoCode']")));

            driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
            //Check whether promo is applied or not



            ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='promoInfo']")));

            //WebElement txtPromo = driver.findElement(By.xpath("//span[@class='promoInfo']"));

            String promoText = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
            System.out.println(promoText);
            if (promoText.equalsIgnoreCase("Code applied ..!"))
            {
                System.out.println("Promo Code is applied");
            }
        }



    }
}
