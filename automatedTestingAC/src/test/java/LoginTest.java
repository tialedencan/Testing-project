import POM.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginTest {
    public WebDriver driver;
    public String testURL = Option.testURL;
    BrowserFactory browserFactory = new BrowserFactory();
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(Option.browser));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
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
        DriverFactory.getInstance().closeBrowser();
    }
}


