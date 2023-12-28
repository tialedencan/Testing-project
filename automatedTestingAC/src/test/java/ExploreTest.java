import POM.NameExplorer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExploreTest {

    public WebDriver driver;
    public String testURL = "https://actacroatica.com/hr/";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Faks\\DIPLOMSKI\\1.semestar\\MTTPP\\projekt\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "D:\\Faks\\DIPLOMSKI\\1.semestar\\MTTPP\\projekt\\geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void exploreNameTest() throws InterruptedException {
        NameExplorer explorer = new NameExplorer(driver);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        explorer.clickExploreButton();
        //Thread.sleep(5000);
        explorer.enterName("Tia");
        explorer.clickNameLink();
        String result = explorer.getExploredNameResult();
        Assert.assertEquals(result, "Ime Tia.");
        System.out.print(result);
    }

    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
    //Close browser and end the session
        driver.quit();
    }
}
