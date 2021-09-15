import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class Lab_8_Test_Poprawnego_Logowania_POP_Test {
    private WebDriver driver;

    @Test
    public void correctLoginTest() {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qaaghspclab.northeurope.cloudapp.azure.com/Account/Login?ReturnUrl=%2F");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("test@test.com");
        loginPage.typePassword("Test1!");
        HomePage homePage = loginPage.submitLogin();

        Assert.assertTrue(homePage.welcomeElm.isDisplayed(), "Welcome element is not shown." );
        Assert.assertTrue(homePage.welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + homePage.welcomeElm.getText() + "' does not contain word 'Welcome'");

        driver.quit();
    }
}

