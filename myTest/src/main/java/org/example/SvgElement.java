package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SvgElement {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://debeissat.nicolas.free.fr/svg3d.php");

        //Get the svg elements and find the attributes
        //Switch to iframe first - svg_result
        driver.switchTo().frame("svg_result");

        //xpath Element has to written as
        //  //*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path']
        // only for the ids like face
        // //*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]
        List<WebElement> lst = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"));
        for (WebElement e : lst)
        {
            System.out.println(e.getAttribute("d"));
        }

        driver.quit();

    }
}
