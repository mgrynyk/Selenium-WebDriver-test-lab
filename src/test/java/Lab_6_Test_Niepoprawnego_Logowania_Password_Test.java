import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab_6_Test_Niepoprawnego_Logowania_Password_Test {
    @Test
    public void incorrectLoginTestWrongPassword () {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://qaaghspclab.northeurope.cloudapp.azure.com/Account/Login?ReturnUrl=%2F");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test123");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        List<WebElement> validationErrors = driver.findElements(By.cssSelector(".validation-summary-errors>ul>li"));
        Assert.assertEquals(validationErrors.get(0).getText(), "Invalid login attempt.");
        Assert.assertEquals(validationErrors.size(), 1);

        driver.quit();
    }
}
