import POM.Association;
import POM.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssociationsTest {

    public WebDriver driver;
    public String testURL = "https://actacroatica.com/hr/";

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
    public void checkAssociationTitle() {
        Login loginPOM = new Login(driver);
        Association associationPOM = new Association(driver);

        loginPOM.getToLoginForm();
        loginPOM.enterLoginInformation();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        associationPOM.goToProfile();
        associationPOM.navigateToAssociationPage();
        String associationTitle = associationPOM.getAssociationTitle();
        Assert.assertEquals(associationTitle,"Udruga za hrvatske studije");


    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
