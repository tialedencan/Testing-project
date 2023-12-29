import POM.NameExplorer;
import POM.SurnameExplorer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SurnameTest {
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
    public void exploreSurnameTest() {
        SurnameExplorer explorer = new SurnameExplorer(driver);
        explorer.clickProjectsButton();
        explorer.clickSearchSurnamesBtn();
        explorer.enterSurname("Horvat");
        explorer.clickSurnameLink();
        String result = explorer.getExploredSurnameResult();
        System.out.print(result);
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }
}
