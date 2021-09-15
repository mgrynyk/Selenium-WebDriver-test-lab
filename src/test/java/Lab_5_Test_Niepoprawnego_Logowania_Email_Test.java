import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab_5_Test_Niepoprawnego_Logowania_Email_Test {
    @Test
    public void incorrectLoginTestWrongEmail(){
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://qaaghspclab.northeurope.cloudapp.azure.com/Account/Login?ReturnUrl=%2F");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();


        WebElement emailError = driver.findElement(By.cssSelector("#Email-error"));
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");

        List<WebElement> validationErrors = driver.findElements(By.cssSelector(".validation-summary-errors>ul>li"));
        boolean doesErrorExists = false;

        for (int i=0; i<validationErrors.size(); i++){
            if (validationErrors.get(i).getText().equals("The Email field is not a valid e-mail address.")){
                doesErrorExists = true;
                break;
            }
        }
        Assert.assertTrue(doesErrorExists);


    }
}
