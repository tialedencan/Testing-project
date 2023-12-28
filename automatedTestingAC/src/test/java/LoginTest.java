import POM.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public WebDriver driver;
    public String testURL = "https://actacroatica.com/hr/";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        String chromeDriverPath = System.getenv("ChromeDriverTesting");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(testURL);
    }
    @Test
    public void LoginUserTest() {
        Login loginPOM = new Login(driver);
        loginPOM.getToLoginForm();
        loginPOM.enterLoginInformation();
        WebElement profileElement = loginPOM.getProfileIconAndNameElement();

        Assert.assertEquals(profileElement,driver.findElement(By.xpath("//*[@id=\"stage\"]/nav/div/div[2]/ul/li/a")));
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}


