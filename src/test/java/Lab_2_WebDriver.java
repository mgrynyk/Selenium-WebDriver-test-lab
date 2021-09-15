import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lab_2_WebDriver {
    @Test
    public void playWithWebDriver () {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://google.com" );

        WebElement agreeBtn = driver.findElement(By.cssSelector("#zV9nZe"));
        agreeBtn.click();

        WebElement searchTxt = driver.findElement(By.cssSelector( "input[name=q]"));
        searchTxt.sendKeys("Quality Assurance");

        WebElement searchBtn = driver.findElement(By.cssSelector( "input[value='Szukaj w Google']"));
        searchBtn.sendKeys(Keys.ENTER);

        driver.quit();




    }

}

