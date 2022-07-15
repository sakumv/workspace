package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class autoSuggestDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
        //Wait for the menu to be displayed
        List<WebElement> option = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        //Check to find desired String
        for(WebElement we : option)
        {
            if ((we.getText()).equalsIgnoreCase("India") )
            {
                //Select India and come out of Loop
                we.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
