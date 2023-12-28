import POM.NameExplorer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExploreTest {

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
    public void exploreNameTest() {
        NameExplorer explorer = new NameExplorer(driver);
        explorer.clickExploreButton();
        explorer.enterName("Tia");
        explorer.clickNameLink();
        String result = explorer.getExploredNameResult();
        Assert.assertEquals(result, "Ime Tia.");
        System.out.print(result);
    }

    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }
}
