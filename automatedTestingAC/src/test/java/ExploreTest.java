import POM.NameExplorer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExploreTest {

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
    public void exploreNameTest() {
        NameExplorer explorer = new NameExplorer(driver);
        driver.manage().window().maximize();
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
        driver.quit();
    }
}
