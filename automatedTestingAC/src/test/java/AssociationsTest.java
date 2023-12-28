import POM.Association;
import POM.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.navigate().to(testURL);
    }
    @Test
    public void checkAssociationTitle() throws InterruptedException {
        Login loginPOM = new Login(driver);
        Association associationPOM = new Association(driver);

        loginPOM.getToLoginForm();
        loginPOM.enterLoginInformation();
        Thread.sleep(2000);
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
