package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.chrome.ChromeDriver;

public class StaticDropdown {

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Currency Static drop down
        Select staticdropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));

        staticdropdown.selectByIndex(2);
        System.out.println(staticdropdown.getFirstSelectedOption().getText());
        staticdropdown.selectByValue("INR");
        System.out.println(staticdropdown.getFirstSelectedOption().getText());
        staticdropdown.selectByVisibleText("USD");
        System.out.println(staticdropdown.getFirstSelectedOption().getText());


        //Close the driver
        driver.quit();


    }

}
