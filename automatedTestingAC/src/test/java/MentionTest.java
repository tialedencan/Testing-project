import POM.Mention;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class MentionTest {

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
    public void getToMentionPage() {
        Mention mention = new Mention(driver);
        mention.clickPreserveMemoryButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String result = mention.getMentionTitle();
        Assert.assertEquals(result, "Spomen");
        System.out.print(result);
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }
}
