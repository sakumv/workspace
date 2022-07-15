package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateDropdown {

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakuj\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

            //passenger update drop down // //div[@data-testid='home-page-travellers']
            WebElement we = driver.findElement(By.xpath("//div[@class='paxinfo']"));
            we.click();
            Thread.sleep(3000);
            //Get the passenger count and get the text
            //Click 2 times the adult to add 3 adults
            for (int i=0;i<2;i++)
            {
                driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
            }

            System.out.println(driver.findElement(By.xpath("//div[@class='paxinfo']")).getText());


            //Close the driver
            driver.quit();
        }

}
