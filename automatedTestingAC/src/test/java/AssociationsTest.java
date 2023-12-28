import POM.Association;
import POM.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssociationsTest {

    public WebDriver driver;
    public String testURL = Option.testURL;
    BrowserFactory browserFactory = new BrowserFactory();
    @BeforeMethod
    public void setupTest() {
        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(Option.browser));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
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
        DriverFactory.getInstance().closeBrowser();
    }

}
