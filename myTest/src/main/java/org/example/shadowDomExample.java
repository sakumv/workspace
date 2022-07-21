package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowDomExample {

    public static void main (String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("chrome://downloads/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement srch = (WebElement) jse.executeScript("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");

        String js = "arguments[0].setAttribute('value','sakujay')";
        ((JavascriptExecutor)driver).executeScript(js,srch);

        driver.quit();

    }
}
